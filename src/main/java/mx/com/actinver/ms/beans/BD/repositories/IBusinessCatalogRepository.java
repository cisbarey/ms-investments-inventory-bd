package mx.com.actinver.ms.beans.BD.repositories;

import mx.com.actinver.ms.beans.BD.entities.BusinessCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBusinessCatalogRepository extends JpaRepository<BusinessCatalog, Long> {

}
