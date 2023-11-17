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
public class BusinessFundBean implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Long businessId;
    private List<String> isin;
}
