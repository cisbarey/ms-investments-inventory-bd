package mx.com.actinver.ms.clients.impl;

import lombok.extern.slf4j.Slf4j;
import mx.com.actinver.ms.beans.BD.entities.FavoritesClientBean;
import mx.com.actinver.ms.beans.BD.repositories.IFavoritesRepository;
import mx.com.actinver.ms.beans.queryFavorites.FavoritesBean;
import mx.com.actinver.ms.beans.queryFavorites.QueryFavoritesRequestBean;
import mx.com.actinver.ms.beans.queryFavorites.QueryFavoritesResponseBean;
import mx.com.actinver.ms.clients.IQueryFavoritesClient;
import mx.com.actinver.ms.config.HttpHeadersConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class QueryFavoritesClient extends HttpHeadersConfig implements IQueryFavoritesClient {

    @Autowired
    private IFavoritesRepository favoritesRepository;

    @Override
    public QueryFavoritesResponseBean queryFavoritesLinked(QueryFavoritesRequestBean queryFavoritesRequestBean) {
        List<FavoritesClientBean> favoritesClientBeanList = favoritesRepository.findAllByContractNumber(queryFavoritesRequestBean.getContractNumber());

        QueryFavoritesResponseBean queryFavoritesResponseBean = new QueryFavoritesResponseBean();

        queryFavoritesResponseBean.setFavorites(toFavorites(favoritesClientBeanList));

        return queryFavoritesResponseBean;
    }

    @Override
    public QueryFavoritesResponseBean queryFavorites(QueryFavoritesRequestBean queryFavoritesRequestBean) {
    	List<FavoritesClientBean> favoritesClientBeanList = favoritesRepository.findAll();
    	
    	if(queryFavoritesRequestBean.getContractNumbers()!= null && !queryFavoritesRequestBean.getContractNumbers().isEmpty())
    		favoritesClientBeanList = favoritesClientBeanList.stream().filter(f -> queryFavoritesRequestBean.getContractNumbers().contains(f.getContractNumber())).collect(Collectors.toList());
    	
    	if(queryFavoritesRequestBean.getIssuers()!= null && !queryFavoritesRequestBean.getIssuers().isEmpty())
    		favoritesClientBeanList = favoritesClientBeanList.stream().filter(f -> queryFavoritesRequestBean.getIssuers().contains(f.getIssuer())).collect(Collectors.toList());
    	
    	if(queryFavoritesRequestBean.getLanguages()!= null && !queryFavoritesRequestBean.getLanguages().isEmpty())
    		favoritesClientBeanList = favoritesClientBeanList.stream().filter(f -> queryFavoritesRequestBean.getLanguages().contains(f.getLanguage())).collect(Collectors.toList());
    	
    	if(queryFavoritesRequestBean.getOperations()!= null && !queryFavoritesRequestBean.getOperations().isEmpty())
    		favoritesClientBeanList = favoritesClientBeanList.stream().filter(f -> queryFavoritesRequestBean.getOperations().contains(f.getOperation())).collect(Collectors.toList());
    	
    	if(queryFavoritesRequestBean.getSeries()!= null && !queryFavoritesRequestBean.getSeries().isEmpty())
    		favoritesClientBeanList = favoritesClientBeanList.stream().filter(f -> queryFavoritesRequestBean.getSeries().contains(f.getSerie())).collect(Collectors.toList());
    	
    	
        QueryFavoritesResponseBean queryFavoritesResponseBean = new QueryFavoritesResponseBean();

        queryFavoritesResponseBean.setFavorites(toFavorites(favoritesClientBeanList));

        return queryFavoritesResponseBean;
    }

    private List<FavoritesBean> toFavorites(List<FavoritesClientBean> favoritesClientBeanList) {
        if (favoritesClientBeanList != null && !favoritesClientBeanList.isEmpty()) {
            return favoritesClientBeanList.stream().map(this::toSetDataRelated).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }


    private FavoritesBean toSetDataRelated(FavoritesClientBean favoritesClientBean) {
        FavoritesBean favoritesBean = new FavoritesBean();

        favoritesBean.setChannel(favoritesClientBean.getContractNumber());
        favoritesBean.setIssuer(favoritesClientBean.getIssuer());
        favoritesBean.setSerie(favoritesClientBean.getSerie());
        favoritesBean.setOperation(favoritesClientBean.getOperation());
        favoritesBean.setLanguaje(favoritesClientBean.getLanguage());
        
        
        return favoritesBean;

    }
}