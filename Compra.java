import java.io.Serializable;

public class Compra implements Serializable {
  private Person per;
  private Producto pro;
  private int cant;
  public Compra() {
    // constructor por defecto
    per = new Person();
    pro = new Producto();
    cant = 0;
  }
  public void setPer(String name) {
    per.setName(name);
  }
  public void setAp(String nombre, String marca, Double precio) {
    pro.setNombre(nombre);
    pro.setMarca(marca);
    pro.setPrecio(precio);
  }
  public void setCant(int cant) {
    this.cant = cant;
  }
  public Person getPer() {
    return per;
  }
  public Producto getPro() {
    return pro;
  }
  public int getCant() {
    return cant;
  }
  @Override
  public String toString() {
    String all = per.getName() + " * " + pro.getNombre() + " * " + pro.getMarca() + " * " + cant + " * " + pro.getPrecio();
    return all;
 }
}
