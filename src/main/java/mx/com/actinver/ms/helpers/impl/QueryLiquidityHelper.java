package mx.com.actinver.ms.helpers.impl;

import mx.com.actinver.ms.beans.BD.entities.LiquidityClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryLiquidityResponseClientBean;
import mx.com.actinver.ms.beans.query.QueryLiquidityResponseBean;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;
import mx.com.actinver.ms.helpers.IQueryLiquidityHelper;
import org.springframework.stereotype.Component;

@Component
public class QueryLiquidityHelper implements IQueryLiquidityHelper {

    @Override
    public LiquidityClientBean toRequest(String isin) {
        LiquidityClientBean liquidityClientBean = new LiquidityClientBean();

        if (isin == null || isin.trim().equals(""))
            throw new SuperMarketFundBusinessRuleException("isin is required", ErrorExceptions.INVALID_PARAMS);
		liquidityClientBean.setIsin(isin);

        return liquidityClientBean;
    }

    @Override
    public QueryLiquidityResponseBean toResponse(QueryLiquidityResponseClientBean responseClientBean) {
        QueryLiquidityResponseBean responseBean = new QueryLiquidityResponseBean();
        responseBean.setType(responseClientBean.getType());
        return responseBean;
    }

}