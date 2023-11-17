package mx.com.actinver.ms.clients.impl;

import mx.com.actinver.ms.beans.BD.entities.LiquidityClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryLiquidityResponseClientBean;
import mx.com.actinver.ms.beans.BD.repositories.ILiquidityRepository;
import mx.com.actinver.ms.clients.IQueryLiquidityClient;
import mx.com.actinver.ms.config.HttpHeadersConfig;
import mx.com.actinver.ms.exceptions.SuperMarketFundNotFoundException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class QueryLiquidityClient extends HttpHeadersConfig implements IQueryLiquidityClient {

    @Autowired
    private ILiquidityRepository liquidityRepository;

    @Override
    public QueryLiquidityResponseClientBean getClient(LiquidityClientBean requestClientBean) {
        QueryLiquidityResponseClientBean liquidityResponseBean = new QueryLiquidityResponseClientBean();
        Optional<LiquidityClientBean> liquidityBean = liquidityRepository.findById(requestClientBean.getIsin());

        if (!liquidityBean.isPresent()) {
            throw new SuperMarketFundNotFoundException("Not found.", ErrorExceptions.NOT_FOUND);
        }

        liquidityResponseBean.setType(liquidityBean.get().getType());

        return liquidityResponseBean;
    }
}