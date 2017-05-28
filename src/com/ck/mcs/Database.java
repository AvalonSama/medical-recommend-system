package com.ck.mcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private String User = "";
    private String Password = "";
    private String Host = "";
    private String Database = "";
    private String url = "";
    private Connection con = null;
    Statement stmt;
    
    
    public Database(String host, String database, String user, String password){
        this.Host = host;
        this.setDatabase(database);
        this.User = user;
        this.Password = password;
        this.url="jdbc:sqlserver://" + Host + ";" + "DatabaseName=" + database+";";
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch(ClassNotFoundException e){
            System.err.println("Class not found" + e.getMessage());
        }
        try{
            setCon(DriverManager.getConnection(this.url, this.User, this.Password));
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    public int Count(String table){
        int num=0;
        ResultSet rs;
        String sql="select count(*) from [MedicalRecommend].[dbo].["+table+"]";
        try {
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                num=rs.getInt(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(num);
        return num;
    }
    
    public ResultSet executeQuery(String sql){
        ResultSet rs=null;
        try{
            rs = stmt.executeQuery(sql);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    @SuppressWarnings("finally")
    public boolean executeUpdate(String sql){
        boolean v = false;
        try{
            v = stmt.executeUpdate(sql)>0 ? true:false;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            return v;
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getDatabase() {
        return Database;
    }

    public void setDatabase(String database) {
        Database = database;
    }
    
}
