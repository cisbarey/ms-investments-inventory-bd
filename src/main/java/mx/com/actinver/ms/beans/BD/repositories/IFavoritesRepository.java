package mx.com.actinver.ms.beans.BD.repositories;

import mx.com.actinver.ms.beans.BD.entities.FavoritesClientBean;
import mx.com.actinver.ms.beans.BD.entities.FavoritesId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IFavoritesRepository extends JpaRepository<FavoritesClientBean, FavoritesId> {

    List<FavoritesClientBean> findAllByContractNumber(String contractNumber);

}