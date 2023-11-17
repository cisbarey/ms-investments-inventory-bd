package mx.com.actinver.ms.helpers;

import mx.com.actinver.ms.beans.BD.entities.FavoritesClientBean;
import mx.com.actinver.ms.beans.insert.FavoritesRequestBean;

public interface IFavoritesHelper {

    FavoritesClientBean toBean(FavoritesRequestBean insertBean);

}
