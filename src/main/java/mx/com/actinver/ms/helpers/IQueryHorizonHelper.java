package mx.com.actinver.ms.helpers;

import mx.com.actinver.ms.beans.BD.entities.HorizonClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryHorizonResponseClientBean;
import mx.com.actinver.ms.beans.query.QueryHorizonResponseBean;

public interface IQueryHorizonHelper {

	HorizonClientBean toRequest(String  isin);
	
	QueryHorizonResponseBean toResponse(QueryHorizonResponseClientBean responseClientBean);
	
	

}
