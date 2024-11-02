
class Bilhete {
    private int idBilhete;
    private Reserva reserva;

    public Bilhete(int idBilhete, Reserva reserva) {
        this.idBilhete = idBilhete;
        this.reserva = reserva;
    }

    public void emitirBilhete() {
        System.out.println("Bilhete emitido para a reserva: " + reserva);
    }

    public String consultarBilhete() {
        return "Bilhete: " + idBilhete + ", Reserva: " + reserva;
    }
}
