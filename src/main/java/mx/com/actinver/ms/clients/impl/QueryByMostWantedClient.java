package mx.com.actinver.ms.clients.impl;

import mx.com.actinver.ms.beans.BD.entities.CombinedCount;
import mx.com.actinver.ms.beans.BD.entities.DetailClientBean;
import mx.com.actinver.ms.beans.BD.entities.Metadata;
import mx.com.actinver.ms.beans.BD.repositories.IMetadataRepository;
import mx.com.actinver.ms.beans.client.metadata.mostWanted.KeyCount;
import mx.com.actinver.ms.beans.client.metadata.mostWanted.QueryByMostWantedClientRequestBean;
import mx.com.actinver.ms.beans.metadata.mostWanted.QueryByMostWantedResponseBean;
import mx.com.actinver.ms.clients.IQueryByMostWantedClient;
import mx.com.actinver.ms.config.HttpHeadersConfig;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.exceptions.SuperMarketFundNotFoundException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QueryByMostWantedClient extends HttpHeadersConfig implements IQueryByMostWantedClient {

    @Autowired
    private IMetadataRepository metadataRepository;

    @Override
    public QueryByMostWantedResponseBean queryMostWanted(QueryByMostWantedClientRequestBean mostWantedClientRequestBean) {
        List<KeyCount> keyCounts;

        if (mostWantedClientRequestBean.getSearchType() != null
                && !mostWantedClientRequestBean.getSearchType().isEmpty()) {

            if (mostWantedClientRequestBean.getSearchType().equalsIgnoreCase("by_fund")) {

                if (mostWantedClientRequestBean.getIsins() != null
                        && !mostWantedClientRequestBean.getIsins().isEmpty()
                        && mostWantedClientRequestBean.getMaxResults() != null
                        && mostWantedClientRequestBean.getMaxResults() > 0) {
                    Pageable pageable = PageRequest.of(0, mostWantedClientRequestBean.getMaxResults());
                    keyCounts = this.metadataRepository.findMetadataByCriteria(
                            mostWantedClientRequestBean.getIsins(),
                            mostWantedClientRequestBean.getDate30DaysAgo(),
                            mostWantedClientRequestBean.getDate(),
                            mostWantedClientRequestBean.getSearchType(),
                            pageable).map(this::buildKeyCount)
                            .toList();
                } else if (mostWantedClientRequestBean.getIsins() != null
                        && !mostWantedClientRequestBean.getIsins().isEmpty()
                        && (mostWantedClientRequestBean.getMaxResults() == null
                        || mostWantedClientRequestBean.getMaxResults() == 0)) {
                    keyCounts = this.metadataRepository.findByKeyInAndCreationDateRangeAndSearchType(
                                    mostWantedClientRequestBean.getIsins(),
                                    mostWantedClientRequestBean.getDate30DaysAgo(),
                                    mostWantedClientRequestBean.getDate(),
                                    mostWantedClientRequestBean.getSearchType())
                            .stream()
                            .map(this::buildKeyCount)
                            .collect(Collectors.toList());
                } else if (mostWantedClientRequestBean.getMaxResults() != null && mostWantedClientRequestBean.getMaxResults() > 0) {
                    Pageable pageable = PageRequest.of(0, mostWantedClientRequestBean.getMaxResults());
                    keyCounts = this.metadataRepository.findByDateRangeAndSearchType(
                                    mostWantedClientRequestBean.getDate30DaysAgo(),
                                    mostWantedClientRequestBean.getDate(),
                                    mostWantedClientRequestBean.getSearchType(),
                                    pageable)
                            .map(this::buildKeyCount)
                            .toList();
                } else {
                    keyCounts = this.metadataRepository.findByDateRangeAndSearchType(
                                    mostWantedClientRequestBean.getDate30DaysAgo(),
                                    mostWantedClientRequestBean.getDate(),
                                    mostWantedClientRequestBean.getSearchType())
                            .stream()
                            .map(this::buildKeyCount)
                            .collect(Collectors.toList());
                }
            } else if (mostWantedClientRequestBean.getMaxResults() != null && mostWantedClientRequestBean.getMaxResults() > 0) {
                Pageable pageable = PageRequest.of(0, mostWantedClientRequestBean.getMaxResults());
                keyCounts = this.metadataRepository.findByDateRangeAndSearchType(
                                mostWantedClientRequestBean.getDate30DaysAgo(),
                                mostWantedClientRequestBean.getDate(),
                                "BY_FUND",
                                pageable)
                        .map(this::buildKeyCount)
                        .toList();
            } else {
                keyCounts = this.metadataRepository.findByDateRangeAndSearchType(
                                mostWantedClientRequestBean.getDate30DaysAgo(),
                                mostWantedClientRequestBean.getDate(),
                                "BY_FUND")
                        .stream()
                        .map(this::buildKeyCount)
                        .collect(Collectors.toList());
            }
        } else {
            List<KeyCount> combinedCount = this.metadataRepository.findByDateRange(
                            mostWantedClientRequestBean.getDate30DaysAgo(),
                            mostWantedClientRequestBean.getDate())
                    .stream()
                    .map(this::buildKeyCount)
                    .collect(Collectors.toList());

            keyCounts = this.metadataRepository.findByDateRangeAndSearchType(
                            mostWantedClientRequestBean.getDate30DaysAgo(),
                            mostWantedClientRequestBean.getDate(),
                            "BY_FUND")
                    .stream()
                    .map(this::buildKeyCount)
                    .collect(Collectors.toList());
            keyCounts.addAll(combinedCount);
        }

        if (keyCounts.isEmpty()) {
            throw new SuperMarketFundNotFoundException("Not found.", ErrorExceptions.NOT_FOUND);
        }

        QueryByMostWantedResponseBean queryByMostWantedResponseBean = new QueryByMostWantedResponseBean();
        queryByMostWantedResponseBean.setMostWanted(keyCounts);

        return queryByMostWantedResponseBean;
    }

    private KeyCount buildKeyCount(CombinedCount data) {
        return new KeyCount(data.getIsin(), data.getCount(), null);
    }
}