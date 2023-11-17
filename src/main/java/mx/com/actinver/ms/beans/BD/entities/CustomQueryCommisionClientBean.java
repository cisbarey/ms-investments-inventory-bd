package mx.com.actinver.ms.beans.BD.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomQueryCommisionClientBean implements Serializable{

	private static final long serialVersionUID = 7491750925619404502L;
	
	private BigDecimal min;
	private BigDecimal max;
}
