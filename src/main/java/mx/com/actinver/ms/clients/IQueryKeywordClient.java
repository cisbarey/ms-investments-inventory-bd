package mx.com.actinver.ms.clients;

import mx.com.actinver.ms.beans.queryKeyword.QueryKeywordResponseBean;

public interface IQueryKeywordClient {

    QueryKeywordResponseBean queryKeyword(String keyword);

}

