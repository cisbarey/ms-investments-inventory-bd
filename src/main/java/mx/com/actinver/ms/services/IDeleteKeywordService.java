package mx.com.actinver.ms.services;

import mx.com.actinver.ms.beans.deleteKeyword.DeleteKeywordResponseBean;

public interface IDeleteKeywordService {

    DeleteKeywordResponseBean deleteKeyword(String keyword);

}