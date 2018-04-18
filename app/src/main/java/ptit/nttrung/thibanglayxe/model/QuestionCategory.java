package ptit.nttrung.thibanglayxe.model;

import java.io.Serializable;

public class QuestionCategory implements Serializable {
    private int currentIndex;
    private String nameImage;
    private int numberQuest;
    private int numberQuestCorrect;
    private String questDes;
    private int questionCategoryID;

    public String getQuestDes() {
        return this.questDes;
    }

    public void setQuestDes(String questDes) {
        this.questDes = questDes;
    }

    public int getNumberQuest() {
        return this.numberQuest;
    }

    public void setNumberQuest(int numberQuest) {
        this.numberQuest = numberQuest;
    }

    public int getNumberQuestCorrect() {
        return this.numberQuestCorrect;
    }

    public void setNumberQuestCorrect(int numberQuestCorrect) {
        this.numberQuestCorrect = numberQuestCorrect;
    }

    public int getQuestionCategoryID() {
        return this.questionCategoryID;
    }

    public void setQuestionCategoryID(int questionCategoryID) {
        this.questionCategoryID = questionCategoryID;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public String getNameImage() {
        return this.nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }
}
