package Functions;

import java.sql.*;

public class TableFunctions {
    private Connection dbo = new DBRequests().getDbo();
    PreparedStatement ps;
    private ResultSet rs;


    public ResultSet getTableData() {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE listLogin");
            rs = st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return rs;
        }
    }

    public boolean CreateUser(String username, String password) {
        boolean bool = false;
        try {
            ps = dbo.prepareStatement("SELECT Username FROM login WHERE Username = ?");
            ps.setString(1, username);
            boolean isRepeated = ps.executeQuery().next();
            if (isRepeated) {
                bool = false;
            } else {
                bool = true;
                PreparedStatement newUser = dbo.prepareStatement("INSERT INTO Login VALUES(?,?,?,NULL)");
                newUser.setString(1, username);
                newUser.setString(2, password);
                newUser.setTimestamp(3, new TimeStamps().getStamps());
                newUser.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps = null;
            return bool;
        }
    }

    public boolean deleteUser(int id) {
        boolean result = false;
        try {

            ps = dbo.prepareStatement("DELETE FROM Login WHERE idLogin = ?");
            ps.setInt(1, id);
            ps.execute();
            result = true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            return result;
        }
    }

    public boolean editUser(String username, String password, int id) {
        boolean result = false;
        try {
            ps = dbo.prepareStatement("UPDATE Login SET Username = ?, Password = ? WHERE idLogin = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3, id);
            ps.execute();
            result = true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            return result;
        }
    }

    public ResultSet getClientData() {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spListClient");
            rs = st.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            return rs;
        }
    }

    public ResultSet getPhoneData(int ID) {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spListClientPhones ?");
            st.setInt(1, ID);
            rs = st.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            return rs;
        }
    }

    public void deleteClient(int currentID) {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spDelClient ?");
            st.setInt(1, currentID);
            st.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void editPhone(int id, String editedPhone, String editedDescription) {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spEditPhone ?,?,?");
            st.setInt(1, id);
            st.setString(2, editedPhone);
            st.setString(3, editedDescription);
            st.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void newPhone(int ID, String newPhone, String newDescription) {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spAddClientPhone ?,?,?");
            st.setInt(1, ID);
            st.setString(2, newPhone);
            st.setString(3, newDescription);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
