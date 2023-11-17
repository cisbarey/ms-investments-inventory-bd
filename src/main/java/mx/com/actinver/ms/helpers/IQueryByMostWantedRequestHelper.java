package mx.com.actinver.ms.helpers;

import mx.com.actinver.ms.beans.client.metadata.mostWanted.QueryByMostWantedClientRequestBean;
import mx.com.actinver.ms.beans.metadata.mostWanted.QueryByMostWantedRequestBean;

public interface IQueryByMostWantedRequestHelper {

    QueryByMostWantedClientRequestBean toRequest(QueryByMostWantedRequestBean searchType);

}