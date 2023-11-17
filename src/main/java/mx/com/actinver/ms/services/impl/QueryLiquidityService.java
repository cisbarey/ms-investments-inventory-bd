package mx.com.actinver.ms.services.impl;

import mx.com.actinver.ms.beans.BD.entities.LiquidityClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryLiquidityResponseClientBean;
import mx.com.actinver.ms.beans.query.QueryLiquidityResponseBean;
import mx.com.actinver.ms.clients.IQueryLiquidityClient;
import mx.com.actinver.ms.helpers.IQueryLiquidityHelper;
import mx.com.actinver.ms.services.IQueryLiquidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QueryLiquidityService implements IQueryLiquidityService {

    @Autowired
    private IQueryLiquidityClient liquidityClient;

    @Autowired
    private IQueryLiquidityHelper liquidityHelper;

    @Override
    public QueryLiquidityResponseBean getService(String isin) {
        LiquidityClientBean requestClientBean = liquidityHelper.toRequest(isin);
        QueryLiquidityResponseClientBean responseClientBean = liquidityClient.getClient(requestClientBean);

        return liquidityHelper.toResponse(responseClientBean);
    }

}