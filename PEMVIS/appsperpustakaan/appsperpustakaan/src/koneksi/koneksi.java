
package koneksi;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class koneksi {
    private Connection koneksi ;
    public Connection connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException ex ){
            System.out.println ("gagal koneksi "+ex);
        }
        String url="jdbc:mysql://localhost/perpustakaan";
        try {
            koneksi = DriverManager.getConnection(url,"root","");
            System.out.println("berhasil koneksi database");
            
        }
        catch(SQLException ex){
            System.out.println("berhasil koneksi database"+ex);
         }
        
         return koneksi;
        }
    }


