package mx.com.actinver.ms.beans.queryFavorites;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Informacion de los favoritos")
public class FavoritesBean {

	@Schema(description = "Canal", example = "123456789")
	private String channel;

    @Schema(example = "issuer", description = "Editor")
    private String issuer;

    @Schema(example = "issuer", description = "Numero de serie")
    private String serie;

	@Schema(description = "Operaciona realizar", example = "I")
	private String operation;

	@Schema(description = "Lenguaje", example = "SPA")
	private String languaje;

}