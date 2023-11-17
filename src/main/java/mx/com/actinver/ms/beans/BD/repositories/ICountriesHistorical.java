package mx.com.actinver.ms.beans.BD.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.actinver.ms.beans.BD.entities.CountryHistoricalClientBean;

public interface ICountriesHistorical extends JpaRepository<CountryHistoricalClientBean, String>{

}
