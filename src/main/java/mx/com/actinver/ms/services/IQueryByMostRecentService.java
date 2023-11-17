package mx.com.actinver.ms.services;

import mx.com.actinver.ms.beans.metadata.mostRecent.QueryByMostRecentRequestBean;
import mx.com.actinver.ms.beans.metadata.mostRecent.QueryByMostRecentResponseBean;

public interface IQueryByMostRecentService {

    QueryByMostRecentResponseBean queryMostRecent(QueryByMostRecentRequestBean queryByMostRecentRequestBean);

}