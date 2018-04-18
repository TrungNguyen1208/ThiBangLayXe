package ptit.nttrung.thibanglayxe.model;

import java.io.Serializable;

public class TestResult implements Serializable {
    private int currentQuest;
    private int currentTime;
    private int idTest;
    private boolean isFinish;
    private License license;
    private String nameLicense;
    private String nameTest;
    private int totalCorrectQuest;

    public int getIdTest() {
        return this.idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public int getCurrentQuest() {
        return this.currentQuest;
    }

    public void setCurrentQuest(int currentQuest) {
        this.currentQuest = currentQuest;
    }

    public int getTotalCorrectQuest() {
        return this.totalCorrectQuest;
    }

    public void setTotalCorrectQuest(int totalCorrectQuest) {
        this.totalCorrectQuest = totalCorrectQuest;
    }

    public String getNameTest() {
        return this.nameTest;
    }

    public void setNameTest(String nameTest) {
        this.nameTest = nameTest;
    }

    public String getNameLicense() {
        return this.nameLicense;
    }

    public void setNameLicense(String nameLicense) {
        this.nameLicense = nameLicense;
    }

    public int getCurrentTime() {
        return this.currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public License getLicense() {
        return this.license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public boolean isFinish() {
        return this.isFinish;
    }

    public void setFinish(boolean finish) {
        this.isFinish = finish;
    }
}
