package mx.com.actinver.ms.services;

import java.util.Map;

import mx.com.actinver.ms.beans.query.GetFundsRequestBean;
import mx.com.actinver.ms.beans.query.GetFundsResponseBean;

public interface IGetFundsService {

	GetFundsResponseBean getFunds(GetFundsRequestBean requestBean,Map<String,String> headers);

}

