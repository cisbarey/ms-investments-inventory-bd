package mx.com.actinver.ms.clients.impl;

import mx.com.actinver.ms.beans.BD.entities.LiquidityClientBean;
import mx.com.actinver.ms.beans.BD.entities.RegisterLiquidityResponseClientBean;
import mx.com.actinver.ms.beans.BD.repositories.ILiquidityRepository;
import mx.com.actinver.ms.clients.IRegisterLiquidityClient;
import mx.com.actinver.ms.config.HttpHeadersConfig;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterLiquidityClient extends HttpHeadersConfig implements IRegisterLiquidityClient {

    @Autowired
    private ILiquidityRepository liquidityRepository;

    @Override
    public RegisterLiquidityResponseClientBean getClient(LiquidityClientBean requestClientBean) {
        RegisterLiquidityResponseClientBean liquidityResponseBean = new RegisterLiquidityResponseClientBean();
        try {
            liquidityRepository.save(requestClientBean);
            liquidityResponseBean.setMessage("Success");
        } catch (Exception e) {
            throw new SuperMarketFundBusinessRuleException("Invalid input params.", ErrorExceptions.PRECONDITION_FAILED);
        }
        return liquidityResponseBean;
    }

}