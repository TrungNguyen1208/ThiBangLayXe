package ptit.nttrung.thibanglayxe.model;

import java.io.Serializable;

public class NumberQuestionPerType implements Serializable {
    private int numberQuest;
    private int questCategory;

    public int getQuestCategory() {
        return this.questCategory;
    }

    public void setQuestCategory(int questCategory) {
        this.questCategory = questCategory;
    }

    public int getNumberQuest() {
        return this.numberQuest;
    }

    public void setNumberQuest(int numberQuest) {
        this.numberQuest = numberQuest;
    }
}
