package mx.com.actinver.ms.beans.BD.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.actinver.ms.beans.BD.entities.Fund_Keyword;
import mx.com.actinver.ms.beans.BD.entities.Keyword;


public interface IFund_Keyword extends JpaRepository<Fund_Keyword, Long> {

    List<Fund_Keyword> findByKeywordId(Keyword keywordId);

    void deleteAllByKeywordId(Keyword keyword);

}