package mx.com.actinver.ms.beans.queryKeyword;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Schema(name = "Ejemplo de petición de los instrumentos relacionados a una palabra clave")
public class QueryKeyword implements Serializable {

    @NotNull
    @Schema(description = "Keyword", example = "Mesa")
    private String keyword;

    @NotNull
    @Schema(description = "Isin del instrumento", example = "MX51MA0C00E1")
    private String isin;

    @NotNull
    @Schema(description = "Ticker del instrumento", example = "MAXIMO B")
    private String ticker;

    @NotNull
    @Schema(description = "firmname del instrumento", example = "Operadora Actinver SA de CV")
    private String firmname;

    @NotNull
    @Schema(description = "Tipo de instrumento", example = "FUND")
    private String instrumentType;

}