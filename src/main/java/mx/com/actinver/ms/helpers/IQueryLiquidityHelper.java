package mx.com.actinver.ms.helpers;

import mx.com.actinver.ms.beans.BD.entities.LiquidityClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryLiquidityResponseClientBean;
import mx.com.actinver.ms.beans.query.QueryLiquidityResponseBean;

public interface IQueryLiquidityHelper {

    LiquidityClientBean toRequest(String isin);

    QueryLiquidityResponseBean toResponse(QueryLiquidityResponseClientBean responseClientBean);

}