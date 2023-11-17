package mx.com.actinver.ms.beans.BD.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.actinver.ms.beans.BD.entities.RegionClientBean;

public interface IRegions extends JpaRepository<RegionClientBean,String>{

}
