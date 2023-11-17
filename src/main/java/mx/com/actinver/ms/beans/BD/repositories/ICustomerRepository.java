package mx.com.actinver.ms.beans.BD.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.com.actinver.ms.beans.BD.entities.CustomerClientBean;

public interface ICustomerRepository extends JpaRepository<CustomerClientBean,String>{

	CustomerClientBean getById(String id);
	@Query("FROM  CustomerClientBean customer "
			+ "where customer.id in (?1)"
			+ "")
	List<CustomerClientBean> findAllById(List<String> id);

}
