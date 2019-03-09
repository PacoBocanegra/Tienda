import java.util.List;
import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.IOException;

// El nombre lo indica, tiene como objetivo leer los objetos grabados
// en 'aulas.dat', y mostrarlos en la salida estándar.
//
//  También aquí, podemos crear la lista, es decir,
//
//    aulas.dat -----> lista objetos Aula ----> recorrer lista visualizando elementos.

public class CompraReadSerial{
        public static void main(String[] args) throws Exception {
        	Compra a = null;
		    try {
		      FileInputStream inFile = new FileInputStream("datos/compras.dat");
		      ObjectInputStream in = new ObjectInputStream(inFile);
		      while (inFile.available()>0) {
			      a = (Compra)in.readObject();
			      System.out.println(a.toString());
			  }
		    }
		    catch(IOException e)
		    {
		      System.err.println("ERROR");
		    }
		    catch(ClassNotFoundException e)
		    {
		      System.err.println("ERROR");
		    }
		    
        }
} 

