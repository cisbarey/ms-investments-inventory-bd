package mx.com.actinver.ms.helpers.impl;

import mx.com.actinver.ms.beans.client.metadata.mostWanted.QueryByMostWantedClientRequestBean;
import mx.com.actinver.ms.beans.metadata.mostWanted.QueryByMostWantedRequestBean;
import mx.com.actinver.ms.helpers.IQueryByMostWantedRequestHelper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class QueryByMostWantedRequestHelper implements IQueryByMostWantedRequestHelper {

    @Override
    public QueryByMostWantedClientRequestBean toRequest(QueryByMostWantedRequestBean searchType) {

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateFormatter = currentDate.format(formatterDate);
        String dateFormatter30DaysAgo = searchType.getSearchType().equals("BY_FUND") ? dateFormatter : currentDate.minusDays(30).format(formatterDate);

        QueryByMostWantedClientRequestBean queryByMostWantedClientRequestBean = new QueryByMostWantedClientRequestBean();
        queryByMostWantedClientRequestBean.setDate(dateFormatter);
        queryByMostWantedClientRequestBean.setSearchType(searchType.getSearchType());
        queryByMostWantedClientRequestBean.setDate30DaysAgo(dateFormatter30DaysAgo);
        queryByMostWantedClientRequestBean.setIsins(searchType.getIsins());
        queryByMostWantedClientRequestBean.setMaxResults(searchType.getMaxResults());

        return queryByMostWantedClientRequestBean;
    }

}