package com.ck.mcs;

public class Question {
    private int QuestionID;
    private String QuestionTitle;
    private String QuestionClass;
    private String QuestionText;
    private String QuestionCreateTime;
    private String QuestionFrom;
    public String getQuestionTitle() {
        return QuestionTitle;
    }
    public void setQuestionTitle(String questionTitle) {
        QuestionTitle = questionTitle;
    }
    public String getQuestionClass() {
        return QuestionClass;
    }
    public void setQuestionClass(String questionClass) {
        QuestionClass = questionClass;
    }
    public String getQuestionText() {
        return QuestionText;
    }
    public void setQuestionText(String questionText) {
        QuestionText = questionText;
    }
    public String getQuestionCreateTime() {
        return QuestionCreateTime;
    }
    public void setQuestionCreateTime(String questionCreateTime) {
        QuestionCreateTime = questionCreateTime;
    }
    public String getQuestionFrom() {
        return QuestionFrom;
    }
    public void setQuestionFrom(String questionFrom) {
        QuestionFrom = questionFrom;
    }
    /**
     * @return the questionID
     */
    public int getQuestionID() {
        return QuestionID;
    }
    /**
     * @param questionID the questionID to set
     */
    public void setQuestionID(int questionID) {
        QuestionID = questionID;
    }
}
