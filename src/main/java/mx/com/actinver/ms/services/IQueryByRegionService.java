package mx.com.actinver.ms.services;

import java.util.Map;

import mx.com.actinver.ms.beans.query.QueryByRegionRequestBean;
import mx.com.actinver.ms.beans.query.QueryByRegionResponseBean;

public interface IQueryByRegionService {

	QueryByRegionResponseBean getRegion(QueryByRegionRequestBean requestBean,Map<String,String> headers);

}