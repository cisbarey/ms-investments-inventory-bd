package mx.com.actinver.ms.services;

import mx.com.actinver.ms.beans.deleteMostRecent.DeleteMostRecentRequestBean;
import mx.com.actinver.ms.beans.deleteMostRecent.DeleteMostRecentResponseBean;

public interface IDeleteMostRecentService {
	
	DeleteMostRecentResponseBean deteleMostRecent(DeleteMostRecentRequestBean deleteMostRecentRequestBean);

}
