package mx.com.actinver.ms.helpers.impl;

import mx.com.actinver.ms.beans.BD.entities.LiquidityClientBean;
import mx.com.actinver.ms.beans.BD.entities.RegisterLiquidityResponseClientBean;
import mx.com.actinver.ms.beans.query.RegisterLiquidityRequestBean;
import mx.com.actinver.ms.beans.query.RegisterLiquidityResponseBean;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;
import mx.com.actinver.ms.helpers.IRegisterLiquidityHelper;
import org.springframework.stereotype.Component;

@Component
public class RegisterLiquidityHelper implements IRegisterLiquidityHelper {

    @Override
    public LiquidityClientBean toRequest(RegisterLiquidityRequestBean requestBean) {
        LiquidityClientBean liquidityClientBean = new LiquidityClientBean();

        if (requestBean.getIsin() == null || requestBean.getIsin().trim().equals("")) {
            throw new SuperMarketFundBusinessRuleException("isin is required", ErrorExceptions.INVALID_PARAMS);
        }

        if (requestBean.getType() == null || requestBean.getType().trim().equals("")) {
            throw new SuperMarketFundBusinessRuleException("type is required", ErrorExceptions.INVALID_PARAMS);
        }

        liquidityClientBean.setIsin(requestBean.getIsin());
        liquidityClientBean.setType(requestBean.getType());
        liquidityClientBean.setCreationDate(requestBean.getCreationDate());
        liquidityClientBean.setCreationUser(requestBean.getCreationUser());
        return liquidityClientBean;
    }

    @Override
    public RegisterLiquidityResponseBean toResponse(RegisterLiquidityResponseClientBean responseClientBean) {
        RegisterLiquidityResponseBean responseBean = new RegisterLiquidityResponseBean();
        responseBean.setMessage(responseClientBean.getMessage());
        return responseBean;
    }

}