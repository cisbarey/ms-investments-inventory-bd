package mx.com.actinver.ms.beans.BD.repositories;

import mx.com.actinver.ms.beans.BD.entities.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface  IKeyword extends JpaRepository<Keyword, Long> {

    @Query("SELECT k FROM Keyword k ORDER BY k.keywordId DESC")
    List<Keyword> findLastKeyword();

    Keyword findByName(String keyword);

    List<Keyword> findByNameContaining(String keyword);

    Keyword findFirstByName(String keyword);

    void deleteByKeywordId(long keywordId);

    Keyword findFirstByKeywordId(long id);

}
