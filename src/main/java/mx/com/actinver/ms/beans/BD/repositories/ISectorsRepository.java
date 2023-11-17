package mx.com.actinver.ms.beans.BD.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.com.actinver.ms.beans.BD.entities.SectorExposureClientBean;

public interface ISectorsRepository extends JpaRepository<SectorExposureClientBean, String>{
	
	@Query(value="SELECT DISTINCT s.name FROM SectorExposureClientBean s")
	List<String> getDistinctSector();

}
