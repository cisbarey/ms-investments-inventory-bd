package mx.com.actinver.ms.helpers;

import java.util.List;

import mx.com.actinver.ms.beans.sectors.QuerySectorsResponseBean;

public interface IQuerySectorsHelper {

    QuerySectorsResponseBean toResponse(List<String> responseClientBean);

}
