package mx.com.actinver.ms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.actinver.ms.beans.queryKeyword.QueryKeywordResponseBean;
import mx.com.actinver.ms.clients.IQueryKeywordClient;
import mx.com.actinver.ms.services.IQueryKeywordService;

@Service
public class QueryKeywordService implements IQueryKeywordService {

    @Autowired
    private IQueryKeywordClient queryKeywordClient;

    @Override
    public QueryKeywordResponseBean queryKeyword(String keyword) {
        QueryKeywordResponseBean queryKeywordResponseBean = queryKeywordClient.queryKeyword(keyword);
        return queryKeywordResponseBean;

    }

}