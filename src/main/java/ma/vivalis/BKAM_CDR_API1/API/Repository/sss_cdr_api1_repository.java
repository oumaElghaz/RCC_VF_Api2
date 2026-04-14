package ma.vivalis.BKAM_CDR_API1.API.Repository;

import ma.vivalis.BKAM_CDR_API1.API.model.sss_cdr_api1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface sss_cdr_api1_repository extends JpaRepository<sss_cdr_api1, Long> {

    @Query("SELECT DISTINCT c.dateExtraction FROM sss_cdr_api1 c " +
            "WHERE c.id_Lot = (SELECT MAX(c2.id_Lot) FROM sss_cdr_api1 c2)" )
    LocalDateTime getDateExtractionByMaxId_lot();

    @Query("SELECT MAX(c2.id_Lot) FROM sss_cdr_api1 c2" )
    int getMaxId_lot();

    @Query("SELECT DISTINCT c FROM sss_cdr_api1 c " +
            "WHERE c.codMsg = \"0\" " )
    List<sss_cdr_api1> findByStatusEnAccepte();


    @Query("SELECT DISTINCT c.dateExtraction FROM sss_cdr_api1 c " +
            "WHERE c.id_Lot =:idLot" )
    LocalDateTime findDateExtractionByIdLot(int idLot);

}
