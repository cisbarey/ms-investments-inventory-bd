package mx.com.actinver.ms.beans.BD.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "FUNDS_KEYWORDS")
@Data
public class Fund_Keyword implements Serializable {

    @Id
    @Column(name = "FUND_KEYWORD_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long fundKeywordId;

    @Column(name = "TYPE_INSTRUMENT")
    private String typeInstrument;

    @Column(name="ISIN_FUND")
    private String isinFund;

    @Column(name="TICKER")
    private String ticker;

    @Column(name="FIRMNAME")
    private String firmname;

    @ManyToOne
    @JoinColumn(name = "KEYWORD_ID")
    private Keyword keywordId;

}