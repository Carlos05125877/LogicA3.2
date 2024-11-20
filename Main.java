import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws ParseException {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Usuario usuarioLogado = null;

        do {
            System.out.println("Escolha uma opção:\n" +
                    "1. Cadastrar Usuário\n" +
                    "2. Realizar Login\n" +
                    "3. Sair");
            opcao = sc.nextInt();
            sc.skip("[\r\n]"); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    // Cadastro
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

                    Usuario.cadastrarUsuario(nome, email, senha, cpf, telefone, dataNascimento);
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 2:
                    // Login
                    System.out.println("\n--- Login ---");
                    System.out.print("Digite o email: ");
                    String loginEmail = sc.nextLine();
                    System.out.print("Digite a senha: ");
                    String loginSenha = sc.nextLine();

                    usuarioLogado = Usuario.realizarLogin(loginEmail, loginSenha);
                    if (usuarioLogado != null) {
                        System.out.println("Login realizado com sucesso! Bem-vindo, " + usuarioLogado.getNome());
                        int opcaoUsuario;
                        do {
                            System.out.println("\nEscolha uma opção:\n" +
                                    "1. Realizar uma reserva\n" +
                                    "2. Visualizar histórico de reservas\n" +
                                    "3. Emitir um bilhete\n" +
                                    "4. Logout");
                            opcaoUsuario = sc.nextInt();
                            sc.skip("[\r\n]"); // Limpar o buffer

                            switch (opcaoUsuario) {
                                case 1:
                                    // Realizar uma reserva
                                    System.out.print("Digite o número do voo: ");
                                    String numeroVoo = sc.nextLine();

                                    System.out.print("Digite a origem: ");
                                    String origem = sc.nextLine();

                                    System.out.print("Digite o destino: ");
                                    String destino = sc.nextLine();

                                    System.out.print("Digite a data e hora do voo (dd/MM/yyyy HH:mm): ");
                                    String dataHoraVooStr = sc.nextLine();
                                    LocalDateTime dataHoraVoo = LocalDateTime.parse(dataHoraVooStr,
                                            java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

                                    Voo voo = new Voo(numeroVoo, origem, destino, dataHoraVoo);

                                    System.out.print("Digite o número do assento: ");
                                    String numeroAssento = sc.nextLine();
                                    Assento assento = new Assento(numeroAssento);

                                    Pagamento pagamento = new Pagamento(); // Valor fixo para simplificação

                                    Reserva reserva = new Reserva(
                                            1, LocalDateTime.now(), StatusReserva.PENDENTE,
                                            usuarioLogado, voo, pagamento, assento);
                                    reserva.confirmarReserva();
                                    System.out.println("Reserva realizada com sucesso! Status: " + reserva.getStatusReserva());
                                    break;

                                case 2:
                                    // Visualizar histórico de reservas
                                    Usuario.listarReservas(usuarioLogado);
                                    break;

                                case 3:
                                    // Emitir bilhete
                                    System.out.print("Digite o ID da reserva para emitir o bilhete: ");
                                    int idReserva = sc.nextInt();
                                    Reserva reservaBilhete = Usuario.buscarReservaPorId(usuarioLogado, idReserva);
                                    if (reservaBilhete != null && reservaBilhete.getStatusReserva() == StatusReserva.CONFIRMADA) {
                                        Bilhete bilhete = new Bilhete(1, reservaBilhete);
                                        bilhete.emitirBilhete();
                                    } else {
                                        System.out.println("Reserva inválida ou não confirmada.");
                                    }
                                    break;

                                case 4:
                                    // Logout
                                    System.out.println("Logout realizado com sucesso!");
                                    usuarioLogado = null;
                                    break;

                                default:
                                    System.out.println("Opção inválida.");
                                    break;
                            }
                        } while (usuarioLogado != null);
                    } else {
                        System.out.println("Email ou senha inválidos.");
                    }
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 3);

        sc.close();
    }
}
