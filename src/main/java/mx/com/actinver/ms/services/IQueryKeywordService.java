package mx.com.actinver.ms.services;

import mx.com.actinver.ms.beans.queryKeyword.QueryKeywordResponseBean;

public interface IQueryKeywordService {

    QueryKeywordResponseBean queryKeyword(String keyword);

}