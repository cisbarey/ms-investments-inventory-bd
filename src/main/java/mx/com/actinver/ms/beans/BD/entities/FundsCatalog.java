package mx.com.actinver.ms.beans.BD.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FUNDS_CATALOG", schema = "MARKETDATA_USER")
public class FundsCatalog {

    @Id
    @Column(name = "ISIN")
    private String isin;

    @Column(name = "SERIE_KEY")
    private String serieKey;

    @Column(name = "SERIE")
    private String serie;

    @Column(name = "KEY")
    private String key;

    @OneToMany(mappedBy = "fundsCatalog", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BusinessFunds> businessFunds;

}
