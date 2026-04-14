package ma.vivalis.BKAM_CDR_API1.config;

import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.batch.core.step.Step;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;

@Configuration
public class BatchFlowConfig {




    // ═══════════════════════════════════════════════════════
    // PHASE  : Envoi API
    // ═══════════════════════════════════════════════════════
    @Bean
    public Flow phaseEnvoiAPIFlow(
            Step envoiApiStep,
            JobExecutionDecider myStepDecider,
            TaskExecutor flowTaskExecutor) {

        return new FlowBuilder<SimpleFlow>("phase")
                .split(flowTaskExecutor)
                .add(
                        new FlowBuilder<SimpleFlow>("Flow")
                                .start(myStepDecider) // Ajout du decider
                                .on("EXECUTE").to(envoiApiStep)
                                .from(myStepDecider).on("SKIP").end()
                                .build()


                )
                .build();
    }





}