package Functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TableFunctions {
    private Connection dbo = new DBRequests().getDbo();
    private ResultSet rs;


    public ResultSet getTableData() {
        try {
            // TODO
            // THIS METHOD SHOUDL BE REUSED FOR GETTING ALL DATA FROM DIFFERENT TABLES NOT JUST ONE.
            PreparedStatement ps = dbo.prepareStatement("SELECT * FROM Login");
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return rs;
        }
    }
}
