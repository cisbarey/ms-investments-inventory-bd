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
@Table(name = "BUSINESS_CATALOG", schema = "MARKETDATA_USER")
public class BusinessCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BUSINESS_ID")
    private Long businessId;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "businessCatalog", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BusinessFunds> businessFunds;

}
