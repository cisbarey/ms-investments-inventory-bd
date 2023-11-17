package mx.com.actinver.ms.beans.BD.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(CountryId.class)
@Table(name = "countries")
public class CountryClientBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ISIN_FUND")
	private String isin;
	
	@Id
	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "VALUE")
	private BigDecimal value;

	@Column(name = "CREATION_DATE")
	private String creationDate;

	@Column(name = "CREATION_USER")
	private String creationUser;
	
	@PrePersist
	void preInsert() {
		if (this.creationDate == null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
			   Date date = new Date(); 
		       this.creationDate = formatter.format(date);
		       this.creationUser = "INVESTMENTSINVENTORY";
	       return;
	   }
	}
	

}
