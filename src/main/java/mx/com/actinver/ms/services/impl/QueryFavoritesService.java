package mx.com.actinver.ms.services.impl;

import mx.com.actinver.ms.beans.queryFavorites.QueryFavoritesRequestBean;
import mx.com.actinver.ms.beans.queryFavorites.QueryFavoritesResponseBean;
import mx.com.actinver.ms.clients.IQueryFavoritesClient;
import mx.com.actinver.ms.services.IQueryFavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QueryFavoritesService implements IQueryFavoritesService {

    @Autowired
    private IQueryFavoritesClient queryFavoritesClient;

    @Override
    public QueryFavoritesResponseBean queryFavorites(QueryFavoritesRequestBean queryFavoritesRequestBean) {
        QueryFavoritesResponseBean responseClientBean;
        if (queryFavoritesRequestBean.getContractNumber() != null) {
            responseClientBean = queryFavoritesClient.queryFavoritesLinked(queryFavoritesRequestBean);
        } else {
            responseClientBean = queryFavoritesClient.queryFavorites(queryFavoritesRequestBean);
        }
        return responseClientBean;
    }

}