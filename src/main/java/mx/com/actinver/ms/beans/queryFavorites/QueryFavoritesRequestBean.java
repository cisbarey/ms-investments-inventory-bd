package mx.com.actinver.ms.beans.queryFavorites;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(name = "Ejemplo de petición para la consulta de favoritos de una palabra clave")
public class QueryFavoritesRequestBean {

    @Schema(example = "12345678", description = "Numero de contrato")
    private String contractNumber;

    @Schema(example = "DINN", description = "Numeros de contratos")
    private List<String> contractNumbers;

    @Schema(example = "ACT2021", description = "issuer")
	private List<String> issuers;

    @Schema(example = "B-3", description = "serie")
	private List<String> series;

    @Schema(example = "I", description = "Operación")
	private List<String> operations;

    @Schema(example = "SPA", description = "Lenguaje")
	private List<String> languages;

}
