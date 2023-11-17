package mx.com.actinver.ms.clients;

import mx.com.actinver.ms.beans.client.metadata.mostWanted.QueryByMostWantedClientRequestBean;
import mx.com.actinver.ms.beans.metadata.mostWanted.QueryByMostWantedResponseBean;


public interface IQueryByMostWantedClient {

    QueryByMostWantedResponseBean queryMostWanted(QueryByMostWantedClientRequestBean queryByMostWantedClientRequestBean);

}