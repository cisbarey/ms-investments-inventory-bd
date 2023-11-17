package mx.com.actinver.ms.beans.BD.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.com.actinver.ms.beans.BD.entities.HorizonClientBean;

public interface IHorizonRepository extends JpaRepository<HorizonClientBean,String>{

	List<HorizonClientBean> findByType(String type);
	
	@Query("FROM  HorizonClientBean horizon "
			+ "where horizon.type in (?1)"
			+ "")
	List<HorizonClientBean> findByTypes(List<String> types);

}
