package mx.com.actinver.ms.clients;

import java.util.Map;

import mx.com.actinver.ms.beans.BD.entities.HorizonClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryHorizonResponseClientBean;


public interface IQueryHorizonClient {

    QueryHorizonResponseClientBean getClient(HorizonClientBean requestClientBean,Map<String,String> headers);

}

