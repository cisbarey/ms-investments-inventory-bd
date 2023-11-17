package mx.com.actinver.ms.clients.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import mx.com.actinver.ms.beans.BD.entities.Keyword;
import mx.com.actinver.ms.beans.BD.repositories.IFund_Keyword;
import mx.com.actinver.ms.beans.BD.repositories.IKeyword;
import mx.com.actinver.ms.beans.deleteKeyword.DeleteKeywordResponseBean;
import mx.com.actinver.ms.clients.IDeleteKeywordClient;
import mx.com.actinver.ms.config.HttpHeadersConfig;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.exceptions.SuperMarketFundNotFoundException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;

@Component
@Slf4j
public class DeleteKeywordClient extends HttpHeadersConfig implements IDeleteKeywordClient {

    @Autowired
    private IKeyword keywordBD;

    @Autowired
    private IFund_Keyword fund_KeywordBD;

    @Transactional
    @Override
    public DeleteKeywordResponseBean deleteKeyword(String keyword) {

        DeleteKeywordResponseBean deleteKeywordResponseBean = new DeleteKeywordResponseBean();

        Keyword infoKeyword = keywordBD.findByName(keyword);

        if (infoKeyword == null) {
            throw new SuperMarketFundNotFoundException("Keyword not found.", ErrorExceptions.NOT_FOUND);
        }

        fund_KeywordBD.deleteAllByKeywordId(infoKeyword);
        keywordBD.deleteByKeywordId(infoKeyword.getKeywordId());

        deleteKeywordResponseBean.setMessage("The keyword was successfully deleted.");
        deleteKeywordResponseBean.setType("SUCCESS");

        return deleteKeywordResponseBean;
    }
}