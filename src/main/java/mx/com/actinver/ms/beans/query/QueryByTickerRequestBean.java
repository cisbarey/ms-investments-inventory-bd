package mx.com.actinver.ms.beans.query;

import java.io.Serializable;
import java.util.List;

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
public class QueryByTickerRequestBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "is required")
	@Schema(description = "Numero de serie del fondo",example = "ACT2030 B-1")
    private String  ticker;

	private List<String> isins;
}
