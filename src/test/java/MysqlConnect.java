import java.sql.*;
 
public class MysqlConnect{
  public static void main(String[] args) {
  System.out.println("MySQL Connect Example.");
  Connection conn = null;
  String url = "jdbc:mysql://192.168.3.51:3306/";
  String dbName = "testandreport";
  String driver = "com.mysql.jdbc.Driver";
  String userName = "root"; 
  String password = "root";
  try {
	  
  Class.forName(driver).newInstance();
  conn = DriverManager.getConnection(url+dbName,userName,password);
  System.out.println("Connected to the database"+conn);
  conn.close();
  System.out.println("Disconnected from database");
  } catch (Exception e) {
  e.printStackTrace();
  }
  }
}