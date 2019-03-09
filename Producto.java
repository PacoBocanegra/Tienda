import java.io.Serializable;

class Producto implements Serializable {
    private String nombre;
    private String marca;
    private Double precio;
    public Producto() {
         precio = 0.0;
         marca = "";
         nombre = "";
    }
    public Producto (String nombre, String marca, Double precio) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;

    }

    public void setNombre(String n) {
      nombre = n;
    }

    public String getNombre() {
      return nombre;
    }

    public void setPrecio(Double p) {
      precio = p;
    }
    public Double getPrecio() {
      return precio;
    }
    public void setMarca(String m) {
      marca = m;
    }
    public String getMarca() {
      return marca;
    }
}
