package mx.com.actinver.ms.services;

import mx.com.actinver.ms.beans.MessageBean;
import mx.com.actinver.ms.beans.insert.FavoritesRequestBean;

public interface IFavoritesService{
	
	MessageBean toFavoriteOperation(FavoritesRequestBean favoritesBean);

}