package Functions;

import java.sql.*;

public class DBRequests {

    private Connection dbo;
    private String user;
    private String LastLogin;


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
                    setCurrentStamp.setString(1, new TimeStamps().getStamps());
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
}
