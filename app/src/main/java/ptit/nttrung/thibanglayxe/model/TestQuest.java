package ptit.nttrung.thibanglayxe.model;

import java.io.Serializable;

public class TestQuest implements Serializable {
    private String history;
    private Question question;
    private int testId;
    private int testQuestID;
    private String zAnswer;
    private int zQuestionId;

    public int getTestQuestID() {
        return this.testQuestID;
    }

    public void setTestQuestID(int testQuestID) {
        this.testQuestID = testQuestID;
    }

    public int getTestId() {
        return this.testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getzQuestionId() {
        return this.zQuestionId;
    }

    public void setzQuestionId(int zQuestionId) {
        this.zQuestionId = zQuestionId;
    }

    public Question getQuestion() {
        return this.question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getzAnswer() {
        return this.zAnswer;
    }

    public void setzAnswer(String zAnswer) {
        this.zAnswer = zAnswer;
    }

    public String getHistory() {
        return this.history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
