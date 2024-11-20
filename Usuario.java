import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Classe Usuario
class Usuario {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static int contadorIdUsuario = 1;

    private int idUsuario;
    private String nomeUsuario;
    private String emailUsuario;
    private String senhaUsuario;
    private String cpfUsuario;
    private String telefoneUsuario;
    private Date dataNascUsuario;

    // Construtor privado para controle interno na classe
    Usuario(int idUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario, String cpfUsuario, String telefoneUsuario, Date dataNascUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.cpfUsuario = cpfUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.dataNascUsuario = dataNascUsuario;
    }

    //Cadastrar Usuario
    public static Usuario cadastrarUsuario(String nome, String email, String senha, String cpf, String telefone, Date dataNascimento) {

        Usuario novoUsuario = new Usuario(contadorIdUsuario++, nome, email, senha, cpf, telefone, dataNascimento);
        usuarios.add(novoUsuario);
        System.out.println("Usuário " + nome + " cadastrado com sucesso!");
        return novoUsuario;
    }

    public static void listarUsuarios() {
        System.out.println("Lista de Usuários Cadastrados:");
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.idUsuario + ", Nome: " + usuario.nomeUsuario + ", Email: " + usuario.emailUsuario);
        }
    }

    public static Usuario realizarLogin(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.emailUsuario.equals(email) && usuario.senhaUsuario.equals(senha)) {
                System.out.println("Login realizado com sucesso! Bem-vindo, " + usuario.nomeUsuario);
                return usuario;
            }
        }
        System.out.println("Email ou senha incorretos.");
        return null;
    }

}