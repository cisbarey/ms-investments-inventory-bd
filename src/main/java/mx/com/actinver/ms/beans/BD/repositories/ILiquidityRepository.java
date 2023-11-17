package mx.com.actinver.ms.beans.BD.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.com.actinver.ms.beans.BD.entities.LiquidityClientBean;

public interface ILiquidityRepository extends JpaRepository<LiquidityClientBean,String>{

	List<LiquidityClientBean> findByType(String type);
	
	@Query("FROM  LiquidityClientBean liquidity "
			+ "where liquidity.type in (?1)"
			+ "")
	List<LiquidityClientBean> findByTypes(List<String> types);

}
