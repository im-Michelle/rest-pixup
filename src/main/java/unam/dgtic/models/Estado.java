package unam.dgtic.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
public class Estado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @OneToMany(mappedBy="estado", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Municipio> municipios;
    public Estado() {
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
    public List<Municipio> getMunicipios() {
        return this.municipios;
    }
    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }
    public Municipio addMunicipio(Municipio municipio) {
        getMunicipios().add(municipio);
        municipio.setEstado(this);
        return municipio;
    }
    public Municipio removeMunicipio(Municipio municipio) {
        getMunicipios().remove(municipio);
        municipio.setEstado(null);
        return municipio;
    }
    @Override
    public String toString() {
        return "Estado [id=" + id + ", nombre=" + nombre + "]";
    }
}