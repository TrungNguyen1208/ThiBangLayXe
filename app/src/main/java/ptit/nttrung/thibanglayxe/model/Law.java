package ptit.nttrung.thibanglayxe.model;

public class Law {
    private int lawCategory;
    private String zContent;
    private String zDesc;
    private String zTitle;

    public String getzContent() {
        return this.zContent;
    }

    public void setzContent(String zContent) {
        this.zContent = zContent;
    }

    public String getzDesc() {
        return this.zDesc;
    }

    public void setzDesc(String zDesc) {
        this.zDesc = zDesc;
    }

    public String getzTitle() {
        return this.zTitle;
    }

    public void setzTitle(String zTitle) {
        this.zTitle = zTitle;
    }

    public int getLawCategory() {
        return this.lawCategory;
    }

    public void setLawCategory(int lawCategory) {
        this.lawCategory = lawCategory;
    }
}
