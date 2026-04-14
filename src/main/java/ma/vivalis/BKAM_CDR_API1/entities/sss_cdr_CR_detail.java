package ma.vivalis.BKAM_CDR_API1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Table(name = "sss_cdr_CR_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class sss_cdr_CR_detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int id_lot;
    private LocalDateTime dateExt;
    private String numDec;
    private String num_ligne;
    private String id_champ;
    private String fichier;
    private String code_erreur;
    private String desc_erreur;
}
