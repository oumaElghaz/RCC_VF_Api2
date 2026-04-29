package ma.vivalis.BKAM_CDR_API1.API.model;

public class MyRequestBody {
    private Integer id_Lot;

    public MyRequestBody(Integer id_Lot) {
        this.id_Lot = id_Lot;
    }

    public Integer getId_Lot() {
        return id_Lot;
    }

    public void setId_Lot(Integer id_Lot) {
        this.id_Lot = id_Lot;
    }
}
