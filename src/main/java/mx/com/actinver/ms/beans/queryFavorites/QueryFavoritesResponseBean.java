package mx.com.actinver.ms.beans.queryFavorites;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(name = "Ejemplo de respuesta para la consulta de favoritos de una palabra clave")
public class QueryFavoritesResponseBean {

    @Schema(description = "Lista de favoritos")
    private List<FavoritesBean> favorites;

}