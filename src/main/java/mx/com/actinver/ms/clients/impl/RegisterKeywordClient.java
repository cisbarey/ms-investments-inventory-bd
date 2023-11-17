package mx.com.actinver.ms.clients.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import mx.com.actinver.ms.beans.BD.entities.DetailClientBean;
import mx.com.actinver.ms.beans.BD.entities.Fund_Keyword;
import mx.com.actinver.ms.beans.BD.entities.Keyword;
import mx.com.actinver.ms.beans.BD.repositories.IFund_Keyword;
import mx.com.actinver.ms.beans.BD.repositories.IFundsRepository;
import mx.com.actinver.ms.beans.BD.repositories.IKeyword;
import mx.com.actinver.ms.beans.client.registerKeyword.RegisterKeywordRequestClientBean;
import mx.com.actinver.ms.beans.registerKeyword.RegisterKeywordResponseBean;
import mx.com.actinver.ms.beans.registerKeyword.RelatedKeyword;
import mx.com.actinver.ms.clients.IRegisterKeywordClient;
import mx.com.actinver.ms.config.HttpHeadersConfig;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;

@Component
@Slf4j
public class RegisterKeywordClient extends HttpHeadersConfig implements IRegisterKeywordClient {

    @Autowired
    private IKeyword keywordBD;

    @Autowired
    private IFund_Keyword fund_KeywordBD;

    @Autowired
    private IFundsRepository fundBD;

    @Override
    public RegisterKeywordResponseBean registrationKeyword(RegisterKeywordRequestClientBean registerKeywordRequestClientBean) {

        RegisterKeywordResponseBean registerKeywordResponseBean = new RegisterKeywordResponseBean();

        try {

            Keyword existKeyword = keywordBD.findFirstByName(registerKeywordRequestClientBean.getKeyword());

            if (existKeyword != null) {
            	throw new SuperMarketFundBusinessRuleException("Invalid input params.",ErrorExceptions.PRECONDITION_FAILED);
            }

            Keyword keyword = new Keyword();
            keyword.setName(registerKeywordRequestClientBean.getKeyword());
            keyword.setCreationDate(registerKeywordRequestClientBean.getCreationDate());
            keyword.setCreationUser(registerKeywordRequestClientBean.getCreationUser());

            List<RelatedKeyword> relatedKeywords = registerKeywordRequestClientBean.getRelated();

            if (relatedKeywords.isEmpty()) {
            	throw new SuperMarketFundBusinessRuleException("Invalid input params.",ErrorExceptions.PRECONDITION_FAILED);
            }

            boolean allFundsExist = true;
            for (RelatedKeyword relatedKeyword : relatedKeywords) {
                DetailClientBean fund = fundBD.findByIsin(relatedKeyword.getIsin());
                if (fund == null) {
                    allFundsExist = false;
                    break;
                }
            }

            if (!allFundsExist) {
                // No guardar la keyword en la base de datos
            	throw new SuperMarketFundBusinessRuleException("Invalid input params.",ErrorExceptions.PRECONDITION_FAILED);
            } else {
                // Guardar la keyword en la base de datos
                keywordBD.save(keyword);

                Keyword lastInsertKeyword = keywordBD.findLastKeyword().get(0);

                for (RelatedKeyword relatedKeyword : relatedKeywords) {
                    DetailClientBean fund = fundBD.findByIsin(relatedKeyword.getIsin());
                    saveInstrumentsToDB(relatedKeyword.getIsin(), relatedKeyword.getFundType(), lastInsertKeyword, fund);
                }

                registerKeywordResponseBean.setMessage("The keyword was successfully registered.");
                registerKeywordResponseBean.setType("SUCCESS");
            }

        } catch (Exception ex) {
        	throw new SuperMarketFundBusinessRuleException("Invalid input params.",ErrorExceptions.PRECONDITION_FAILED);
        }

        return registerKeywordResponseBean;
    }

    private void saveInstrumentsToDB(String isin, String typeInstrument, Keyword lastInsertKeyword, DetailClientBean fund) {

        Fund_Keyword fundkeyword = new Fund_Keyword();

        fundkeyword.setTypeInstrument(typeInstrument);
        fundkeyword.setIsinFund(isin);
        fundkeyword.setTicker(fund.getTicker());
        fundkeyword.setFirmname(fund.getFirmName());
        fundkeyword.setKeywordId(lastInsertKeyword);

        fund_KeywordBD.save(fundkeyword);
    }
}