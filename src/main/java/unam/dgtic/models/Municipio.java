package unam.dgtic.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
public class Municipio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @OneToMany(mappedBy="municipio")
    @JsonIgnore
    private List<Colonia> colonias;
    @ManyToOne
    @JoinColumn(name="id_estado")
    private Estado estado;
    public Municipio() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Colonia> getColonias() {
        return this.colonias;
    }
    public void setColonias(List<Colonia> colonias) {
        this.colonias = colonias;
    }
    public Colonia addColonia(Colonia colonia) {
        getColonias().add(colonia);
        colonia.setMunicipio(this);
        return colonia;
    }
    public Colonia removeColonia(Colonia colonia) {
        getColonias().remove(colonia);
        colonia.setMunicipio(null);
        return colonia;
    }
    public Estado getEstado() {
        return this.estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    @Override
    public String toString() {
        return "Municipio [id=" + id + ", nombre=" + nombre + "]";
    }
}