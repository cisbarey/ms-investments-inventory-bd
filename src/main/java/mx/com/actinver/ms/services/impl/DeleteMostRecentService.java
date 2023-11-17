package mx.com.actinver.ms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.actinver.ms.beans.deleteMostRecent.DeleteMostRecentRequestBean;
import mx.com.actinver.ms.beans.deleteMostRecent.DeleteMostRecentResponseBean;
import mx.com.actinver.ms.clients.IDeleteMostRecentClient;
import mx.com.actinver.ms.services.IDeleteMostRecentService;

@Service
public class DeleteMostRecentService implements IDeleteMostRecentService {
	
	@Autowired
	private IDeleteMostRecentClient deleteMostRecentClient;
	
	@Override
	public DeleteMostRecentResponseBean deteleMostRecent(DeleteMostRecentRequestBean deleteMostRecentRequestBean) {
		
		return deleteMostRecentClient.deteleMostRecent(deleteMostRecentRequestBean.getId());
	}

}
