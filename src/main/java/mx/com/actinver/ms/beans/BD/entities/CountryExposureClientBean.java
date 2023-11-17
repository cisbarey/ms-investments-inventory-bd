package mx.com.actinver.ms.beans.BD.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class CountryExposureClientBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "isin_fund")
	@JsonIgnore
	private DetailClientBean detailClientBean;

	@Id
	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "VALUE")
	private BigDecimal value;

	@Column(name = "CREATION_DATE")
	private String creationDate;

	@Column(name = "CREATION_USER")
	private String creationUser;
	

}
