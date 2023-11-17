package mx.com.actinver.ms.beans.deleteMostRecent;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Ejemplo de peticion del servicio")
public class DeleteMostRecentRequestBean implements Serializable {
	
	private static final long serialVersionUID = -8840697075631444957L;
	
	@NotNull
	@Schema(example = "678", description = "Id")
    private long id;
	
}
