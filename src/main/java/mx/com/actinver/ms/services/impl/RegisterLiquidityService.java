package mx.com.actinver.ms.services.impl;

import mx.com.actinver.ms.beans.BD.entities.LiquidityClientBean;
import mx.com.actinver.ms.beans.BD.entities.RegisterLiquidityResponseClientBean;
import mx.com.actinver.ms.beans.query.RegisterLiquidityRequestBean;
import mx.com.actinver.ms.beans.query.RegisterLiquidityResponseBean;
import mx.com.actinver.ms.clients.IRegisterLiquidityClient;
import mx.com.actinver.ms.helpers.IRegisterLiquidityHelper;
import mx.com.actinver.ms.services.IRegisterLiquidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegisterLiquidityService implements IRegisterLiquidityService {

    @Autowired
    private IRegisterLiquidityClient liquidityClient;

    @Autowired
    private IRegisterLiquidityHelper liquidityHelper;

    @Override
    public RegisterLiquidityResponseBean getService(RegisterLiquidityRequestBean requestBean) {
        LiquidityClientBean requestClientBean = liquidityHelper.toRequest(requestBean);
        RegisterLiquidityResponseClientBean responseClientBean = liquidityClient.getClient(requestClientBean);

        return liquidityHelper.toResponse(responseClientBean);
    }

}