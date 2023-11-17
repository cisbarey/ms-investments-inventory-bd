package mx.com.actinver.ms.clients.impl;

import lombok.extern.slf4j.Slf4j;
import mx.com.actinver.ms.beans.BD.entities.Fund_Keyword;
import mx.com.actinver.ms.beans.BD.entities.Keyword;
import mx.com.actinver.ms.beans.BD.repositories.IFund_Keyword;
import mx.com.actinver.ms.beans.BD.repositories.IKeyword;
import mx.com.actinver.ms.beans.queryKeyword.QueryKeyword;
import mx.com.actinver.ms.beans.queryKeyword.QueryKeywordResponseBean;
import mx.com.actinver.ms.clients.IQueryKeywordClient;
import mx.com.actinver.ms.config.HttpHeadersConfig;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.exceptions.SuperMarketFundNotFoundException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class QueryKeywordClient extends HttpHeadersConfig implements IQueryKeywordClient {

    @Autowired
    private IKeyword keywordBD;

    @Autowired
    private IFund_Keyword fund_KeywordBD;

    @Override
    public QueryKeywordResponseBean queryKeyword(String keyword) {

        List<Keyword> keywordInfoList = keywordBD.findByNameContaining(keyword);

        if (keywordInfoList.isEmpty()) {
            throw new SuperMarketFundNotFoundException("Not found.", ErrorExceptions.NOT_FOUND);
        }

        List<Fund_Keyword> fundKeywordInfoList = new ArrayList<>();
        for (Keyword keywordInfo : keywordInfoList) {
            fundKeywordInfoList.addAll(fund_KeywordBD.findByKeywordId(keywordInfo));
        }

        QueryKeywordResponseBean queryKeywordResponseBean = new QueryKeywordResponseBean();
        queryKeywordResponseBean.setKeyword(keyword);
        queryKeywordResponseBean.setRelated(toRelated(fundKeywordInfoList));
        queryKeywordResponseBean.setMessage("The keyword was queried successfully.");
        queryKeywordResponseBean.setType("SUCCESS");

        return queryKeywordResponseBean;
    }

    private List<QueryKeyword> toRelated(List<Fund_Keyword> fundKeywordInfo) {
        if (fundKeywordInfo != null && !fundKeywordInfo.isEmpty()) {
            return fundKeywordInfo.stream().map(this::toSetDataRelated).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private QueryKeyword toSetDataRelated(Fund_Keyword fundKeyword) {
        QueryKeyword queryKeyword = new QueryKeyword();

        Keyword keyword = keywordBD.findFirstByKeywordId(fundKeyword.getKeywordId().getKeywordId());
        String keywordName = keyword.getName();
        queryKeyword.setKeyword(keywordName);
        queryKeyword.setIsin(fundKeyword.getIsinFund());
        queryKeyword.setTicker(fundKeyword.getTicker());
        queryKeyword.setFirmname(fundKeyword.getFirmname());
        queryKeyword.setInstrumentType(fundKeyword.getTypeInstrument());

        return queryKeyword;

    }

}