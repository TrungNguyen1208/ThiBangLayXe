package ptit.nttrung.thibanglayxe.model;

public class LawType {
    private int idLaw;
    private String lawDes;

    public LawType(int idLaw, String lawDes) {
        this.idLaw = idLaw;
        this.lawDes = lawDes;
    }

    public int getIdLaw() {
        return this.idLaw;
    }

    public void setIdLaw(int idLaw) {
        this.idLaw = idLaw;
    }

    public String getLawDes() {
        return this.lawDes;
    }

    public void setLawDes(String lawDes) {
        this.lawDes = lawDes;
    }
}
