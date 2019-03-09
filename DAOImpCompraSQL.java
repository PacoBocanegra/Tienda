import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

public class DAOImpCompraSQL implements DAOCompra {
	private static final String URL = "jdbc:sqlite:datos/compras.db";
        public DAOImpCompraSQL() {
        	CreateDB();
        	CreateTable();
        	
		}

	public void grabar(Compra a){
		
		String cliente = a.getPer().getName();
        String nombre = a.getPro().getNombre();
        String marca = a.getPro().getMarca();
        int cant = a.getCant();
		Double precio = a.getPro().getPrecio();
		Date fechas = new Date();
      	String fecha = fechas.toString();
		insertar(cliente, nombre, marca, cant, precio, fecha);
	}
	private void insertar(String cliente, String nombre, String marca, int cant, Double precio, String fecha) {
		final String SQL = "INSERT INTO compras VALUES(?,?,?,?,?,?)";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(SQL);) {
		    ps.setString(1, cliente);
		    ps.setString(2, nombre);
		    ps.setString(3, marca);
		    ps.setInt(4, cant);
		    ps.setDouble(5, precio);
		    ps.setString(6, fecha);
		    ps.executeUpdate();	    
		}
		catch (SQLException e) {
		    System.out.println(e.getMessage());
		}
	}

	private static void CreateTable() {
		final String SQL = "CREATE TABLE IF NOT EXISTS compras (cliente text, nombre text, marca text, cant integer, precio double, fecha text primary key);";
		try (Connection con = getConnection(); Statement statement = con.createStatement();) {
			statement.executeUpdate(SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    private static void CreateDB() {
		try (Connection conn = getConnection()) {
			if (conn != null) {
				conn.getMetaData();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL);
	}
}



       