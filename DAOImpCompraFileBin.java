import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.File;


public class DAOImpCompraFileBin implements DAOCompra {
	private FileOutputStream outFile;
	private ObjectOutputStream out;
	private File file; 

    public DAOImpCompraFileBin() {
    	try{
    		this.file = new File("datos/compras.dat");
			this.outFile = new FileOutputStream(file);
			this.out = new ObjectOutputStream(outFile);
    		
		}

		 catch (IOException e) {
			System.err.println("ERROR");
			System.err.println("An IOException was caught :" + e.getMessage());
		}     
	}

	public void grabar(Compra a){
		try {
			out.writeObject(a);
			
			
		}	    
		
		catch (IOException e) {
			System.err.println("ERROR");
			System.err.println("An IOException was caught :" + e.getMessage());
		} 
		
	}
}


