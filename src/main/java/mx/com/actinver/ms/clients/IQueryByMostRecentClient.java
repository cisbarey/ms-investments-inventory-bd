package mx.com.actinver.ms.clients;

import mx.com.actinver.ms.beans.metadata.mostRecent.QueryByMostRecentResponseBean;

import java.util.List;


public interface IQueryByMostRecentClient {

    QueryByMostRecentResponseBean queryMostRecent(String customerId, String searchType, List<String> isins);

}