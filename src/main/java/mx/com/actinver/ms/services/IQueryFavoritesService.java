package mx.com.actinver.ms.services;

import mx.com.actinver.ms.beans.queryFavorites.QueryFavoritesRequestBean;
import mx.com.actinver.ms.beans.queryFavorites.QueryFavoritesResponseBean;

public interface IQueryFavoritesService {

    QueryFavoritesResponseBean queryFavorites(QueryFavoritesRequestBean queryFavoritesRequestBean);

}