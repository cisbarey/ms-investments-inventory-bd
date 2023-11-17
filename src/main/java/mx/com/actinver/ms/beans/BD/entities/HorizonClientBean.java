package mx.com.actinver.ms.beans.BD.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "horizons")
public class HorizonClientBean implements Serializable{

	private static final long serialVersionUID = 5888235307556285548L;
	
	@Id
	@Column(name = "isin_fund")
	private String isin;
	
	private String type;
	
	@Column(name = "creation_date")
	private String creationDate;
	
	@Column(name = "creation_user")
	private String creationUser;

	
	
	
	
	
}
