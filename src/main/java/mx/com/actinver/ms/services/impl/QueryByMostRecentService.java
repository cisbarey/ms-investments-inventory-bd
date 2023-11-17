package mx.com.actinver.ms.services.impl;


import mx.com.actinver.ms.beans.BD.entities.DetailClientBean;
import mx.com.actinver.ms.beans.metadata.mostRecent.QueryByMostRecentRequestBean;
import mx.com.actinver.ms.beans.metadata.mostRecent.QueryByMostRecentResponseBean;
import mx.com.actinver.ms.clients.IGetFundClient;
import mx.com.actinver.ms.clients.IQueryByMostRecentClient;
import mx.com.actinver.ms.services.IQueryByMostRecentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryByMostRecentService implements IQueryByMostRecentService {

    @Autowired
    private IQueryByMostRecentClient queryMostRecentClient;

    @Autowired
    private IGetFundClient getFundClient;

    @Override
    public QueryByMostRecentResponseBean queryMostRecent(QueryByMostRecentRequestBean queryByMostRecentRequestBean) {

        QueryByMostRecentResponseBean responseClientBean = queryMostRecentClient.queryMostRecent(
                queryByMostRecentRequestBean.getCustomerId(),
                queryByMostRecentRequestBean.getSearchType(),
                queryByMostRecentRequestBean.getIsins());

        if (queryByMostRecentRequestBean.getSearchType().equals("BY_FUND")) {
            for (int i = 0; i <= responseClientBean.getMostRecent().size()-1; i++) {
                DetailClientBean detailClientBean = getFundClient.getFund(responseClientBean.getMostRecent().get(i).getKey());
                responseClientBean.getMostRecent().get(i).setDetail(detailClientBean);
            }

            return responseClientBean;
        }

        return responseClientBean;
    }

}