package com.ck.mcs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException{
        CF cf =new CF();
        Patient p = new Patient();
        ResultSet rs = DataIssues.QueryAll("User");
        try {
            while(rs.next()){
                Patient tempP = new Patient();
                p.setName(rs.getString("UserName"));
                p.setAge(rs.getInt("UserAge"));
                p.setGender(rs.getString("UserGender"));
                break;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cf = new CF(p);
        
    }
}
