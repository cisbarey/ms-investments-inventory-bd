package mx.com.actinver.ms.beans.BD.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CountryId implements Serializable {

	private static final long serialVersionUID = 1L;

	private String isin;
	
	private String country;
	
}
