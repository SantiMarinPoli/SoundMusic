package co.com.soundMusic.utilidades;

import java.io.FileOutputStream;
import java.sql.Connection;
import org.dbunit.database.AmbiguousTableNameException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.oracle.OracleDataTypeFactory;

/**
 *
 * @author Santiago Medina Peláez
 */
public class DatabaseExportSample {

    public static void main(String[] args) throws Exception {
        // database connection        
        Class driverClass = Class.forName("oracle.jdbc.OracleDriver");
        Connection jdbcConnection = DBUtil.getConexion();
        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

        DatabaseConfig config = connection.getConfig();
        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());

        // partial database export
        partialExport(connection);

        // full database export
        fullExport(connection);
    }

    private static void partialExport(IDatabaseConnection connection)
            throws AmbiguousTableNameException, Exception {
        QueryDataSet partialDataSet = new QueryDataSet(connection);
        //partialDataSet.addTable("FOO", "SELECT * FROM TABLE WHERE COL='VALUE'");
        partialDataSet.addTable("LOG_AUDITORIA");
        FlatXmlDataSet.write(partialDataSet, new FileOutputStream("test/dataBase/partial.xml"));
    }

    private static void fullExport(IDatabaseConnection connection)
            throws AmbiguousTableNameException, Exception {
        String[] nombreTablas = {"ARTISTA", "EMPRESA_DIFUSORA", "USUARIO", "LOG_AUDITORIA"};
        IDataSet fullDataSet = connection.createDataSet(nombreTablas);
        FlatXmlDataSet.write(fullDataSet, new FileOutputStream("test/dataBase/full.xml"));
    }
}
