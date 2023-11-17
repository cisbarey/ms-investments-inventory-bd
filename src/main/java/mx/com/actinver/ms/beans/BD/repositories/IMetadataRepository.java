package mx.com.actinver.ms.beans.BD.repositories;

import mx.com.actinver.ms.beans.BD.entities.CombinedCount;
import mx.com.actinver.ms.beans.BD.entities.Metadata;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IMetadataRepository extends JpaRepository<Metadata, Long> {

    /* BY_SECTOR, BY_TYPE, BY_FIRMNAME. */
    List<Metadata> findBySearchTypeOrderByMetadataIdDesc(String searchType);

    /* BY_FUND */
    List<Metadata> findBySearchTypeAndKeyIsInOrderByMetadataIdDesc(String searchType, List<String> key);

    /* BY_SEARCH */
    @Query("SELECT m FROM Metadata m WHERE m.metadataId IN (SELECT MAX(m2.metadataId) FROM Metadata m2 WHERE m2.searchType = :searchType AND m2.creationUser = :creationUser GROUP BY m2.key) AND m.searchType = :searchType AND m.creationUser = :creationUser ORDER BY m.metadataId DESC")
    List<Metadata> findLatestDistinctKeyBySearchTypeAndCreationUser(String searchType, String creationUser);

    Metadata findByMetadataId(long metadataId);

    void deleteByKeyAndCreationUser(String key, String user);

    @Query("SELECT m.key AS isin, COUNT(m.key) AS count FROM Metadata m WHERE m.key IN :isins AND TO_DATE(m.creationDate, 'DD/MM/YYYY') BETWEEN :fechaInicio AND :fechaFin AND m.searchType = :datoEntrada GROUP BY m.key ORDER BY m.key")
    Page<CombinedCount> findMetadataByCriteria(
            @Param("isins") List<String> isins,
            @Param("fechaInicio") String fechaInicio,
            @Param("fechaFin") String fechaFin,
            @Param("datoEntrada") String datoEntrada,
            Pageable pageable);

    @Query("SELECT m.key AS isin, COUNT(m.key) AS count FROM Metadata m WHERE m.key IN :isins AND TO_DATE(m.creationDate, 'DD/MM/YYYY') BETWEEN :fechaInicio AND :fechaFin AND m.searchType = :datoEntrada GROUP BY m.key ORDER BY m.key")
    List<CombinedCount> findByKeyInAndCreationDateRangeAndSearchType(
            @Param("isins") List<String> isins,
            @Param("fechaInicio") String fechaInicio,
            @Param("fechaFin") String fechaFin,
            @Param("datoEntrada") String datoEntrada);

    @Query("SELECT m.key AS isin, COUNT(m.key) AS count FROM Metadata m WHERE m.searchType = :datoEntrada AND TO_DATE(m.creationDate, 'DD/MM/YYYY') BETWEEN :fechaInicio AND :fechaFin GROUP BY m.key ORDER BY m.key")
    Page<CombinedCount> findByDateRangeAndSearchType(
            @Param("fechaInicio") String fechaInicio,
            @Param("fechaFin") String fechaFin,
            @Param("datoEntrada") String datoEntrada,
            Pageable pageable);

    @Query("SELECT m.key AS isin, COUNT(m.key) AS count FROM Metadata m WHERE m.searchType = :datoEntrada AND TO_DATE(m.creationDate, 'DD/MM/YYYY') BETWEEN :fechaInicio AND :fechaFin GROUP BY m.key ORDER BY m.key")
    List<CombinedCount> findByDateRangeAndSearchType(
            @Param("fechaInicio") String fechaInicio,
            @Param("fechaFin") String fechaFin,
            @Param("datoEntrada") String datoEntrada);

    @Query("SELECT m.key AS isin, COUNT(m.key) AS count FROM Metadata m WHERE m.key IN :isins AND TO_DATE(m.creationDate, 'DD/MM/YYYY') BETWEEN :fechaInicio AND :fechaFin GROUP BY m.key ORDER BY m.key")
    Page<CombinedCount> countByKeyAndDateNotLikeFund(
            @Param("isins") List<String> isins,
            @Param("fechaInicio") String fechaInicio,
            @Param("fechaFin") String fechaFin,
            Pageable pageable);

    @Query("SELECT m.key AS isin, COUNT(m.key) AS count FROM Metadata m WHERE TO_DATE(m.creationDate, 'DD/MM/YYYY') BETWEEN :fechaInicio AND :fechaFin GROUP BY m.key ORDER BY m.key")
    Page<CombinedCount> findByDateRange(
            @Param("fechaInicio") String fechaInicio,
            @Param("fechaFin") String fechaFin);

}