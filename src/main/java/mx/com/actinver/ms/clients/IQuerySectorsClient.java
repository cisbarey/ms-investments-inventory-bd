package mx.com.actinver.ms.clients;

import java.util.List;
import java.util.Map;


public interface IQuerySectorsClient {

    List<String> getClient(Map<String,String> headers);

}

