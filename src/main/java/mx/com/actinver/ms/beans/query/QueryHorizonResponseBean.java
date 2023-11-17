package mx.com.actinver.ms.beans.query;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Schema(name = "Bean de respuesta, datos del horizonte")
public class QueryHorizonResponseBean implements Serializable{

	private static final long serialVersionUID = 937039808425900484L;
	
	@Schema(description = "Tipo de horizonte del fondo.", example="CORTO PLAZO")
	private String type;

}
