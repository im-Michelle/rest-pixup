package unam.dgtic.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Venta {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "costo_total")
    private float costoTotal;
    private Date fecha;
    @Column(name = "cantidad_total")
    private int cantidadTotal;
    @Column(name = "estatus_envio")
    private byte estatusEnvio;
    @Column(name = "costo_envio")
    private float costoEnvio;
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy="venta", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Pago> pagos;

    public Venta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public int getEstatusEnvio() {
        return estatusEnvio;
    }

    public void setEstatusEnvio(byte estatusEnvio) {
        this.estatusEnvio = estatusEnvio;
    }

    public float getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(float costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", costoTotal=" + costoTotal +
                ", fecha=" + fecha +
                ", cantidadTotal=" + cantidadTotal +
                ", estatusEnvio=" + estatusEnvio +
                ", costoEnvio=" + costoEnvio +
                '}';
    }
}
