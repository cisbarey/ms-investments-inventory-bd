package mx.com.actinver.ms.beans.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@Schema(name = "Bean de respuesta, datos de la liquidez")
public class QueryLiquidityResponseBean implements Serializable {

    private static final long serialVersionUID = 937039808425900484L;

    @Schema(description = "Tipo de horizonte del fondo.", example = "CORTO PLAZO")
    private String type;

}
