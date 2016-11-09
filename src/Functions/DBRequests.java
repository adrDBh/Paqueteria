package Functions;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class DBRequests {

    private Connection dbo;
    private String user;
    private String LastLogin;
    Date dateToday = new Date();
    Timestamp todayStamp = new Timestamp(dateToday.getTime());

    // CONSTRUCTOR
    public DBRequests() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            setDbo(DriverManager.getConnection("jdbc:jtds:sqlserver://localhost;databaseName=Paqueteria;user=sa;password=c0e03f8dae;"));
        } catch (ClassNotFoundException e) {
            System.err.println("Clase: " + e.getMessage() + " no encontrada");
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // CONNECTION OBJECT GETTER
    public Connection getDbo() {
        return dbo;
    }

    // CONNECTION OBJECT SETTER
    public void setDbo(Connection dbo) {

        this.dbo = dbo;
    }

    // EMPLOYEE NAME GETTER
    public String getUser() {
        return user;
    }

    // EMPLOYEE NAME SETTER
    public void setUser(String user) {
        this.user = user;
    }

    public String getLastLogin() {
        return LastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.LastLogin = lastLogin;
    }

    // LOGIN QUERY METHOD
    public boolean getLogin(String usuario, String password) {
        ResultSet rs;
        boolean bool = false;
        try {
            PreparedStatement updateString = dbo.prepareStatement("SELECT username, password, LastLogin FROM login WHERE username = ? AND password = ?");
            updateString.setString(1, usuario);
            updateString.setString(2, password);
            rs = updateString.executeQuery();
            if (rs.next()) {
                if (usuario.equals(rs.getString("Username")) && password.equals(rs.getString("Password"))) {
                    bool = true;
                    setUser(usuario);
                    setLastLogin(rs.getString("LastLogin"));
                    PreparedStatement setCurrentStamp = dbo.prepareStatement("UPDATE Login SET LastLogin = ? WHERE Username = ?");
                    setCurrentStamp.setString(1, todayStamp.toString());
                    setCurrentStamp.setString(2, rs.getString("Username"));
                    setCurrentStamp.execute();
                }
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return bool;
        }
    }

    public boolean CreateUser(String username, String password) {
        boolean bool = false;
        try {
            PreparedStatement repeatedDataVerification = dbo.prepareStatement("SELECT Username FROM login WHERE Username = ?");
            repeatedDataVerification.setString(1, username);
            boolean isRepeated = repeatedDataVerification.executeQuery().next();
            if (isRepeated) {
                bool = false;
            } else {
                bool = true;
                PreparedStatement newUser = dbo.prepareStatement("INSERT INTO Login VALUES(?,?,?,NULL)");
                newUser.setString(1, username);
                newUser.setString(2, password);
                newUser.setString(3, todayStamp.toString());
                newUser.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return bool;
        }
    }
}
