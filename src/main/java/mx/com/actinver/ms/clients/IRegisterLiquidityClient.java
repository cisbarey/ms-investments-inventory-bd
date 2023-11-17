package mx.com.actinver.ms.clients;

import mx.com.actinver.ms.beans.BD.entities.LiquidityClientBean;
import mx.com.actinver.ms.beans.BD.entities.RegisterLiquidityResponseClientBean;


public interface IRegisterLiquidityClient {

    RegisterLiquidityResponseClientBean getClient(LiquidityClientBean requestClientBean);

}

