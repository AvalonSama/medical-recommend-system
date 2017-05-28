package com.ck.mcs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CF {
    private Patient patient;
    private List<Patient> neighborList = new ArrayList<Patient>();
    
    public CF(){
        
    }

    public void SetPdis() {
        try {
            List<String> questionList = new ArrayList<String>();
            questionList.clear();
            String userName = patient.getName();
            ResultSet rsTemp = DataIssues.QueryAll("Question");
            while (rsTemp.next()) {
                String questionFrom = rsTemp.getString("QuestionFrom");
                if (questionFrom.compareTo(userName) == 0) {
                    questionList.add(rsTemp.getString("QuestionClass"));
                }
            }
            patient.setQuestionList(questionList);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return;
    }
    
    public CF(Patient patientT) throws SQLException{
        this.patient = patientT;
        ResultSet rs = DataIssues.QueryAll("User");
        
        SetPdis();
        
        while(rs.next()){
            Patient tempP = new Patient();
            List<String> questionList = new ArrayList<String>();
            questionList.clear();
            try {
                String userName = rs.getString("UserName");
                String gender = rs.getString("UserGender");
                int age = rs.getInt("UserAge");
                tempP.setAge(age);
                tempP.setGender(gender);
                tempP.setName(userName);
                ResultSet rsTemp = DataIssues.QueryAll("Question");
                while(rsTemp.next()){
                    String questionFrom = rsTemp.getString("QuestionFrom");
                    if(questionFrom.compareTo(userName) == 0){
                        System.out.println("问题来源   "+questionFrom+",,,,"+"当前用户"+userName);
                        questionList.add(rsTemp.getString("QuestionClass"));
                    }
                }
                
                tempP.setQuestionList(questionList);
                if(tempP.getName().compareTo(patientT.getName())==0){
                    patientT.setQuestionList(questionList);
                }
                System.out.println("输出传入的问题大小"+tempP.getQuestionList().size());
                tempP.setDistance(patientT.GetDistance(tempP));
                neighborList.add(tempP);
                System.out.println(neighborList.size());
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<Question> Recommend() throws SQLException {
        List<Question> questionList = new ArrayList<Question>();
        Collections.sort(neighborList);
        for (Patient tempP : neighborList) {
            System.out.println("Show distance");
            System.out.println(tempP.getDistance());
            ResultSet rs = DataIssues.QueryAll("Question");
            while (rs.next()) {
                String questionFrom = rs.getString("QuestionFrom");
                if (tempP.getName().compareTo(questionFrom) == 0) {
                    Question q = new Question();
                    q.setQuestionID(rs.getInt("QuestionID"));
                    q.setQuestionClass(rs.getString("QuestionClass"));
                    q.setQuestionTitle(rs.getString("QuestionTitle"));
                    q.setQuestionCreateTime(rs.getString("QuestionCreateTime"));
                    q.setQuestionFrom(rs.getString("QuestionFrom"));
                    q.setQuestionText(rs.getString("QuetionText"));
                    questionList.add(q);
                }
            }
        }
        System.out.print(questionList.size());
        return questionList;
    }
}
