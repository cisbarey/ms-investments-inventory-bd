package mx.com.actinver.ms.clients;

import mx.com.actinver.ms.beans.BD.entities.LiquidityClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryLiquidityResponseClientBean;


public interface IQueryLiquidityClient {

    QueryLiquidityResponseClientBean getClient(LiquidityClientBean requestClientBean);

}

