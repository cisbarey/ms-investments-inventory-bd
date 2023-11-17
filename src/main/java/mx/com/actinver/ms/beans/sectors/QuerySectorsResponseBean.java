package mx.com.actinver.ms.beans.sectors;

import java.io.Serializable;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "Bean de respuesta de los sectores")
public class QuerySectorsResponseBean implements Serializable{

	private static final long serialVersionUID = 2592671621631498592L;
	
	@Schema(description = "Listado de sectores existentes",example = "Tecnología")
	private List<String> sectors;

}
