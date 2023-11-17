package mx.com.actinver.ms.services;

import java.util.Map;

import mx.com.actinver.ms.beans.query.QueryHorizonResponseBean;

public interface IQueryHorizonService {

    QueryHorizonResponseBean getService(String isin,Map<String,String> headers);

}