package bank.management.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    public Conn(){


        try {
// Class.forName(com.mysql.cj.jdbc.Driver);  //this is register the driver ----- also, when the zar file added in the library, no need to explicitly register the driver
            c= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankmanagementsystem","root","Clnja2626789@");  // creating the connection
            s=c.createStatement();  // create the statement
        }
        catch (Exception e){
            System.out.println(e);
        }

    }


}


/*there are 5 steps to create the connection
-->1-> register the driver
-->2-> create connection
-->3->create statement
-->4->execute query
-->5->close the connection
 */
