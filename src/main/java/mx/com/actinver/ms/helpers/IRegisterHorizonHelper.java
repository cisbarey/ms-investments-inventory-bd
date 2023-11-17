package mx.com.actinver.ms.helpers;

import mx.com.actinver.ms.beans.BD.entities.HorizonClientBean;
import mx.com.actinver.ms.beans.BD.entities.RegisterHorizonResponseClientBean;
import mx.com.actinver.ms.beans.query.RegisterHorizonRequestBean;
import mx.com.actinver.ms.beans.query.RegisterHorizonResponseBean;

public interface IRegisterHorizonHelper {

	HorizonClientBean toRequest(RegisterHorizonRequestBean requestBean);
	
	RegisterHorizonResponseBean toResponse(RegisterHorizonResponseClientBean responseClientBean);

}
