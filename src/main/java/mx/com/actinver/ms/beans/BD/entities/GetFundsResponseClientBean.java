package mx.com.actinver.ms.beans.BD.entities;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetFundsResponseClientBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private List<DetailClientBean> detail;
}
