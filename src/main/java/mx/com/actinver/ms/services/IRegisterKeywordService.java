package mx.com.actinver.ms.services;

import mx.com.actinver.ms.beans.registerKeyword.RegisterKeywordRequestBean;
import mx.com.actinver.ms.beans.registerKeyword.RegisterKeywordResponseBean;

public interface IRegisterKeywordService {

    RegisterKeywordResponseBean registerKeyword(RegisterKeywordRequestBean registerKeywordRequestBean);

}