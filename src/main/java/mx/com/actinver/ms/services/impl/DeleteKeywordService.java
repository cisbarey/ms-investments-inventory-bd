package mx.com.actinver.ms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.actinver.ms.beans.deleteKeyword.DeleteKeywordResponseBean;
import mx.com.actinver.ms.clients.IDeleteKeywordClient;
import mx.com.actinver.ms.services.IDeleteKeywordService;

@Service
public class DeleteKeywordService implements IDeleteKeywordService {

    @Autowired
    private IDeleteKeywordClient deleteKeywordClient;

    @Override
    public DeleteKeywordResponseBean deleteKeyword(String keyword) {
        DeleteKeywordResponseBean deleteKeywordResponseBean = deleteKeywordClient.deleteKeyword(keyword);
        return deleteKeywordResponseBean;
    }

}