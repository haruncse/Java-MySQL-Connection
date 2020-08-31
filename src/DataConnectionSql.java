
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MD. HARUN-AR-RASHID
 */
//public String std1;
public class DataConnectionSql {
     private Connection con;
    private Statement st;
    private ResultSet rs;
     public DataConnectionSql(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/department","harun","cse");
        st = con.createStatement();
    
        
        
    }
    catch(ClassNotFoundException | SQLException ex){
        System.out.println("Error :"+ex);
    }
}
   public void insetData(String i,String n,String a) throws SQLException{
       String query3 = "insert into student values('"+i+"','"+n+"',"+a+")";
      PreparedStatement preparedStmt2 = con.prepareStatement(query3);
      preparedStmt2.execute();
       
   }
   public void updateDatan(String i,String n) throws SQLException{
       
        String query4 = "update student set name='"+n+"' where id = '"+i+"'";
      PreparedStatement preparedStmt3 = con.prepareStatement(query4);
     preparedStmt3.execute();
   }
    public void updateDataa(String i,String a) throws SQLException{
       
        String query4 = "update student set age="+a+" where id = '"+i+"'";
      PreparedStatement preparedStmt3 = con.prepareStatement(query4);
     preparedStmt3.execute();
   }
    public void deleteData(String i) throws SQLException{
       
         String query2 = "delete from student where id ='"+i+"'";
      PreparedStatement preparedStmt = con.prepareStatement(query2);
     preparedStmt.execute();
    
   }
   public String getData(){
       String Ad = "";
        DataInputF pt= new DataInputF();
       try{
           
//         SELECT STATEMENT
     String query ="select*from student";
           rs = st.executeQuery(query);
    
           System.out.println("Data Base Created From Table");
//            StringBuilder sb = new StringBuilder(1000);
             int a,i;
              String[] Ar=new String[100];  
              
             a=0;
           while(rs.next()){
//               int a[];
              String n;
             String id =rs.getString("id");   
            String name =rs.getString("name"); 
            String age =rs.getString("age"); 
            pt.jTextArea1.setText("ID: "+id+"NAME: "+name+"AGE: "+age+"\n");
//            pt.setVisible(true);
            //pt.jTextArea1.setText("\n");
            n ="Id: "+id+"Name: "+name+"  "+"Age: "+age;
            Ar[a]=n;
            
            System.out.println("Id: "+id+"Name: "+name+"  "+"Age: "+age);

a++;

                    
            
           }
           
           i=a;
           for (int j = 0; j < i; j++)
           {
                  Ad=Ad+Ar[j]+"\n"; 
           }
//           public Static String std1;
//           std=Ad;
       System.out.println(Ad);
          pt.jLabel5.setText(Ad);  
         pt.jTextArea1.setText(Ad);
         pt.DS(Ad);
           
       }catch(Exception ex){
           System.out.println(ex);
       }
//       pt.setVisible(true);
         return Ad;
   }
    
    
}
