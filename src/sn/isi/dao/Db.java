package sn.isi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Db {
    private Connection cnx;
    private PreparedStatement pstm;
    private ResultSet rs;
    private static Db db;

    public  void open () throws Exception{
        String url="jdbc:mysql://localhost:3306/gestionemail";
        //"mysql:host="
        String mysqluser="root";
        String mysqlpassword="";
        Class.forName("com.mysql.jdbc.Driver");
        cnx = DriverManager.getConnection(url ,mysqluser ,mysqlpassword);
    }
    public  void  init(String sql)throws Exception{
        this.open();
        pstm = cnx.prepareStatement(sql);
    }
    public  int executeUdate()throws Exception{
        int ok =0;
        ok = pstm.executeUpdate();
        return ok;
    }
    public ResultSet executeSelect() throws Exception{
        rs = pstm.executeQuery();
        return rs;
    }
    public PreparedStatement getPstm() {

        return pstm;
    }
    public  void  close() throws  Exception{
        if(cnx != null){
            cnx.close();
        }
    }
}
