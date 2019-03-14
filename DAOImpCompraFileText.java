import java.io.FileWriter;
import java.io.IOException;


public class DAOImpCompraFileText implements DAOCompra {
	private FileWriter fichero;

    public DAOImpCompraFileText() {
    	try  {
	     	this.fichero = new FileWriter("datos/compras.txt",true);
	    }
	    catch (IOException e) {
			System.err.println("ERROR");
			System.err.println("An IOException was caught :" + e.getMessage());
		} 
	}

	public void grabar(Compra a) {
		String datos = "";
		datos += a.getPer().getName() + ":";
        datos += a.getPro().getNombre() + ":";
        datos += a.getPro().getMarca() + ":";
        datos += a.getCant() + ":";
        datos += a.getPro().getPrecio() + ":";
        try {
        	fichero = new FileWriter("datos/compras.txt",true);
        	fichero.write(datos + "\n");
	        fichero.close();    
        }
        catch (IOException e) {
			System.err.println("ERROR");
			System.err.println("An IOException was caught :" + e.getMessage());
		} 
        

    }
}



