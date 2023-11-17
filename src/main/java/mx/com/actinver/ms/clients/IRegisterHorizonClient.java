package mx.com.actinver.ms.clients;

import java.util.Map;

import mx.com.actinver.ms.beans.BD.entities.HorizonClientBean;
import mx.com.actinver.ms.beans.BD.entities.RegisterHorizonResponseClientBean;


public interface IRegisterHorizonClient {

    RegisterHorizonResponseClientBean getClient(HorizonClientBean requestClientBean,Map<String,String> headers);

}

