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
public class CustomQueryAnualPerform1YClientBean implements Serializable{

	private static final long serialVersionUID = -6161245505333283726L;
	
	private BigDecimal min;
	private BigDecimal max;
}
