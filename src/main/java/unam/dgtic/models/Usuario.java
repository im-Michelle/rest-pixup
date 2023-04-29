package unam.dgtic.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String email;
    private String nombre;
    private String password;
    @Column(name="primer_apellido")
    private String primerApellido;
    private String rfc;
    @Column(name="segundo_apellido")
    private String segundoApellido;
    @JsonIgnore
    @OneToMany(mappedBy="usuario")
    private List<Domicilio> domicilios;
    @JsonIgnore
    @OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
    private List<Venta> ventas;
    public Usuario() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPrimerApellido() {
        return this.primerApellido;
    }
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    public String getRfc() {
        return this.rfc;
    }
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    public String getSegundoApellido() {
        return this.segundoApellido;
    }
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    public List<Domicilio> getDomicilios() {
        return this.domicilios;
    }
    public void setDomicilios(List<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }
    public Domicilio addDomicilio(Domicilio domicilio) {
        getDomicilios().add(domicilio);
        domicilio.setUsuario(this);
        return domicilio;
    }
    public Domicilio removeDomicilio(Domicilio domicilio) {
        getDomicilios().remove(domicilio);
        domicilio.setUsuario(null);
        return domicilio;
    }

    public List<Venta> getVentas() {
    return this.ventas;
    }
    public void setVentas(List<Venta> ventas) {
    this.ventas = ventas;
    }
    public Venta addVenta(Venta venta) {
    getVentas().add(venta);
    venta.setUsuario(this);
    return venta;
    }
    public Venta removeVenta(Venta venta) {
    getVentas().remove(venta);
    venta.setUsuario(null);
    return venta;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", email=" + email + ", nombre=" + nombre + ", password=" + password
                + ", primerApellido=" + primerApellido + ", rfc=" + rfc + ", segundoApellido=" + segundoApellido
                + "]";
    }
}
