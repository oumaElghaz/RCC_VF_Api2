package ma.vivalis.BKAM_CDR_API1.API.Repository;

import ma.vivalis.BKAM_CDR_API1.entities.sss_cdr_CR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface sss_cdr_CR_repository extends JpaRepository<sss_cdr_CR, Long> {

    @Query("SELECT DISTINCT c FROM sss_cdr_CR c " +
            "WHERE c.status = -1 " )
    List<sss_cdr_CR> findByStatusEnAttenteTraitement();
}
