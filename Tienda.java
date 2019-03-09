import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class Tienda {
    public static void main(String args[]) {
    	//DAOCompra daocompra = new DAOImpCompraRedis();
    	DAOCompra daobin = new DAOImpCompraFileBin();
    	DAOCompra daotxt = new DAOImpCompraFileText();
    	DAOCompra daosql = new DAOImpCompraSQL();
	    List<Compra> lista = new ArrayList<Compra>();
	    String input;
	    String opcion;
	    String opcion2;
	    String lin;
	    String productos = "";
	    Console console = System.console();
	    System.out.println("Bienvenido a Muebles S.A...");
		System.out.println("Lista de productos: (nombre:marca:precio)");
	    try (BufferedReader br = new BufferedReader(new FileReader("listaProductos"))) {
        	while((lin = br.readLine()) != null) {
				String[] line = lin.split(":");
				String part1 = line[0];
				String part2 = line[1];
				String part3 = line[2];
				productos = part1 + ":" + part2 + ":" + part3 + ";" + productos;
				System.out.println(lin);
			}			
        }
        		
        catch (Exception ex)
		{
			ex.printStackTrace();
		}
		System.out.println("\n");
	    System.out.println("Quieres registrar una compra? (s/n)");
	    opcion = console.readLine();
	    while(opcion.contains("s")) {
	        Compra una_compra = new Compra();
	        Person p = new Person();
	        System.out.println("Nombre del cliente: ? ");
	        String cliente = console.readLine();
	        una_compra.setPer(cliente);

	        while (true) {
		        System.out.println("Que producto ha comprado: ? ");
		        String nombre = console.readLine();
		        String[] producto = productos.split(";");
		        for (String pr : producto) {
		        	if (pr.contains(nombre)) {
		        		String[] pro = pr.split(":");
		        		String marca = pro[1];
		        		String precio = pro[2];
				        System.out.println("Cantidad de " + nombre + ": ? ");
				        input = console.readLine();
				        int cant = Integer.parseInt(input);
				        Double c = new Double(cant);
				        Double precio_total = Double.parseDouble(precio) * c;
				        una_compra.setAp(nombre, marca, precio_total);
				        una_compra.setCant(cant);
				        //daocompra.grabar(una_compra);
				        daobin.grabar(una_compra); 
				        daotxt.grabar(una_compra);
				        daosql.grabar(una_compra);
				        lista.add(una_compra);
		        	}
		        }
		        System.out.println("Otro producto para el cliente " + cliente + "? (s/n)");
		        if (console.readLine().equals("n")) { 
		            break;
		        }
		        else {
		        	una_compra = new Compra();
		        	una_compra.setPer(cliente);
		        }
		    }
		    System.out.println("Quieres registrar otra compra? (s/n)");
	    	opcion = console.readLine();
		}

		    System.out.println("Lista de compras:");
		    for(Compra c : lista){
		        System.out.println(c.getPer().getName() + " ha comprado " + c.getCant() + " " + c.getPro().getNombre() + " marca " + c.getPro().getMarca() + " ------ " + c.getPro().getPrecio() + "€");
		    }


	        
	    	    	     
	}
}
