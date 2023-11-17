package mx.com.actinver.ms.beans.catalog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusinessBean implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private List<BusinessFundBean> business;
}
