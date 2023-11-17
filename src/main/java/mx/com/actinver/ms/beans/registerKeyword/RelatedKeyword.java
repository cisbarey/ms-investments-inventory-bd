package mx.com.actinver.ms.beans.registerKeyword;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Ejemplo de petición de los instrumentos relacionados a una palabra clave")
public class RelatedKeyword implements Serializable {

    @NotNull
    @Schema(description = "Datos del etf")
    private String isin;

    @NotNull
    @Schema(description = "Datos de los instrumentos")
    private String fundType;

}