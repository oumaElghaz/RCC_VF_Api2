package ma.vivalis.BKAM_CDR_API1.API.model;

public class MyResponseBody {
    private String attribut;
    private int id_Lot;
    private String codMsg;
    private String msg;
    private int statut;
    private String fichier;

    public MyResponseBody(String attribut, int id_Lot, String codMsg, String msg, int statut, String fichier) {
        this.attribut = attribut;
        this.id_Lot = id_Lot;
        this.codMsg = codMsg;
        this.msg = msg;
        this.statut = statut;
        this.fichier = fichier;
    }

    public String getAttribut() {
        return attribut;
    }

    public int getId_Lot() {
        return id_Lot;
    }

    public String getCodMsg() {
        return codMsg;
    }

    public String getMsg() {
        return msg;
    }

    public int getStatut() {
        return statut;
    }

    public String getFichier() {
        return fichier;
    }

    public void setAttribut(String attribut) {
        this.attribut = attribut;
    }

    public void setId_Lot(int id_Lot) {
        this.id_Lot = id_Lot;
    }

    public void setCodMsg(String codMsg) {
        this.codMsg = codMsg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }
}
