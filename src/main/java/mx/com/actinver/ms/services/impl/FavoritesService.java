package mx.com.actinver.ms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.actinver.ms.beans.MessageBean;
import mx.com.actinver.ms.beans.BD.entities.FavoritesClientBean;
import mx.com.actinver.ms.beans.insert.FavoritesRequestBean;
import mx.com.actinver.ms.clients.IFavoritesClient;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;
import mx.com.actinver.ms.helpers.IFavoritesHelper;
import mx.com.actinver.ms.services.IFavoritesService;

@Service
public class FavoritesService implements IFavoritesService {

	@Autowired
	private IFavoritesClient favoritesClient;

	@Autowired
	private IFavoritesHelper favoritesHelper;

	@Override
	public MessageBean toFavoriteOperation(FavoritesRequestBean favoritesBean) {
		FavoritesClientBean clientBean = favoritesHelper.toBean(favoritesBean);
		MessageBean responseBean = new MessageBean();
		if (favoritesBean.getOperation().equals("I") || favoritesBean.getOperation().equals("D")) {
			if (favoritesBean.getOperation().equalsIgnoreCase("I")) {
				responseBean = favoritesClient.insertFavorite(clientBean);
			} else if (favoritesBean.getOperation().equalsIgnoreCase("D")) {
				responseBean = favoritesClient.deleteFavorite(clientBean);
			}
		} else {
			throw new SuperMarketFundBusinessRuleException("Unrecognized Operation",ErrorExceptions.INVALID_PARAMS);
		}

		return responseBean;
	}

}