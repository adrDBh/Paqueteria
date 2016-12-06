package Functions;

import sun.security.krb5.internal.crypto.Des;

import java.sql.*;
import java.util.concurrent.Callable;

public class TableFunctions {
    private Connection dbo = new DBRequests().getDbo();
    private PreparedStatement ps;
    private ResultSet rs;
    private Utilities u = new Utilities();


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
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        } finally {
            ps = null;
            return bool;
        }
    }

    public boolean createClient(String Name, String APP, String APM, String Phone, String PhoneDesc, String Email, String EmailDesc) {
        boolean bool = false;
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spRepeatedClient ?,?,?");
            st.setString(1, u.Capitalize(Name));
            st.setString(2, u.Capitalize(APP));
            st.setString(3, u.Capitalize(APM));
            boolean isRepeated = st.executeQuery().next();
            if (isRepeated) {
                bool = false;
            } else {
                bool = true;
                CallableStatement sto = dbo.prepareCall("EXECUTE spInsertClient ?,?,?,?,?,?,?");
                sto.setString(1, u.Capitalize(Name));
                sto.setString(2, u.Capitalize(APP));
                sto.setString(3, u.Capitalize(APM));
                sto.setString(4, Phone);
                sto.setString(5, PhoneDesc);
                sto.setString(6, Email);
                sto.setString(7, EmailDesc);
                sto.execute();
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        } finally {
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
            System.err.println("Error de SQL: " + e.getMessage());
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
            System.err.println("Error de SQL: " + e.getMessage());
        } finally {
            return rs;
        }
    }

    public void deleteClient(int ID) {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spDelClient ?");
            st.setInt(1, ID);
            st.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void editPhone(int ID, String editedPhone, String editedDescription) {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spEditPhone ?,?,?");
            st.setInt(1, ID);
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
            System.err.println("Error de SQL: " + e.getMessage());
        }
    }

    public void delPhone(int ID) {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spDelPhone ?");
            st.setInt(1, ID);
            st.execute();
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        }
    }

    public void editClient(int ID, String Name, String APP, String APM) {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spEditClient ?,?,?,?");
            st.setInt(1, ID);
            st.setString(2, u.Capitalize(Name));
            st.setString(3, u.Capitalize(APP));
            st.setString(4, u.Capitalize(APM));
            st.execute();
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        }
    }

    public ResultSet getEmailData(int ID) {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spListClientEmails ?");
            st.setInt(1, ID);
            rs = st.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        } finally {
            return rs;
        }
    }

    public void editEmail(int ID, String Email, String Description) {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spEditEmail ?,?,?");
            st.setInt(1, ID);
            st.setString(2, Email);
            st.setString(3, Description);
            st.execute();
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        }
    }

    public void delEmail(int ID) {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spDelEmail ?");
            st.setInt(1, ID);
            st.execute();
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        }
    }

    public void newEmail(int ID, String newPhone, String newDescription) {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spAddClientEmail ?,?,?");
            st.setInt(1, ID);
            st.setString(2, newPhone);
            st.setString(3, newDescription);
            st.execute();
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        }
    }

    public ResultSet getEmployeeData() {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spListEmployee");
            rs = st.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        } finally {
            return rs;
        }
    }

    public void deleteEmployee(int ID) {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spDelEmployee ?");
            st.setInt(1, ID);
            st.execute();
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        }
    }

    public void editEmployee(int ID, String Name, String APP, String APM, String TURN) {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spEditEmployee ?,?,?,?,?");
            st.setInt(1, ID);
            st.setString(2, u.Capitalize(Name));
            st.setString(3, u.Capitalize(APP));
            st.setString(4, u.Capitalize(APM));
            st.setString(5, u.Capitalize(TURN));
            st.execute();
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        }
    }

    public boolean createEmployee(String Name, String APP, String APM, String Email, String EmailDesc, String Turn) {
        boolean bool = false;
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spRepeatedEmployee ?, ?, ?");
            st.setString(1, u.Capitalize(Name));
            st.setString(2, u.Capitalize(APP));
            st.setString(3, u.Capitalize(APM));
            boolean isRepeated = st.executeQuery().next();
            if (isRepeated) {
                bool = false;
            } else {
                bool = true;
                CallableStatement sto = dbo.prepareCall("EXECUTE spInsertEmployee ?,?,?,?,?,?");
                sto.setString(1, u.Capitalize(Name));
                sto.setString(2, u.Capitalize(APP));
                sto.setString(3, u.Capitalize(APM));
                sto.setString(4, Email);
                sto.setString(5, EmailDesc);
                sto.setString(6, Turn);
                sto.execute();
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        } finally {
            return bool;
        }
    }

    public ResultSet getEmployeeEmails(int ID) {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spListEmployeeEmails ?");
            st.setInt(1, ID);
            rs = st.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        } finally {
            return rs;
        }
    }

    public void delEmployeeEmail(int ID) {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spDelEmployeeEmail ?");
            st.setInt(1, ID);
            st.execute();
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        }
    }

    public void newEmployeeEmail(int ID, String Email, String Desc) {
        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spAddEmployeeEmail ?,?,?");
            st.setInt(1, ID);
            st.setString(2, Email);
            st.setString(3, Desc);
            st.execute();
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        }
    }

    public void newService(String ClientName, String ClientAPP, String ClientAPM,
                           String Fragil, String Prioridad, String Peso,
                           String Alto, String Largo, String Ancho,
                           String Descripcion, String EmpName, String EmpApp,
                           String EmpApm, String O_Calle, String O_Numero,
                           String O_Colonia, String O_CP, String O_Ciudad,
                           String O_Estado, String Origen, String D_Calle,
                           String D_Numero, String D_Colonia, String D_CP,
                           String D_Ciudad, String D_Estado, String Destino,
                           String Folio, String Costo, String Transporte) {

        try {
            CallableStatement st = dbo.prepareCall("EXECUTE spCreateService ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
            st.setString(1, ClientName);
            st.setString(2, ClientAPP);
            st.setString(3, ClientAPM);
            // DATOS DE CLIENTE
            st.setString(4, Fragil);
            st.setString(5, Prioridad);
            st.setString(6, Peso);
            st.setString(7, Alto);
            st.setString(8, Largo);
            st.setString(9, Ancho);
            st.setString(10, Descripcion);
            // DATOS DE PAQUETE
            st.setString(11, EmpName);
            st.setString(12, EmpApp);
            st.setString(13, EmpApm);
            // DATOS DEL EMPLEADO
            st.setString(14, O_Calle);
            st.setString(15, O_Numero);
            st.setString(16, O_Colonia);
            st.setString(17, O_CP);
            st.setString(18, O_Ciudad);
            st.setString(19, O_Estado);
            st.setString(20, Origen);
            // DATOS DEL ORIGEN
            st.setString(21, D_Calle);
            st.setString(22, D_Numero);
            st.setString(23, D_Colonia);
            st.setString(24, D_CP);
            st.setString(25, D_Ciudad);
            st.setString(26, D_Estado);
            st.setString(27, Destino);
            // DATOS DEL DESTINO
            st.setString(28, Folio);
            st.setString(29, Costo);
            st.setString(30, Transporte);
            // DATOS DEL RASTREO
            st.execute();
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        }
    }
}
