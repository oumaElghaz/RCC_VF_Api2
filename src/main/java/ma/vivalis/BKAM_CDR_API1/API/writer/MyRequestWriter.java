package ma.vivalis.BKAM_CDR_API1.API.writer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ma.vivalis.BKAM_CDR_API1.API.model.sss_cdr_api1;
import ma.vivalis.BKAM_CDR_API1.entities.sss_cdr_CR_detail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.infrastructure.item.Chunk;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class MyRequestWriter implements ItemWriter<List<sss_cdr_CR_detail>> {
    private static final Logger log = LoggerFactory.getLogger(MyRequestWriter.class);

    @PersistenceContext
    private EntityManager em;


    @Override
    public void write(Chunk<? extends List<sss_cdr_CR_detail>> chunk) throws Exception {
        for (List<sss_cdr_CR_detail> dtList : chunk) {
            for(sss_cdr_CR_detail dt : dtList){
                em.persist(dt);

            }






        }


        em.flush();
        em.clear();

    }
}
