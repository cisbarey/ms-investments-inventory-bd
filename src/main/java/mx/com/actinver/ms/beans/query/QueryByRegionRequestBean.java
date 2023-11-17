package mx.com.actinver.ms.beans.query;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryByRegionRequestBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "is required")
	@Schema(description = "Region del fondo",example = "MEXICO")
    private String  region;
}
