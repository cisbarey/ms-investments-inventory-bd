package mx.com.actinver.ms.clients;

import java.util.Map;

import mx.com.actinver.ms.beans.BD.entities.QueryByRegionRequestClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryByRegionResponseClientBean;



public interface IQueryByRegionClient {

	QueryByRegionResponseClientBean getClient(QueryByRegionRequestClientBean requestClientBean,Map<String,String> headers);

}

