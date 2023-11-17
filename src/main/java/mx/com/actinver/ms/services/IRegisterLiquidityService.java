package mx.com.actinver.ms.services;

import mx.com.actinver.ms.beans.query.RegisterLiquidityRequestBean;
import mx.com.actinver.ms.beans.query.RegisterLiquidityResponseBean;

public interface IRegisterLiquidityService {

    RegisterLiquidityResponseBean getService(RegisterLiquidityRequestBean requestBean);

}