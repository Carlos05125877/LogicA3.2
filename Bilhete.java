
class Bilhete {
    private int idBilhete;
    private Reserva reserva;

    public Bilhete(int idBilhete, Reserva reserva) {
        if { reserva == null) {
            throw new IllegalArgumentException("A reserva nao pode ser nula.")
        }
        this.idBilhete = idBilhete;
        this.reserva = reserva;

        }

    public void emitirBilhete() {
             if(Reseva.getStatusReserva() != statusReserva.CONFIRMADA) {
                 System.out.print("O bilhete só pode ser emitido a reservas confirmadas, confirme sua reserva e tente novamente.");
                 return;
             }
        }
        System.out.println("Bilhete emitido para a reserva: " + reserva);
    }

    public String consultarBilhete() {
        return "Bilhete {" +
                "idBilhete=" + idBilhete +
                ", Reserva=" + reserva +
                '}';
    }

        public int getIdBilhete() {
            return idBilhete;}

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