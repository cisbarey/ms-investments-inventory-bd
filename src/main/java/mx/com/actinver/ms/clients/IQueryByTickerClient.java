package mx.com.actinver.ms.clients;

import java.util.Map;

import mx.com.actinver.ms.beans.BD.entities.QueryByTickerRequestClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryByTickerResponseClientBean;

public interface IQueryByTickerClient {

    QueryByTickerResponseClientBean getClient(QueryByTickerRequestClientBean requestClientBean, Map<String,String> headers);

}

