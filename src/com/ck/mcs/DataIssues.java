package com.ck.mcs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataIssues {
    
    public static int userID = 0;
    public static int doctorID = 0;
    public static int informationID = 0;

    public static synchronized boolean Insert(String table, Object o){
        Database db=new Database("localhost:1433","MedicalRecommend","sa","111111");
        boolean result = false;
        String sql = "";
        String c=table;
        System.out.println(c);
        if("User".equals(c)){
            userID = db.Count(c)+1;
            Patient temp  = (Patient)o;
            sql="insert into [MedicalRecommend].[dbo].[User] values ( "
                    + userID + ","
                    +"'"+ temp.getName().toString()+"'"+","
                    +"'"+ temp.getPwd()+"'"+","
                    +temp.getAge()+","
                    +"'"+ temp.getGender()+"'"+","
                    +"'"+ temp.getTel()+"'"+","
                    +"'"+ temp.getEmail()+"'"+","
                    +"'"+ temp.getCreateTime()+"'"
                    + ")";
        }
        else if("Doctor".equals(c)){
            doctorID=db.Count(c);
            Doctors temp = (Doctors)o;
            sql="insert into [MedicalRecommend].[dbo].[Doctor] values ( "
                    + doctorID +","
                    +"'" + temp.getName().toString()+"'"+","
                    +"'" + temp.getPwd()  +"'" +","
                    +"'" + temp.getclass()+"'" +","
                    +"'" + temp.getEmail()+"'" +","
                    +"'"+ temp.getTel()+"'"+","
                    +"'"+ temp.getHospital()+"'"+","
                    +"'"+ temp.getPicture()+"'"+","
                    +"'"+ temp.getGrade()+"'"+","
                    +"'"+ temp.getCreateTime()+"'"+","
                    + temp.getACTimes()+","
                    +"'"+ temp.getIntroduction()+"'"
                    + ")";
        }
        else if("Question".equals(c)){
            int questionID=db.Count(c);
            System.out.println(questionID);
            questionID++;
            Question temp=(Question)o;
            sql="insert into [MedicalRecommend].[dbo].[Question] values ( "
                    + questionID +","
                    +"'" + temp.getQuestionClass()+"'"+","
                    +"'" + temp.getQuestionTitle()  +"'" +","
                    +"'" + temp.getQuestionCreateTime()+"'" +","
                    +"'" + temp.getQuestionFrom()+"'" +","
                    +"'" + temp.getQuestionText()+"'" 
                    + ")";
        }
        else if("Answer".equals(c)){
            int ansID = db.Count(c);
            ansID++;
            Answer temp = (Answer)o;
            sql="insert into [MedicalRecommend].[dbo].[Answer] values ( "
                    + ansID +","
                    +"'" + temp.getAnswerTo()+"'"+","
                    +"'" + temp.getAnswerFrom()  +"'" +","
                    +"'" + temp.getAnswerCreateTime()+"'" +","
                    +"'" + temp.getAnswerText()+"'" 
                    + ")";
        }
        System.out.println(sql);
        result = db.executeUpdate(sql);
        return result;
    }
    
    /*
     * ��ѯ����
     */
    @SuppressWarnings("resource")
    public static boolean QueryIdentify(String email, String Pwd, String role) throws SQLException{
        Database db=new Database("localhost:1433","MedicalRecommend","sa","111111");
        ResultSet rs;
        if("Doctor".equals(role)){
            String sql = "select * from [MedicalRecommend].[dbo].[Doctor]";
            rs = db.executeQuery(sql);
            while(rs.next()){
                boolean result = rs.getString("DoctorEmail").equals(email)&& rs.getString("DoctorPwd").equals(Pwd);
                if(result){
                    return result;
                }
            }
            return false;
        }
        
        if("User".equals(role)){
            String sql = "select * from [MedicalRecommend].[dbo].[User]";
            rs = db.executeQuery(sql);
            while(rs.next()){
                boolean result = rs.getString("UserEmail").equals(email)&& rs.getString("UserPwd").equals(Pwd);
                System.out.println(rs.getString("UserEmail"));
                if(result){
                    return result;
                }
            }
            
            return false;
        }
        return false;
    }
    public static ResultSet QueryAll(String table){
        Database db=new Database("localhost:1433","MedicalRecommend","sa","111111");
        ResultSet rs;
        String sql="select * from [MedicalRecommend].[dbo].[" + table +"]";
        rs=db.executeQuery(sql);
        try {
            System.out.println(rs.getString(1));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    

    
    
    public static String Query(String table, String know, String knowInfo, String unknow){
        Database db=new Database("localhost:1433","MedicalRecommend","sa","111111");
        String result=null;
        ResultSet rs;
        String sql="select "+unknow+" from [MedicalRecommend].[dbo].[" + table +"]" + " where " + know +"='" + knowInfo + "'";
        System.out.println(sql);
        rs=db.executeQuery(sql);
        try {
            while(rs.next()){
                try {
                    result=rs.getString(unknow);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
