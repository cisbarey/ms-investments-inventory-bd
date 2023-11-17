package mx.com.actinver.ms.helpers.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import mx.com.actinver.ms.beans.sectors.QuerySectorsResponseBean;
import mx.com.actinver.ms.helpers.IQuerySectorsHelper;

@Component
public class QuerySectorsHelper implements IQuerySectorsHelper {

	

	@Override
	public QuerySectorsResponseBean toResponse(List<String> responseClientBean) {
		QuerySectorsResponseBean responseBean = new QuerySectorsResponseBean();
		responseBean.setSectors(responseClientBean);
		return responseBean;
	}
	
}
