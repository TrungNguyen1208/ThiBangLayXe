package ptit.nttrung.thibanglayxe.model;

import java.util.ArrayList;

public class LawCategory {
    private int idLawCategory;
    private int indexOfCategory;
    private ArrayList<Law> laws;
    private int zLawType;
    private String zName;

    public int getIdLawCategory() {
        return this.idLawCategory;
    }

    public void setIdLawCategory(int idLawCategory) {
        this.idLawCategory = idLawCategory;
    }

    public int getzLawType() {
        return this.zLawType;
    }

    public void setzLawType(int zLawType) {
        this.zLawType = zLawType;
    }

    public String getzName() {
        return this.zName;
    }

    public void setzName(String zName) {
        this.zName = zName;
    }

    public ArrayList<Law> getLaws() {
        return this.laws;
    }

    public void setLaws(ArrayList<Law> laws) {
        this.laws = laws;
    }

    public int getIndexOfCategory() {
        return this.indexOfCategory;
    }

    public void setIndexOfCategory(int indexOfCategory) {
        this.indexOfCategory = indexOfCategory;
    }
}
