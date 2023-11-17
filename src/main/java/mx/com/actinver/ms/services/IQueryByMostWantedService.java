package mx.com.actinver.ms.services;

import mx.com.actinver.ms.beans.metadata.mostWanted.QueryByMostWantedRequestBean;
import mx.com.actinver.ms.beans.metadata.mostWanted.QueryByMostWantedResponseBean;

public interface IQueryByMostWantedService {

    QueryByMostWantedResponseBean queryMostWanted(QueryByMostWantedRequestBean searchType);

}