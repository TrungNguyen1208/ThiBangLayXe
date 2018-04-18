package ptit.nttrung.thibanglayxe.model;

import java.io.Serializable;
import java.util.ArrayList;

public class License implements Serializable {
    private int idLicense;
    private String license;
    private String licenseDes;
    private ArrayList<NumberQuestionPerType> lstQuestionPerType;
    private int numberCorrectQuestion;
    private int numberTest;
    private int timeTest;
    private int totalQuestion;

    public boolean isSelected = false;

    public ArrayList<NumberQuestionPerType> getLstQuestionPerType() {
        return this.lstQuestionPerType;
    }

    public void setLstQuestionPerType(ArrayList<NumberQuestionPerType> lstQuestionPerType) {
        this.lstQuestionPerType = lstQuestionPerType;
    }

    public License(int idLicense, int numberCorrectQuestion, int totalQuestion, int timeTest, String licenseDes, String license) {
        this.idLicense = idLicense;
        this.numberCorrectQuestion = numberCorrectQuestion;
        this.totalQuestion = totalQuestion;
        this.timeTest = timeTest;
        this.licenseDes = licenseDes;
        this.license = license;
    }

    public int getNumberTest() {
        return this.numberTest;
    }

    public void setNumberTest(int numberTest) {
        this.numberTest = numberTest;
    }

    public int getIdLicense() {
        return this.idLicense;
    }

    public void setIdLicense(int idLicense) {
        this.idLicense = idLicense;
    }

    public int getNumberCorrectQuestion() {
        return this.numberCorrectQuestion;
    }

    public void setNumberCorrectQuestion(int numberCorrectQuestion) {
        this.numberCorrectQuestion = numberCorrectQuestion;
    }

    public int getTotalQuestion() {
        return this.totalQuestion;
    }

    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public int getTimeTest() {
        return this.timeTest;
    }

    public void setTimeTest(int timeTest) {
        this.timeTest = timeTest;
    }

    public String getLicenseDes() {
        return this.licenseDes;
    }

    public void setLicenseDes(String licenseDes) {
        this.licenseDes = licenseDes;
    }

    public String getLicense() {
        return this.license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
