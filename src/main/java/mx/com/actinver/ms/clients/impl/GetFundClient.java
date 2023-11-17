package mx.com.actinver.ms.clients.impl;

import mx.com.actinver.ms.beans.BD.entities.DetailClientBean;
import mx.com.actinver.ms.beans.BD.repositories.IFundsRepository;
import mx.com.actinver.ms.clients.IGetFundClient;
import mx.com.actinver.ms.config.HttpHeadersConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetFundClient extends HttpHeadersConfig implements IGetFundClient {

    @Autowired
    private IFundsRepository fundsRepository;

    @Override
    public DetailClientBean getFund(String isin) {
        return fundsRepository.findByIsin(isin);
    }

}