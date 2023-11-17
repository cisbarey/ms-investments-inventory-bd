package mx.com.actinver.ms.beans.BD.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "KEYWORDS")
@Data
public class Keyword implements Serializable {

    @SequenceGenerator(name="gen_seq_keyword", sequenceName="hibernate_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gen_seq_keyword")
    @Id
    @Column(name = "KEYWORD_ID")
    private long keywordId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CREATION_DATE")
    private String creationDate;

    @Column(name = "CREATION_USER")
    private String creationUser;

}