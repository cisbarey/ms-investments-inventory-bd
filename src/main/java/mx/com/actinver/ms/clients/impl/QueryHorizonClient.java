package mx.com.actinver.ms.clients.impl;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.actinver.ms.beans.BD.entities.HorizonClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryHorizonResponseClientBean;
import mx.com.actinver.ms.beans.BD.repositories.IHorizonRepository;
import mx.com.actinver.ms.clients.IQueryHorizonClient;
import mx.com.actinver.ms.config.HttpHeadersConfig;
import mx.com.actinver.ms.exceptions.SuperMarketFundNotFoundException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;

@Component
public class QueryHorizonClient extends HttpHeadersConfig implements IQueryHorizonClient {

	@Autowired
	private IHorizonRepository horizonRepository;

	@Override
	public QueryHorizonResponseClientBean getClient(HorizonClientBean requestClientBean, Map<String, String> headers) {
		
		QueryHorizonResponseClientBean horizonResponseBean = new QueryHorizonResponseClientBean();
		Optional<HorizonClientBean> horizonBean = horizonRepository.findById(requestClientBean.getIsin());
		
		if(!horizonBean.isPresent()) {
			throw new SuperMarketFundNotFoundException("Not found.",ErrorExceptions.NOT_FOUND);
		}
		
		horizonResponseBean.setType(horizonBean.get().getType());
		
		return horizonResponseBean;
	}

}