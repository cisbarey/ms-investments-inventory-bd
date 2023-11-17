package mx.com.actinver.ms.beans.BD.entities;

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
public class QueryByRegionResponseClientBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Schema(description = "Información ligado al fondo")
    private List<DetailClientBean> detail;
}
