package unam.dgtic.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name="tipo_domicilio")
public class TipoDomicilio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    @JsonIgnore
    @OneToMany(mappedBy="tipoDomicilio", fetch=FetchType.LAZY)
    private List<Domicilio> domicilios;
    public TipoDomicilio() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public List<Domicilio> getDomicilios() {
        return this.domicilios;
    }
    public void setDomicilios(List<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }
    public Domicilio addDomicilio(Domicilio domicilio) {
        getDomicilios().add(domicilio);
        domicilio.setTipoDomicilio(this);
        return domicilio;
    }
    public Domicilio removeDomicilio(Domicilio domicilio) {
        getDomicilios().remove(domicilio);
        domicilio.setTipoDomicilio(null);
        return domicilio;
    }
    @Override
    public String toString() {
        return "TipoDomicilio [id=" + id + ", descripcion=" + descripcion + "]";
    }
}