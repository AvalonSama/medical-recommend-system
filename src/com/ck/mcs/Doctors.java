package com.ck.mcs;

public class Doctors extends Users {
	private String Class;
	private String Hospital;
	private String Grade;
	private int ACTimes;
	private String Introduction;
	
    public String getclass() {
        return Class;
    }

    public void setClass(String class1) {
        Class = class1;
    }

    public String getHospital() {
        return Hospital;
    }

    public void setHospital(String hospital) {
        Hospital = hospital;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public int getACTimes() {
        return ACTimes;
    }

    public void setACTimes(int aCTimes) {
        ACTimes = aCTimes;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }


}
