package com.ck.mcs;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Users implements Comparable<Patient> {
	private String gender;
	private int age;
	private List<String> questionList = new ArrayList<String>();
	private double distance;
	
	
	public double GetDistance(Patient p){
	    double result = Double.MAX_VALUE;
	    double genderDis = 0;
	    if(this.gender.compareTo(p.gender) == 0){
	        genderDis = 0;
	    }
	    else{
	        genderDis = 1;
	    }
	    double ageDis = 0;
	    ageDis =Math.abs(this.age - p.getAge()) / 100.0;
	    double questionDis = Double.MAX_VALUE;
	    System.out.println("输出QID1 "+ questionList.size());
        System.out.println("输出Qid2 "+p.getQuestionList().size());
	    boolean flag = false;
	    for(String qID1:questionList)
	        for(String qID2:p.getQuestionList()){
	            
	            
	            if(qID1.compareTo(qID2)==0){
	                if(flag == true){
	                    questionDis ++;
	                }
	                else{
	                    flag = true;
	                    questionDis=1;
	                }
	            }
	    }
	    if(questionDis == Double.MAX_VALUE){
	        questionDis=3;
	    }
	    
	    else{
	    questionDis = 1.0/questionDis;
	    }
	    System.out.println("输出问题距离    "+questionDis);
	    result = Math.sqrt(genderDis + ageDis + questionDis);
	    return result;
	}
	
	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the questionList
     */
    public List<String> getQuestionList() {
        return questionList;
    }

    /**
     * @param questionList the questionList to set
     */
    public void setQuestionList(List<String> questionList) {
        this.questionList = questionList;
    }

    /**
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }



    @Override
    public int compareTo(Patient arg0) {
        if(this.distance>arg0.getDistance())
            return 1;
        else if(this.distance<arg0.getDistance())
            return -1;
        else
            return 0;
    }
	
}
