package ma.vivalis.BKAM_CDR_API1.API.model;

public class MyRequestBody {
    private int id_Lot;

    public MyRequestBody(int id_Lot) {
        this.id_Lot = id_Lot;
    }

    public int getId_Lot() {
        return id_Lot;
    }

    public void setId_Lot(int id_Lot) {
        this.id_Lot = id_Lot;
    }
}
