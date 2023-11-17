package mx.com.actinver.ms.helpers;

import mx.com.actinver.ms.beans.BD.entities.QueryByRegionRequestClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryByRegionResponseClientBean;
import mx.com.actinver.ms.beans.query.QueryByRegionRequestBean;
import mx.com.actinver.ms.beans.query.QueryByRegionResponseBean;

public interface IQueryByRegionHelper {

	QueryByRegionRequestClientBean toRequest( QueryByRegionRequestBean requestBean);

	QueryByRegionResponseBean toResponse(QueryByRegionResponseClientBean responseClientBean, QueryByRegionRequestBean requestBean);

}
