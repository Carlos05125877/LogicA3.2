
class Assento {
    private int idAssento;
    private String numeroAssento;
    private String statusAssento;
    private String classeAssento;

    public Assento(int idAssento, String numeroAssento, String statusAssento, String classeAssento) {
        this.idAssento = idAssento;
        this.numeroAssento = numeroAssento;
        this.statusAssento = statusAssento;
        this.classeAssento = classeAssento;
    }

    public String getStatusAssento() {
        return statusAssento;
    }

    public void reservarAssento() {
        this.statusAssento = "Reservado";
    }

    public void liberarAssento() {
        this.statusAssento = "Disponível";
    }
}
