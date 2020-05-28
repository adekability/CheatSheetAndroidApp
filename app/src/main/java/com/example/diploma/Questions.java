package com.example.diploma;

public class Questions {
    // fields
    public String questionName;
    public String questionShortCode;
    public String questionAnswer;
    // constructors
    public Questions() {}
    public Questions( String questionName,String questionShortCode,String questionAnswer) {
        this.questionName = questionName;
        this.questionShortCode = questionShortCode;
        this.questionAnswer = questionAnswer;
    }
    // properties


    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionShortCode(String questionShortCode) {
        this.questionShortCode = questionShortCode;
    }

    public String getQuestionShortCode() {
        return questionShortCode;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }
}