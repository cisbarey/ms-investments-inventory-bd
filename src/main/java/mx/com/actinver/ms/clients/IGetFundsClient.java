package mx.com.actinver.ms.clients;

import java.util.Map;

import mx.com.actinver.ms.beans.BD.entities.GetFundsRequestClientBean;
import mx.com.actinver.ms.beans.BD.entities.GetFundsResponseClientBean;

public interface IGetFundsClient {

	GetFundsResponseClientBean getFunds(GetFundsRequestClientBean requestClientBean,Map<String,String> headers);

}

