package ma.vivalis.BKAM_CDR_API1.config;

import ma.vivalis.BKAM_CDR_API1.API.model.MyRequestBody;
import ma.vivalis.BKAM_CDR_API1.API.processor.MyRequestProcessor;
import ma.vivalis.BKAM_CDR_API1.API.writer.MyRequestWriter;
import ma.vivalis.BKAM_CDR_API1.entities.sss_cdr_CR_detail;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@Configuration
public class StepConfig {
    // ═══════════════════════════════════════════════════════
    // STEP  : Envoi Api
    // ═══════════════════════════════════════════════════════
    @Bean
    public Step envoiApiStep(
            JobRepository jobRepository,
            PlatformTransactionManager tx,
            ItemReader<List<MyRequestBody>> MyRequestBodyReader,
            MyRequestProcessor myRequestProcessor,
            MyRequestWriter myRequestWriter


    ) {


        return new StepBuilder("envoiApiStep", jobRepository)
                .<List<MyRequestBody>, List<sss_cdr_CR_detail>>chunk(500)
                .transactionManager(tx)
                .reader(MyRequestBodyReader)
                .processor(myRequestProcessor)
                .writer(myRequestWriter)
                .build();
    }

}
