class Bilhete {
    private int idBilhete;
    private Reserva reserva;

    public Bilhete(int idBilhete, Reserva reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("A reserva não pode ser nula.");
        }
        this.idBilhete = idBilhete;
        this.reserva = reserva;
    }

    public void emitirBilhete() {
        if (reserva.getStatusReserva() != StatusReserva.CONFIRMADA) {
            System.out.println("Erro: O bilhete só pode ser emitido para reservas confirmadas.");
            return;
        }
        System.out.println("Bilhete emitido com sucesso!");
        System.out.println(this);
    }

    public String consultarBilhete() {
        return toString();
    }

    @Override
    public String toString() {
        return "Bilhete {" +
                "idBilhete=" + idBilhete +
                ", Reserva=" + reserva +
                '}';
    }

    // Getters e Setters
    public int getIdBilhete() {
        return idBilhete;
    }

    public void setIdBilhete(int idBilhete) {
        this.idBilhete = idBilhete;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("A reserva não pode ser nula.");
        }
        this.reserva = reserva;
    }
}
