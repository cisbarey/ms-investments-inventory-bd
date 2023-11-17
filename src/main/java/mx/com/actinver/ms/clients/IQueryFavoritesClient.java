package mx.com.actinver.ms.clients;

import mx.com.actinver.ms.beans.queryFavorites.QueryFavoritesRequestBean;
import mx.com.actinver.ms.beans.queryFavorites.QueryFavoritesResponseBean;

public interface IQueryFavoritesClient {

    QueryFavoritesResponseBean queryFavorites(QueryFavoritesRequestBean queryFavoritesRequestBean);

    QueryFavoritesResponseBean queryFavoritesLinked(QueryFavoritesRequestBean queryFavoritesRequestBean);


}

