
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        do {
        System.out.println("Escolha uma opção:\n" +
                "1. Cadastrar Usuario\n" +
                "2. Realizar Login\n");
        opcao = sc.nextInt();
        sc.skip("[\r\n]");

            switch (opcao) {
                case 1:
                    // Solicitar dados do usuário
                    System.out.print("Digite o nome: ");
                    String nome = sc.nextLine();


                    System.out.print("Digite o email: ");
                    String email = sc.nextLine();


                    System.out.print("Digite a senha: ");
                    String senha = sc.nextLine();


                    System.out.print("Digite o CPF: ");
                    String cpf = sc.nextLine();


                    System.out.print("Digite o telefone: ");
                    String telefone = sc.nextLine();


                    System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
                    String dataNascimentoStr = sc.nextLine();
                    Date dataNascimento = dateFormat.parse(dataNascimentoStr);


                    // Cadastro do usuário com os dados fornecidos
                    Usuario.cadastrarUsuario(nome, email, senha, cpf, telefone, dataNascimento);
                    Usuario.listarUsuarios();

                    opcao = 0;
                    break;
                case 2:
                    System.out.println("\n--- Login ---");
                    System.out.print("Digite o email: ");
                    String loginEmail = sc.nextLine();
                    System.out.print("Digite a senha: ");
                    String loginSenha = sc.nextLine();

                    Usuario usuarioLogado = Usuario.realizarLogin(loginEmail, loginSenha);

                    // Se o login foi bem-sucedido, executar uma nova função
                    if (usuarioLogado != null) {
                        System.out.println("Escolha uma opção:\n" +
                                            "1. Realizar uma reserva" +
                                            "2. Visualizar histórico de reservas" +
                                            "3. ");
                    }
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao <= 2);


        /*Voo voo = new Voo(1, new Date(), "São Paulo", "Rio de Janeiro",
                "Companhia Aérea XYZ", "10:30");
        Assento assento1 = new Assento(1, "1A", "Disponível",
                "Econômica");
        Assento assento2 = new Assento(2, "1B", "Disponível",
                "Econômica");
        voo.adicionarAssento(assento1);
        voo.adicionarAssento(assento2);

        if (voo.verificarDisponibilidade()) {
            System.out.println("Assentos disponíveis no voo.");
        }

        assento1.reservarAssento();
        Pagamento pagamento = new Pagamento(1, "Cartão de Crédito", new Date(), 500.00f, "Pendente");
        Reserva reserva = new Reserva(1, new Date(), "Pendente", usuario, voo, pagamento, assento1);
        reserva.confirmarReserva();
        System.out.println("Reserva confirmada. Status da reserva: " + reserva.getStatusReserva());

        if (pagamento.processarPagamento()) {
            System.out.println("Pagamento processado. Status do pagamento: " + pagamento.verificarStatusPagamento());
        }

        Bilhete bilhete = new Bilhete(1, reserva);
        bilhete.emitirBilhete();
        System.out.println("Bilhete emitido: " + bilhete.consultarBilhete());*/
    }
}
