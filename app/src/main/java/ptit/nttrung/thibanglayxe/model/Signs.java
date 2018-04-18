package ptit.nttrung.thibanglayxe.model;

import java.io.Serializable;

public class Signs implements Serializable {
    private String signDes;
    private int signId;
    private String signImage;
    private String signName;

    public Signs(int signId, String signName, String signImage, String signDes) {
        this.signId = signId;
        this.signName = signName;
        this.signImage = signImage;
        this.signDes = signDes;
    }

    public int getSignId() {
        return this.signId;
    }

    public void setSignId(int signId) {
        this.signId = signId;
    }

    public String getSignName() {
        return this.signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getSignImage() {
        return this.signImage;
    }

    public void setSignImage(String signImage) {
        this.signImage = signImage;
    }

    public String getSignDes() {
        return this.signDes;
    }

    public void setSignDes(String signDes) {
        this.signDes = signDes;
    }
}
