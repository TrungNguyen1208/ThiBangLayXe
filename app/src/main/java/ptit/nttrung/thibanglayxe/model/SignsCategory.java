package ptit.nttrung.thibanglayxe.model;

import java.io.Serializable;

public class SignsCategory implements Serializable {
    private int indexCategory;
    private String nameCategory;

    public SignsCategory(int indexCategory, String nameCategory) {
        this.indexCategory = indexCategory;
        this.nameCategory = nameCategory;
    }

    public int getIndexCategory() {
        return this.indexCategory;
    }

    public void setIndexCategory(int indexCategory) {
        this.indexCategory = indexCategory;
    }

    public String getNameCategory() {
        return this.nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
