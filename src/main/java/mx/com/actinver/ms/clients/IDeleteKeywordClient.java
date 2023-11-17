package mx.com.actinver.ms.clients;

import mx.com.actinver.ms.beans.deleteKeyword.DeleteKeywordResponseBean;

public interface IDeleteKeywordClient {

    DeleteKeywordResponseBean deleteKeyword(String keyword);

}

