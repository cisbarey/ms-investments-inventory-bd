package mx.com.actinver.ms.beans.BD.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "METADATA")
@Data
public class Metadata implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "METADATA_ID")
    private long metadataId;

    @Column(name = "KEY")
    private String key;

    @Column(name = "SEARCH_TYPE")
    private String searchType;

    @Column(name = "CREATION_DATE")
    private String creationDate;

    @Column(name = "CREATION_USER")
    private String creationUser;

}