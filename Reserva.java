
import java.util.Date;

class Reserva {
    private int idReserva;
    private Date dataReserva;
    private String statusReserva;
    private Usuario usuario;
    private Voo voo;
    private Pagamento pagamento;
    private Assento assento;

    public Reserva(int idReserva, Date dataReserva, String statusReserva, Usuario usuario, Voo voo, Pagamento pagamento, Assento assento) {
        if (usuario == null || voo == null || pagamento == null || assento == null) {
            throw new IllegalArgumentException("Usuario, voo, pagamento e assento não podem ser nulos.");
        }
        this.idReserva = idReserva;
        this.dataReserva = dataReserva;
        this.statusReserva = statusReserva;
        this.usuario = usuario;
        this.voo = voo;
        this.pagamento = pagamento;
        this.assento = assento;
    }

    public void confirmarReserva() {
        this.statusReserva = StatusReserva.CONFIRMADA;
    }

    public void cancelarReserva() {
        this.statusReserva = StatusReserva.CANCELADA;
    }

    public void atualizarStatus(StatusReserva status) {
        this.statusReserva = status;
    }

    public StatusReserva getStatusReserva() {
        return statusReserva;
    }

    public LocalDateTime getDataReserva() {
        return dataReserva;
    }

    public int getIdReserva() {
        return idReserva;
         }
    } @Override
public String toString() {
    return "Reserva { " +
            "idReserva=" + idReserva +
            ", dataReserva=" + dataReserva +
            ", statusReserva=" + statusReserva +
            ", usuario=" + usuario +
            ", voo=" + voo +
            ", pagamento=" + pagamento +
            ", assento=" + assento +
            " }";
}
}

enum StatusReserva {
    CONFIRMADA,
    CANCELADA,
    PENDENTE;
}
