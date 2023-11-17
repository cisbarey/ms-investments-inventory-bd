package mx.com.actinver.ms.clients;

import mx.com.actinver.ms.beans.client.registerKeyword.RegisterKeywordRequestClientBean;
import mx.com.actinver.ms.beans.registerKeyword.RegisterKeywordResponseBean;

public interface IRegisterKeywordClient {

    RegisterKeywordResponseBean registrationKeyword(RegisterKeywordRequestClientBean registerKeywordRequestClientBean);

}

