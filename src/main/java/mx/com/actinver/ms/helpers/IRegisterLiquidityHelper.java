package mx.com.actinver.ms.helpers;

import mx.com.actinver.ms.beans.BD.entities.LiquidityClientBean;
import mx.com.actinver.ms.beans.BD.entities.RegisterLiquidityResponseClientBean;
import mx.com.actinver.ms.beans.query.RegisterLiquidityRequestBean;
import mx.com.actinver.ms.beans.query.RegisterLiquidityResponseBean;

public interface IRegisterLiquidityHelper {

    LiquidityClientBean toRequest(RegisterLiquidityRequestBean requestBean);

    RegisterLiquidityResponseBean toResponse(RegisterLiquidityResponseClientBean responseClientBean);

}