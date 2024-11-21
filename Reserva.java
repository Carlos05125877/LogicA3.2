import java.time.LocalDateTime;

enum StatusReserva {
    PENDENTE, CONFIRMADA, CANCELADA
}

class Reserva {
    private static int contadorIdReserva = 1;

    private int idReserva;
    private LocalDateTime dataReserva;
    private StatusReserva statusReserva;
    private Usuario usuario;
    private Voo voo;
    private Pagamento pagamento;
    private Assento assento;

    public Reserva(LocalDateTime dataReserva, Usuario usuario, Voo voo, Pagamento pagamento, Assento assento) {
        this.idReserva = contadorIdReserva++;
        this.dataReserva = dataReserva;
        this.statusReserva = StatusReserva.PENDENTE;
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

    @Override
    public String toString() {
        return "Reserva {" +
                "ID=" + idReserva +
                ", Data=" + dataReserva +
                ", Status=" + statusReserva +
                ", Usuário=" + usuario +
                ", Voo=" + voo +
                ", Assento=" + assento +
                ", Pagamento=" + pagamento +
                '}';
    }

    // Getters
    public int getIdReserva() {
        return idReserva;
    }

    public StatusReserva getStatusReserva() {
        return statusReserva;
    }
}