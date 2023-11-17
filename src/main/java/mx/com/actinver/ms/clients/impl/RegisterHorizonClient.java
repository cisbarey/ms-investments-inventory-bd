package mx.com.actinver.ms.clients.impl;

import mx.com.actinver.ms.beans.BD.entities.DetailClientBean;
import mx.com.actinver.ms.beans.BD.entities.HorizonClientBean;
import mx.com.actinver.ms.beans.BD.entities.RegisterHorizonResponseClientBean;
import mx.com.actinver.ms.beans.BD.repositories.IFundsRepository;
import mx.com.actinver.ms.beans.BD.repositories.IHorizonRepository;
import mx.com.actinver.ms.clients.IRegisterHorizonClient;
import mx.com.actinver.ms.config.HttpHeadersConfig;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.exceptions.SuperMarketFundNotFoundException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RegisterHorizonClient extends HttpHeadersConfig implements IRegisterHorizonClient {


    @Autowired
    private IHorizonRepository horizonRepository;

    @Autowired
    private IFundsRepository fundsRepository;

    @Override
    public RegisterHorizonResponseClientBean getClient(HorizonClientBean requestClientBean, Map<String, String> headers) {

        DetailClientBean existIsin = fundsRepository.findByIsin(requestClientBean.getIsin());

        if (existIsin != null) {
            RegisterHorizonResponseClientBean horizonResponseBean = new RegisterHorizonResponseClientBean();
            try {
                horizonRepository.save(requestClientBean);
                horizonResponseBean.setMessage("Success");
            } catch (Exception e) {
                throw new SuperMarketFundBusinessRuleException("Invalid input params.", ErrorExceptions.PRECONDITION_FAILED);
            }
            return horizonResponseBean;
        } else {
            throw new SuperMarketFundNotFoundException("Not found isin.", ErrorExceptions.NOT_FOUND);

        }

    }

}