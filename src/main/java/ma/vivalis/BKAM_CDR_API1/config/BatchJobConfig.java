package ma.vivalis.BKAM_CDR_API1.config;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.parameters.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchJobConfig {
    @Bean
    public Job bkamCdrProcessingJob(
            JobRepository jobRepository,
            Flow phaseEnvoiAPIFlow) {

        return new JobBuilder("bkamCdrProcessingJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(phaseEnvoiAPIFlow)
                .end()
                .build();
    }
}
