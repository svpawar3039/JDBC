//import package of sql
import java.sql.*;

class JDBCExample{
    public static void main(String[] args) throws Exception {

        //getting database name in and location in variable url
        String url = "jdbc:mysql://localhost:3306/student";

        //getting username in user variable
        String user = "root";

        //getting password of localhost mysql server in pass variable
        String pass = "#Sagar@3039";

        //query that we wants to perform on database
        String query = "select * from studentrecords where id=101";


            // Loaded and register drivers of mysql (because we used mysql for creating db)
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Establishing a connection between java program and database of following details
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Established Successfully");

            //Created Statement
            Statement st = con.createStatement();

            //getting result with the help of statement obj.executeQuery
            ResultSet rs = st.executeQuery(query);

            //Printing Results from rs
            while (rs.next()) {
                System.out.print("Id = " + rs.getInt("id"));
                System.out.print("name = " + rs.getString("name"));
                System.out.print("age = " + rs.getInt("age"));
            }

            //Closing the statement and connection 
            st.close();
            con.close();

    }
}