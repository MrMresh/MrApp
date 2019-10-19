package com.example.mrapp;

public class WordBank {
    private String name;
    private String importance1;
    private String importance2;
    private String importance3;
    private int error=0;
    private int success=0;
    private Boolean difficult;










    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getImportance1() {
        return importance1;
    }

    public String getImportance2() {
        return importance2;
    }

    public String getImportance3() {
        return importance3;
    }

    public String getName() {
        return name;
    }

    public Boolean getDifficult() {
        return difficult;
    }

    public int getError() {
        return error;
    }


    public void setError(int error) {
        this.error = error;
    }

    public void setDifficult(Boolean difficult) {
        this.difficult = difficult;
    }

    public void setImportance2(String importance2) {
        this.importance2 = importance2;
    }

    public void setImportance3(String importance3) {
        this.importance3 = importance3;
    }



    void isFalled (){this.error++;}
    void isDifficult(){setDifficult(true);}
    void isSucsess(){success++;}
    void isnotDifficult(){setDifficult(false);}












}
