
import java.util.Date;

class Pagamento {
    private int idPagamento;
    private String formaPagamento;
    private Date dataPagamento;
    private float valorPagamento;
    private String statusPagamento;

    public Pagamento(int idPagamento, String formaPagamento, Date dataPagamento, float valorPagamento, String statusPagamento) {
        this.idPagamento = idPagamento;
        this.formaPagamento = formaPagamento;
        this.dataPagamento = dataPagamento;
        this.valorPagamento = valorPagamento;
        this.statusPagamento = statusPagamento;
    }

    public boolean processarPagamento() {
        this.statusPagamento = "Processado";
        return true;
    }

    public String verificarStatusPagamento() {
        return statusPagamento;
    }
}
