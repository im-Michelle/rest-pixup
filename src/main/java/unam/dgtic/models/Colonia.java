package unam.dgtic.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
public class Colonia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String cp;
    private String nombre;
    @ManyToOne
    @JoinColumn(name="id_municipio")
    private Municipio municipio;
    @JsonIgnore
    @OneToMany(mappedBy="colonia", fetch=FetchType.LAZY)
    private List<Domicilio> domicilios;
    public Colonia() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCp() {
        return this.cp;
    }
    public void setCp(String cp) {
        this.cp = cp;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Municipio getMunicipio() {
        return this.municipio;
    }
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
    public List<Domicilio> getDomicilios() {
        return domicilios;
    }
    public void setDomicilios(List<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }
    @Override
    public String toString() {
        return "Colonia [id=" + id + ", cp=" + cp + ", nombre=" + nombre + "]";
    }
}
