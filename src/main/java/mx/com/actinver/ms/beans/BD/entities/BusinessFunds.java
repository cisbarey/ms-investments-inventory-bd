package mx.com.actinver.ms.beans.BD.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BUSINESS_FUNDS", schema = "MARKETDATA_USER")
public class BusinessFunds implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "BUSINESS_ID")
    private BusinessCatalog businessCatalog;

    @Id
    @ManyToOne
    @JoinColumn(name = "ISIN")
    private FundsCatalog fundsCatalog;

}
