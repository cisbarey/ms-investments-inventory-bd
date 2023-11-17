package mx.com.actinver.ms.helpers;

import mx.com.actinver.ms.beans.BD.entities.QueryByTickerRequestClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryByTickerResponseClientBean;
import mx.com.actinver.ms.beans.query.QueryByTickerRequestBean;
import mx.com.actinver.ms.beans.query.QueryByTickerResponseBean;

public interface IQueryByTickerHelper {

    QueryByTickerRequestClientBean toRequest( QueryByTickerRequestBean requestBean);

    QueryByTickerResponseBean toResponse(QueryByTickerResponseClientBean responseClientBean);

}
