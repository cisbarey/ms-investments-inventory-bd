package mx.com.actinver.ms.beans.BD.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "instruments")
public class InstrumentsExposureClientBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "isin_fund")
	@JsonIgnore
	private DetailClientBean detailClientBean;

	@Id
	@Column(name = "ISIN_INSTRUMENT")
	private String isinInstruments;

	@Column(name = "NAME")
	private String name;

	@Column(name = "WEIGHTING")
	private BigDecimal weighting;

	@Column(name = "PERFORMANCE")
	private BigDecimal performance;

	@Column(name = "CURRENCY")
	private String currency;

	@Column(name = "CURRENCY_ID")
	private String currencyId;

	@Column(name = "CREATION_DATE")
	private String creationDate;

	@Column(name = "CREATION_USER")
	private String creationUser;

	@Column(name = "TICKER")
	private String ticker;

	@Column(name = "HOLDING")
	private BigDecimal holding;

}
