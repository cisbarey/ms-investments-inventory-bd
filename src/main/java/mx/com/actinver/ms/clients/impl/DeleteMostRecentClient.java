package mx.com.actinver.ms.clients.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mx.com.actinver.ms.beans.BD.entities.Metadata;
import mx.com.actinver.ms.beans.BD.repositories.IMetadataRepository;
import mx.com.actinver.ms.beans.deleteMostRecent.DeleteMostRecentResponseBean;
import mx.com.actinver.ms.clients.IDeleteMostRecentClient;
import mx.com.actinver.ms.config.HttpHeadersConfig;
import mx.com.actinver.ms.exceptions.SuperMarketFundNotFoundException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;

@Component
public class DeleteMostRecentClient extends HttpHeadersConfig implements IDeleteMostRecentClient {

	@Autowired
	private IMetadataRepository metadataRepository;

	@Transactional
	@Override
	public DeleteMostRecentResponseBean deteleMostRecent(long id) {
		DeleteMostRecentResponseBean deleteMostRecentResponseBean = new DeleteMostRecentResponseBean();
		Metadata metadata = new Metadata();

		metadata = metadataRepository.findByMetadataId(id);

		if (metadata == null) {
            throw new SuperMarketFundNotFoundException("MetadataId not found.", ErrorExceptions.NOT_FOUND);
        }

		metadataRepository.deleteByKeyAndCreationUser(metadata.getKey(), metadata.getCreationUser());

		deleteMostRecentResponseBean.setMessage("The id was successfully deleted.");
		deleteMostRecentResponseBean.setType("SUCCESS");

		return deleteMostRecentResponseBean;
	}

}
