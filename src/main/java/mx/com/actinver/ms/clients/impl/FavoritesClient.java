package mx.com.actinver.ms.clients.impl;

import mx.com.actinver.ms.beans.BD.entities.DetailClientBean;
import mx.com.actinver.ms.beans.BD.entities.FavoritesClientBean;
import mx.com.actinver.ms.beans.BD.entities.FavoritesId;
import mx.com.actinver.ms.beans.BD.repositories.IFavoritesRepository;
import mx.com.actinver.ms.beans.BD.repositories.IFundsRepository;
import mx.com.actinver.ms.beans.MessageBean;
import mx.com.actinver.ms.clients.IFavoritesClient;
import mx.com.actinver.ms.config.HttpHeadersConfig;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.exceptions.SuperMarketFundNotFoundException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FavoritesClient extends HttpHeadersConfig implements IFavoritesClient {

    @Autowired
    private IFavoritesRepository iFavoritesRepository;

    @Autowired
    private IFundsRepository fundsRepository;

    @Override
    public MessageBean insertFavorite(FavoritesClientBean favoritesClientBean) {

        MessageBean messageBean = new MessageBean();

        String ticker = favoritesClientBean.getIssuer();
        if (!favoritesClientBean.getSerie().isEmpty()) {
            ticker += " " + favoritesClientBean.getSerie().trim();
        }

        List<DetailClientBean> existsTicker = fundsRepository.findByTicker(ticker);

        if (existsTicker.isEmpty()) {
            throw new SuperMarketFundNotFoundException("The ticker to register does not exist in the database", ErrorExceptions.NOT_FOUND);
        }

        FavoritesId favoritesId = new FavoritesId();
        favoritesId.setContractNumber(favoritesClientBean.getContractNumber());
        favoritesId.setIssuer(favoritesClientBean.getIssuer());
        if(favoritesClientBean.getSerie().isEmpty()){
            favoritesId.setSerie(" ");
        }else{
            favoritesId.setSerie(favoritesClientBean.getSerie());
        }
        Optional<FavoritesClientBean> exists = iFavoritesRepository.findById(favoritesId);
        if (exists.isPresent()) {
            throw new SuperMarketFundBusinessRuleException("Favorite Already Registered for This Contract", ErrorExceptions.PRECONDITION_FAILED);
        } else {
            try {
                if(favoritesClientBean.getSerie().isEmpty()){
                    favoritesClientBean.setSerie(" ");
                }
                iFavoritesRepository.save(favoritesClientBean);
                messageBean.setMessage("Favorite Inserted Successfully");
                messageBean.setType("SUCCESS");
            } catch (Exception ex) {
                throw new SuperMarketFundBusinessRuleException(ex.getMessage(), ErrorExceptions.PRECONDITION_FAILED);
            }
        }
        return messageBean;
    }

    @Override
    public MessageBean deleteFavorite(FavoritesClientBean favoritesClientBean) {
        MessageBean messageBean = new MessageBean();
        try {
            FavoritesId favoritesId = new FavoritesId();
            favoritesId.setContractNumber(favoritesClientBean.getContractNumber());
            favoritesId.setIssuer(favoritesClientBean.getIssuer());
            if(favoritesClientBean.getSerie().isEmpty()){
                favoritesId.setSerie(" ");
            }else{
                favoritesId.setSerie(favoritesClientBean.getSerie());
            }
            Optional<FavoritesClientBean> exists = iFavoritesRepository.findById(favoritesId);
            if (exists.isPresent()) {
                if(favoritesClientBean.getSerie().isEmpty()){
                    favoritesClientBean.setSerie(" ");
                }else{
                    favoritesClientBean.setSerie(favoritesClientBean.getSerie());
                }
                iFavoritesRepository.delete(favoritesClientBean);
                messageBean.setMessage("Favorite Deleted Successfully");
                messageBean.setType("SUCCESS");
            } else {
                throw new SuperMarketFundNotFoundException("Not found.", ErrorExceptions.NOT_FOUND);
            }
        } catch (SuperMarketFundNotFoundException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new SuperMarketFundBusinessRuleException("Invalid input params.", ErrorExceptions.PRECONDITION_FAILED);
        }

        return messageBean;
    }
}