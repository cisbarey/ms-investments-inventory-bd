package mx.com.actinver.ms.beans.BD.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class CustomerClientBean implements Serializable{

	private static final long serialVersionUID = 5888235307556285547L;
	
	@Id
	@Column(name = "customer_id")
	private String id;
	
	@Column(name = "video")
	private Boolean videoPreference;
	
	@Column(name = "creation_date")
	private String creationDate;
	
	@Column(name = "creation_user")
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
