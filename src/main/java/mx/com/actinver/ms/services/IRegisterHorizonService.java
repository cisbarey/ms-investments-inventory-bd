package mx.com.actinver.ms.services;

import java.util.Map;

import mx.com.actinver.ms.beans.query.RegisterHorizonRequestBean;
import mx.com.actinver.ms.beans.query.RegisterHorizonResponseBean;

public interface IRegisterHorizonService {

    RegisterHorizonResponseBean getService(RegisterHorizonRequestBean requestBean,Map<String,String> headers);

}