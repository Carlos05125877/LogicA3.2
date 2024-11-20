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

                    // Cadastro do usuário
                    Usuario.cadastrarUsuario(nome, email, senha, cpf, telefone, dataNascimento);
                    Usuario.listarUsuarios(); // Exemplo de como listar usuários

                    opcao = 0;
                    break;
                case 2:
                    System.out.println("\n--- Login ---");
                    System.out.print("Digite o email: ");
                    String loginEmail = sc.nextLine();
                    System.out.print("Digite a senha: ");
                    String loginSenha = sc.nextLine();

                    Usuario usuarioLogado = Usuario.realizarLogin(loginEmail, loginSenha);

                    // Se o login foi bem-sucedido, mostrar opções para realizar reserva
                    if (usuarioLogado != null) {
                        System.out.println("Login realizado com sucesso!");

                        int escolha = 0;
                        do {
                            System.out.println("Escolha uma opção:\n" +
                                    "1. Realizar uma reserva\n" +
                                    "2. Visualizar histórico de reservas\n" +
                                    "3. Sair");
                            escolha = sc.nextInt();
                            sc.skip("[\r\n]");

                            switch (escolha) {
                                case 1:
                                    // Realizar a reserva
                                    System.out.println("Escolha um voo disponível:");
                                    System.out.println("1. Voo São Paulo - Rio de Janeiro");
                                    int vooEscolhido = sc.nextInt();
                                    if (vooEscolhido == 1) {
                                        // Seleção de assento
                                        System.out.println("Escolha um assento disponível:");
                                        System.out.println("1. Assento 1A\n2. Assento 1B");
                                        int assentoEscolhido = sc.nextInt();
                                        Assento assentoSelecionado = (assentoEscolhido == 1) ? assento1 : assento2;

                                        // Criar um pagamento e confirmar a reserva
                                        Pagamento pagamento = new Pagamento(1, "Cartão de Crédito", new Date(), 500.00f, "Pendente");
                                        Reserva reserva = new Reserva(new Date(), usuarioLogado, voo1, pagamento, assentoSelecionado);
                                        reserva.confirmarReserva();
                                        System.out.println("Reserva confirmada! Status da reserva: " + reserva.getStatusReserva());

                                        // Processar pagamento
                                        if (pagamento.processarPagamento()) {
                                            System.out.println("Pagamento processado com sucesso.");
                                        }

                                        // Emitir o bilhete
                                        Bilhete bilhete = new Bilhete(1, reserva);
                                        bilhete.emitirBilhete();
                                    }
                                    break;
                                case 2:
                                    // Histórico de reservas
                                    System.out.println("Histórico de reservas para o usuário: " + usuarioLogado);
                                    // Reservas realizadas
                                    break;
                                case 3:
                                    System.out.println("Saindo...");
                                    break;
                                default:
                                    System.out.println("Opção inválida");
                                    break;
                            }
                        } while (escolha != 3);
                    } else {
                        System.out.println("Login falhou, email ou senha incorretos.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 0);
    }
}
