package Functions;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class TableFunctions {
    private Connection dbo = new DBRequests().getDbo();
    private ResultSet rs;


    public ResultSet getTableData() {
        try {
            // TODO
            // THIS METHOD SHOULD BE REUSED FOR GETTING ALL DATA FROM DIFFERENT TABLES NOT JUST ONE.
            CallableStatement st = dbo.prepareCall("{call dbo.listLogin}");
            rs = st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return rs;
        }
    }
}
