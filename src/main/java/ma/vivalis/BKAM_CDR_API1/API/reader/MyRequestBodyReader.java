package ma.vivalis.BKAM_CDR_API1.API.reader;

import ma.vivalis.BKAM_CDR_API1.API.Repository.sss_cdr_CR_repository;
import ma.vivalis.BKAM_CDR_API1.API.Repository.sss_cdr_api1_repository;
import ma.vivalis.BKAM_CDR_API1.API.model.MyRequestBody;
import ma.vivalis.BKAM_CDR_API1.API.model.sss_cdr_api1;
import ma.vivalis.BKAM_CDR_API1.entities.sss_cdr_CR;
import org.jspecify.annotations.Nullable;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@StepScope
@Component
public class MyRequestBodyReader implements ItemReader<List<MyRequestBody>> {
    private final sss_cdr_CR_repository sss_cdr_CR_repository;
    private final sss_cdr_api1_repository sss_cdr_api1_repository;

    public MyRequestBodyReader(sss_cdr_CR_repository sssCdrCrRepository, sss_cdr_api1_repository sssCdrApi1Repository) {
        sss_cdr_CR_repository = sssCdrCrRepository;
        sss_cdr_api1_repository = sssCdrApi1Repository;
    }

    @Override
    public @Nullable List<MyRequestBody> read() throws Exception {
        List<MyRequestBody>myRequestBodies=new ArrayList<>();

        List<sss_cdr_CR> sss_cdr_CRs =sss_cdr_CR_repository.findByStatusEnAttenteTraitement();
        List<sss_cdr_api1> sss_cdr_api1=sss_cdr_api1_repository.findByStatusEnAccepte();
        for (sss_cdr_CR cdr_CR : sss_cdr_CRs) {
            MyRequestBody myRequestBody=new MyRequestBody(cdr_CR.getId_lot());
            myRequestBodies.add(myRequestBody);
        }

        for (sss_cdr_api1 cdr_ap : sss_cdr_api1) {
            MyRequestBody myRequestBody=new MyRequestBody(cdr_ap.getId_Lot());
            myRequestBodies.add(myRequestBody);
        }

        return myRequestBodies;
    }
}
