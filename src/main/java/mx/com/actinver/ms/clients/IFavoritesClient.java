package mx.com.actinver.ms.clients;

import mx.com.actinver.ms.beans.MessageBean;
import mx.com.actinver.ms.beans.BD.entities.FavoritesClientBean;

public interface IFavoritesClient {

    MessageBean insertFavorite(FavoritesClientBean favoritesClientBean);
    
    MessageBean deleteFavorite(FavoritesClientBean favoritesClientBean);

}

