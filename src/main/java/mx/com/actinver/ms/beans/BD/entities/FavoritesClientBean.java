package mx.com.actinver.ms.beans.BD.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(FavoritesId.class)
@Table(name = "favorites")
public class FavoritesClientBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CONTRACT_NUMBER", nullable = false, length = 10)
	private String contractNumber;

	@Id
	@Column(name = "ISSUER", nullable = false, length = 10)
	private String issuer;

	@Id
	@Column(name = "SERIE", nullable = false, length = 5)
	private String serie;

	@Column(name = "OPERATION", length = 1)
	private String operation;

	@Column(name = "LANGUAGE", length = 3)
	private String language;

	@Column(name = "CREATION_DATE", length = 10)
	private String creationDate;

	@Column(name = "CREATION_USER", length = 20)
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
