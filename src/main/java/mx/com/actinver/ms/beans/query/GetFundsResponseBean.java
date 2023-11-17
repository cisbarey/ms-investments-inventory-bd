package mx.com.actinver.ms.beans.query;

import java.io.Serializable;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetFundsResponseBean implements Serializable{

	private static final long serialVersionUID = -4961953990573331189L;
	
	@Schema(description = "Información ligado al fondo")
    private List<DetailBean> detail;
}
