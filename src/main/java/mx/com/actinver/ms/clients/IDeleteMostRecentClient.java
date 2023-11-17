package mx.com.actinver.ms.clients;

import mx.com.actinver.ms.beans.deleteMostRecent.DeleteMostRecentResponseBean;

public interface IDeleteMostRecentClient {
	
	DeleteMostRecentResponseBean deteleMostRecent(long id);

}
