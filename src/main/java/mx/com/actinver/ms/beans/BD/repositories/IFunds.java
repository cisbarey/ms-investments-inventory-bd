package mx.com.actinver.ms.beans.BD.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.actinver.ms.beans.BD.entities.FundsClientBean;


public interface IFunds extends JpaRepository<FundsClientBean, String> {

}