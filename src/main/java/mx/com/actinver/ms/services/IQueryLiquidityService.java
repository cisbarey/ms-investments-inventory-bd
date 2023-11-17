package mx.com.actinver.ms.services;

import mx.com.actinver.ms.beans.query.QueryLiquidityResponseBean;

public interface IQueryLiquidityService {

    QueryLiquidityResponseBean getService(String isin);

}