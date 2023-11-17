package mx.com.actinver.ms.services.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.com.actinver.ms.beans.BD.entities.FavoritesClientBean;
import mx.com.actinver.ms.beans.BD.repositories.IFavoritesRepository;
import mx.com.actinver.ms.beans.insert.FavoritesRequestBean;
import mx.com.actinver.ms.enums.TypeDatabaseException;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;
import mx.com.actinver.ms.helpers.impl.FavoriteHelper;
import mx.com.actinver.ms.services.IInsertFavoriteService;


@Service
@Slf4j
public class InsertFavoriteService implements IInsertFavoriteService {

	@Autowired
	private EntityManager em;
	
	@Autowired
	private IFavoritesRepository favoritesRepository;
	
	@Autowired
	private FavoriteHelper favoriteHelper;


	@Override
	public FavoritesRequestBean create(FavoritesRequestBean requestBean) {
		if (requestBean.getContractNumber() == null)
			throw new SuperMarketFundBusinessRuleException(TypeDatabaseException.ID_NULL, this.getTableName(em, FavoritesClientBean.class));
		FavoritesClientBean entity = null;
		try {
			entity = favoritesRepository.save(favoriteHelper.toEntity(requestBean));
			log.info(entity.toString());
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new SuperMarketFundBusinessRuleException(e.getMessage(),ErrorExceptions.PRECONDITION_FAILED);
		}
		return favoriteHelper.toBean(entity);
	}

	@Override
	public FavoritesRequestBean createAll(List<FavoritesRequestBean> requestBean) {
		if (requestBean.isEmpty())
			throw new SuperMarketFundBusinessRuleException(TypeDatabaseException.NULL_ELEMENT, this.getTableName(em, FavoritesClientBean.class));
		List<FavoritesClientBean> entity = favoritesRepository.saveAll(favoriteHelper.toEntityAll(requestBean));
		return favoriteHelper.toBean(entity.get(0));
	}


}