package mx.com.actinver.ms.clients.impl;

import mx.com.actinver.ms.beans.BD.entities.Metadata;
import mx.com.actinver.ms.beans.BD.repositories.IMetadataRepository;
import mx.com.actinver.ms.beans.metadata.mostRecent.MostRecent;
import mx.com.actinver.ms.beans.metadata.mostRecent.QueryByMostRecentResponseBean;
import mx.com.actinver.ms.clients.IQueryByMostRecentClient;
import mx.com.actinver.ms.config.HttpHeadersConfig;
import mx.com.actinver.ms.exceptions.SuperMarketFundNotFoundException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QueryByMostRecentClient extends HttpHeadersConfig implements IQueryByMostRecentClient {

    @Autowired
    private IMetadataRepository metadataRepository;

    @Override
    public QueryByMostRecentResponseBean queryMostRecent(String customerId, String searchType, List<String> isins) {
    	QueryByMostRecentResponseBean queryByMostRecentResponseBean = new QueryByMostRecentResponseBean();
    	List<Metadata> metadataList;
    	
    	if (customerId != null && !customerId.isEmpty()) // BY_SEARCH and customerId
            metadataList = this.metadataRepository.findLatestDistinctKeyBySearchTypeAndCreationUser(searchType, customerId);
    	else if (isins != null && !isins.isEmpty()) // BY_FUND and isins
            metadataList = metadataRepository.findBySearchTypeAndKeyIsInOrderByMetadataIdDesc(searchType, isins);
        else // BY_SECTOR, BY_TYPE, BY_FIRMNAME.
            metadataList = metadataRepository.findBySearchTypeOrderByMetadataIdDesc(searchType);
    	
    	if (metadataList == null || metadataList.isEmpty()) {
        	throw new SuperMarketFundNotFoundException("Not found." + searchType,ErrorExceptions.NOT_FOUND);
        }
		
		queryByMostRecentResponseBean.setMostRecent(toRecent(metadataList));
    	
        return queryByMostRecentResponseBean;
    }

    private List<MostRecent> toRecent(List<Metadata> metadata) {
        if (metadata != null && !metadata.isEmpty()) {
            return metadata.stream().map(this::toSetDataRelated).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private MostRecent toSetDataRelated(Metadata metadata) {
        MostRecent mostRecent = new MostRecent();

        mostRecent.setCreationDate(metadata.getCreationDate());
        mostRecent.setKey(metadata.getKey());
        mostRecent.setMetadataId(String.valueOf(metadata.getMetadataId()));

        return mostRecent;
    }
}