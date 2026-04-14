package ma.vivalis.BKAM_CDR_API1.API.processor;

import ma.vivalis.BKAM_CDR_API1.API.Repository.sss_cdr_CR_repository;
import ma.vivalis.BKAM_CDR_API1.API.Repository.sss_cdr_api1_repository;
import ma.vivalis.BKAM_CDR_API1.API.model.MyRequestBody;
import ma.vivalis.BKAM_CDR_API1.API.model.MyResponseBody;
import ma.vivalis.BKAM_CDR_API1.API.service.ApiService;
import ma.vivalis.BKAM_CDR_API1.entities.sss_cdr_CR;
import ma.vivalis.BKAM_CDR_API1.entities.sss_cdr_CR_detail;
import org.jspecify.annotations.Nullable;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyRequestProcessor implements ItemProcessor<List<MyRequestBody>, List<sss_cdr_CR_detail>> {
    private final ApiService apiService;
    private final sss_cdr_api1_repository sss_cdr_api1_repository;
    private final sss_cdr_CR_repository sss_cdr_CR_repository;
    public MyRequestProcessor(ApiService apiService, sss_cdr_api1_repository sssCdrApi1Repository, sss_cdr_CR_repository sssCdrCrRepository) {
        this.apiService = apiService;

        sss_cdr_api1_repository = sssCdrApi1Repository;
        sss_cdr_CR_repository = sssCdrCrRepository;
    }

    @Override
    public @Nullable List<sss_cdr_CR_detail> process(List<MyRequestBody> item) throws Exception {
        List<sss_cdr_CR_detail> details = new ArrayList<>();
        for(MyRequestBody body : item) {
            MyResponseBody resultatApi = apiService.sendDataToApi(body);
            LocalDateTime dateExt=sss_cdr_api1_repository.findDateExtractionByIdLot(resultatApi.getId_Lot());
            sss_cdr_CR_detail dtail=sss_cdr_CR_detail.builder()
                    .id_lot(resultatApi.getId_Lot())
                    .dateExt(dateExt)
                    .numDec(null)
                    .num_ligne(null)
                    .id_champ(resultatApi.getAttribut())
                    .code_erreur(resultatApi.getCodMsg())
                    .desc_erreur(resultatApi.getMsg())
                    .fichier(resultatApi.getFichier())
                    .build();
            sss_cdr_CR sssCdrCr=sss_cdr_CR.builder()
                    .id_lot(resultatApi.getId_Lot())
                    .dateExt(dateExt)
                    .numDec(null)
                    .status(resultatApi.getStatut())
                    .description(resultatApi.getMsg())
                    .build();
            sss_cdr_CR_repository.save(sssCdrCr);
            details.add(dtail);

        }
        return details;
    }
}
