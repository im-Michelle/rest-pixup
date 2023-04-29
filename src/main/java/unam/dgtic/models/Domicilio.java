package unam.dgtic.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import java.io.Serializable;
@Entity
public class Domicilio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String calle;
    @Column(name="num_exterior")
    private String numExterior;
    @Column(name="num_interior")
    private String numInterior;
    @ManyToOne
    @JoinColumn(name="id_colonia")
    private Colonia colonia;
    @ManyToOne
    @JoinColumn(name="id_tipo_domicilio")
    private TipoDomicilio tipoDomicilio;
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
    public Domicilio() {
        this.usuario=new Usuario();
        this.tipoDomicilio=new TipoDomicilio();
        this.colonia=new Colonia();
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCalle() {
        return this.calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public String getNumExterior() {
        return this.numExterior;
    }
    public void setNumExterior(String numExterior) {
        this.numExterior = numExterior;
    }
    public String getNumInterior() {
        return this.numInterior;
    }
    public void setNumInterior(String numInterior) {
        this.numInterior = numInterior;
    }
    public Colonia getColonia() {
        return this.colonia;
    }
    public void setColonia(Colonia colonia) {
        this.colonia = colonia;
    }
    public TipoDomicilio getTipoDomicilio() {
        return this.tipoDomicilio;
    }
    public void setTipoDomicilio(TipoDomicilio tipoDomicilio) {
        this.tipoDomicilio = tipoDomicilio;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    @Override
    public String toString() {
        return "Domicilio [id=" + id + ", calle=" + calle + ", numExterior=" + numExterior + ", numInterior="
                + numInterior + "]";
    }
}