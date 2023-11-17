package mx.com.actinver.ms.services.impl;

import mx.com.actinver.ms.beans.BD.entities.DetailClientBean;
import mx.com.actinver.ms.beans.client.metadata.mostWanted.QueryByMostWantedClientRequestBean;
import mx.com.actinver.ms.beans.metadata.mostWanted.QueryByMostWantedRequestBean;
import mx.com.actinver.ms.beans.metadata.mostWanted.QueryByMostWantedResponseBean;
import mx.com.actinver.ms.clients.IGetFundClient;
import mx.com.actinver.ms.clients.IQueryByMostWantedClient;
import mx.com.actinver.ms.helpers.IQueryByMostWantedRequestHelper;
import mx.com.actinver.ms.services.IQueryByMostWantedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QueryByMostWantedService implements IQueryByMostWantedService {

    @Autowired
    private IQueryByMostWantedClient queryMostWantedClient;

    @Autowired
    private IQueryByMostWantedRequestHelper queryByMostWantedRequestHelper;

    @Autowired
    private IGetFundClient getFundClient;

    @Override
    public QueryByMostWantedResponseBean queryMostWanted(QueryByMostWantedRequestBean searchType) {
        QueryByMostWantedClientRequestBean requestClientBean = queryByMostWantedRequestHelper.toRequest(searchType);
        QueryByMostWantedResponseBean responseClientBean = queryMostWantedClient.queryMostWanted(requestClientBean);

        if (searchType.getSearchType().equals("BY_FUND") || searchType.getSearchType().isEmpty() ) {
            for (int i = 0; i <= responseClientBean.getMostWanted().size()-1; i++) {
                DetailClientBean detailClientBean = getFundClient.getFund(responseClientBean.getMostWanted().get(i).getKey());
                responseClientBean.getMostWanted().get(i).setDetail(detailClientBean);
            }

            return responseClientBean;
        }

        return responseClientBean;
    }
}
