package com.enigma.android.myapplication;

public class Place {
    private int ID;
    private String STREET;
    private String ANSWERRIGHT;
    private String ANSWERLEFT;

    public Place() {
        ID=0;
        STREET ="";
        ANSWERRIGHT="";
        ANSWERLEFT="";
    }

    public Place(String sTREET, String aNWERRIGHT, String aNSWERLEFT) {
        STREET = sTREET;
        ANSWERRIGHT = aNWERRIGHT;
        ANSWERLEFT = aNSWERLEFT;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSTREET() {
        return STREET;
    }

    public void setSTREET(String STREET) {
        this.STREET = STREET;
    }

    public String getANSWERRIGHT() {
        return ANSWERRIGHT;
    }

    public void setANSWERRIGHT(String ANSWERRIGHT) {
        this.ANSWERRIGHT = ANSWERRIGHT;
    }

    public String getANSWERLEFT() {
        return ANSWERLEFT;
    }

    public void setANSWERLEFT(String ANSWERLEFT) {
        this.ANSWERLEFT = ANSWERLEFT;
    }
}
