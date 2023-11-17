package mx.com.actinver.ms.helpers;

import mx.com.actinver.ms.beans.BD.entities.GetFundsRequestClientBean;
import mx.com.actinver.ms.beans.BD.entities.GetFundsResponseClientBean;
import mx.com.actinver.ms.beans.query.GetFundsRequestBean;
import mx.com.actinver.ms.beans.query.GetFundsResponseBean;

public interface IGetFundsHelper {

	GetFundsRequestClientBean toRequest( GetFundsRequestBean requestBean);

    GetFundsResponseBean toResponse(GetFundsResponseClientBean responseClientBean);

}
