package ptit.nttrung.thibanglayxe.model;

import java.io.Serializable;

public class Question implements Serializable {
    private String questionAnswer;
    private String questionAnswerUser;
    private String questionContent;
    private String questionDes;
    private int questionID;
    private String questionImage;
    private int questionLearned;
    private int questionMarked;
    private String questionOp1;
    private String questionOp2;
    private String questionOp3;
    private String questionOp4;
    private int questionType;
    private int questionWrong;

    public int getQuestionID() {
        return this.questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getQuestionLearned() {
        return this.questionLearned;
    }

    public void setQuestionLearned(int questionLearned) {
        this.questionLearned = questionLearned;
    }

    public int getQuestionMarked() {
        return this.questionMarked;
    }

    public void setQuestionMarked(int questionMarked) {
        this.questionMarked = questionMarked;
    }

    public int getQuestionWrong() {
        return this.questionWrong;
    }

    public void setQuestionWrong(int questionWrong) {
        this.questionWrong = questionWrong;
    }

    public int getQuestionType() {
        return this.questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public String getQuestionDes() {
        return this.questionDes;
    }

    public void setQuestionDes(String questionDes) {
        this.questionDes = questionDes;
    }

    public String getQuestionAnswer() {
        return this.questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getQuestionImage() {
        return this.questionImage;
    }

    public void setQuestionImage(String questionImage) {
        this.questionImage = questionImage;
    }

    public String getQuestionOp1() {
        return this.questionOp1;
    }

    public void setQuestionOp1(String questionOp1) {
        this.questionOp1 = questionOp1;
    }

    public String getQuestionOp2() {
        return this.questionOp2;
    }

    public void setQuestionOp2(String questionOp2) {
        this.questionOp2 = questionOp2;
    }

    public String getQuestionOp3() {
        return this.questionOp3;
    }

    public void setQuestionOp3(String questionOp3) {
        this.questionOp3 = questionOp3;
    }

    public String getQuestionOp4() {
        return this.questionOp4;
    }

    public void setQuestionOp4(String questionOp4) {
        this.questionOp4 = questionOp4;
    }

    public String getQuestionContent() {
        return this.questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionAnswerUser() {
        return this.questionAnswerUser;
    }

    public void setQuestionAnswerUser(String questionAnswerUser) {
        this.questionAnswerUser = questionAnswerUser;
    }
}
