package mx.com.actinver.ms.helpers;

import mx.com.actinver.ms.beans.client.registerKeyword.RegisterKeywordRequestClientBean;
import mx.com.actinver.ms.beans.registerKeyword.RegisterKeywordRequestBean;

public interface IRegisterKeywordRequestHelper {

    RegisterKeywordRequestClientBean toRequest(RegisterKeywordRequestBean registerKeywordRequestBean);

}
