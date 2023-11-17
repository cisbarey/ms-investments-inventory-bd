package mx.com.actinver.ms.services;

import java.util.Map;

import mx.com.actinver.ms.beans.query.QueryByTickerRequestBean;
import mx.com.actinver.ms.beans.query.QueryByTickerResponseBean;


public interface IQueryByTickerService {

    QueryByTickerResponseBean getFundsByTicker(QueryByTickerRequestBean requestBean,Map<String,String> headers);

}