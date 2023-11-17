package mx.com.actinver.ms.beans.BD.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(InstrumentsId.class)
@Table(name = "instruments")
public class InstrumentsClientBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ISIN_FUND")
	private String isin;

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
