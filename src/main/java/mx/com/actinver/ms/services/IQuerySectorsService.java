package mx.com.actinver.ms.services;

import java.util.Map;

import mx.com.actinver.ms.beans.sectors.QuerySectorsResponseBean;

public interface IQuerySectorsService {

    QuerySectorsResponseBean getService(Map<String,String> headers);

}