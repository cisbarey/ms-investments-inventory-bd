package mx.com.actinver.ms.beans.BD.entities;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryByRegionRequestClientBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Schema(description = "Region del fondo")
    private String  region;
}
