
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
        this.idReserva = idReserva;
        this.dataReserva = dataReserva;
        this.statusReserva = statusReserva;
        this.usuario = usuario;
        this.voo = voo;
        this.pagamento = pagamento;
        this.assento = assento;
    }

    public void confirmarReserva() {
        this.statusReserva = "Confirmada";
    }

    public void cancelarReserva() {
        this.statusReserva = "Cancelada";
    }

    public void atualizarStatus(String status) {
        this.statusReserva = status;
    }

    public String getStatusReserva() {
        return statusReserva;
    }
}
