import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;

public class Voo {
    private int id;
    private String origem;
    private String destino;
    private Date data;
    private Date horario;
    private String companhiaAerea;
    private String numeroVoo;
    private ArrayList<Voo> listaVoo = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Voo() {}

    public Voo(String origem, String destino, Date data, Date horario, String companhiaAerea, String numeroVoo) {
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.horario = horario;
        this.companhiaAerea = companhiaAerea;
        this.numeroVoo = numeroVoo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void CadastrarVoo() {
        // Variaveis
        String origem;
        String destino;
        Date data = null;
        Date horario = null;
        String companhiaAerea;
        String numeroVoo;

        // Metodo
        System.out.println("Digite a origem do voo");
        origem = sc.nextLine();
        System.out.println("Digite o destino do voo");
        destino = sc.nextLine();
        // Converter String em Date
        while (data == null) {
            System.out.println("Digite a data do voo.\nFormato: dd/mm/aaaa");
            String dataString = sc.nextLine();
            DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            formatoData.setLenient(false);
            try {
                data = formatoData.parse(dataString);
            } catch (ParseException e) {
                System.out.println("Erro: Data invalida.\nFormato correto: dd/mm/aaaa");
            }
        }

        while (horario == null) {
            System.out.println("Digite o horario do voo");
            String horarioString = sc.nextLine();
            DateFormat formatoHorario = new SimpleDateFormat("HH:mm");
            formatoHorario.setLenient(false);
            try {
                horario = formatoHorario.parse(horarioString);
            } catch (ParseException e) {
                System.out.println("Erro: Horario invalido\nFormato correto: HH:mm");
            }
        }

        System.out.println("Digite a companhia aerea do voo");
        companhiaAerea = sc.nextLine();
        System.out.println("Digite o número do voo");
        numeroVoo = sc.nextLine();
        Voo novoVoo = new Voo(origem, destino, data, horario, companhiaAerea, numeroVoo);
        listaVoo.add(novoVoo);
        for (int i = 0; i < listaVoo.size(); i++) {
            listaVoo.get(i).setId(i);
        }
    }

    public void listarVoo() {

        if (listaVoo.isEmpty()) {
            System.out.println("Não há voos cadastrados");
        } else {
            while (true) {
                boolean vazio = true;
                System.out.println("1. Pesquisar por id");
                System.out.println("2. Pesquisar por origem");
                System.out.println("3. Pesquisar por destino");
                System.out.println("4. Pesquisar por data");
                System.out.println("5. Pesquisar por horario");
                System.out.println("6. Pesquisar por companhia aerea");
                System.out.println("7. Pesquisar por numero do voo");
                System.out.println("8. Exibir todos os voos");
                System.out.println("9. Voltar");
                int opcao = sc.nextInt();
                sc.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.println("Digite o ID do voo que deseja visualizar");
                        System.out.println(listaVoo.size());
                        int id = sc.nextInt();
                        sc.nextLine();
                        if (id >= listaVoo.size() || id < 0) {
                            System.out.println("Não existe voos cadastrados com esse ID");
                        }
                        else {
                            System.out.println("ID: " + listaVoo.get(id).id);
                            System.out.println("ORIGEM: " + listaVoo.get(id).origem);
                            System.out.println("DESTINO: " + listaVoo.get(id).destino);
                            DateFormat consertandoData = new SimpleDateFormat("dd/MM/yyyy");
                            String dataCorreta;
                            dataCorreta = consertandoData.format(listaVoo.get(id).data);
                            System.out.println("DATA: " + dataCorreta);
                            DateFormat consertandoHorario = new SimpleDateFormat("HH:mm");
                            consertandoHorario.setLenient(false);
                            String horarioCorreto = consertandoHorario.format(listaVoo.get(id).horario);
                            System.out.println("HORARIO: " + horarioCorreto);
                            System.out.println("COMPANHIA AEREA: " + listaVoo.get(id).companhiaAerea);
                            System.out.println("NUMERO DO VOO: " + listaVoo.get(id).numeroVoo);
                        }
                        break;
                    case 2:
                        System.out.println("Digite a origem dos voo que deseja visualizar");
                        String origem = sc.nextLine();
                        for (int i = 0; i < listaVoo.size(); i++) {
                            if (origem.equalsIgnoreCase(listaVoo.get(i).origem)) {
                                vazio = false;
                                System.out.println("ID: " + listaVoo.get(i).id);
                                System.out.println("ORIGEM: " + listaVoo.get(i).origem);
                                System.out.println("DESTINO: " + listaVoo.get(i).destino);
                                DateFormat consertandoData = new SimpleDateFormat("dd/MM/yyyy");
                                String dataCorreta;
                                dataCorreta = consertandoData.format(listaVoo.get(i).data);
                                System.out.println("DATA: " + dataCorreta);
                                DateFormat consertandoHorario = new SimpleDateFormat("HH:mm");
                                consertandoHorario.setLenient(false);
                                String horarioCorreto = consertandoHorario.format(listaVoo.get(i).horario);
                                System.out.println("HORARIO: " + horarioCorreto);
                                System.out.println("COMPANHIA AEREA: " + listaVoo.get(i).companhiaAerea);
                                System.out.println("NUMERO DO VOO: " + listaVoo.get(i).numeroVoo);
                            }
                        }
                        if (vazio){
                            System.out.println("Não existem voos com essa origem");
                        }
                        break;
                    case 3:
                        System.out.println("Digite o destino dos voo que deseja visualizar");
                        String destino = sc.nextLine();
                        for (int i = 0; i < listaVoo.size(); i++) {
                            if (destino.equalsIgnoreCase(listaVoo.get(i).destino)) {
                                vazio = false;
                                System.out.println("ID: " + listaVoo.get(i).id);
                                System.out.println("ORIGEM: " + listaVoo.get(i).origem);
                                System.out.println("DESTINO: " + listaVoo.get(i).destino);
                                DateFormat consertandoData = new SimpleDateFormat("dd/MM/yyyy");
                                String dataCorreta;
                                dataCorreta = consertandoData.format(listaVoo.get(i).data);
                                System.out.println("DATA: " + dataCorreta);
                                DateFormat consertandoHorario = new SimpleDateFormat("HH:mm");
                                consertandoHorario.setLenient(false);
                                String horarioCorreto = consertandoHorario.format(listaVoo.get(i).horario);
                                System.out.println("HORARIO: " + horarioCorreto);
                                System.out.println("COMPANHIA AEREA: " + listaVoo.get(i).companhiaAerea);
                                System.out.println("NUMERO DO VOO: " + listaVoo.get(i).numeroVoo);
                            }
                        }
                        if (vazio){
                            System.out.println("Não exitem voos com esse destino");
                        }
                        break;
                    case 4:
                        Date data = null;
                        while (data == null) {
                            System.out.println("Digite a data dos voos que deseja visualizar\nFormato: dd/mm/aaaa");
                            String dataString = sc.nextLine();
                            DateFormat formatodata = new SimpleDateFormat("dd/MM/yyyy");
                            formatodata.setLenient(false);
                            try {
                                data = formatodata.parse(dataString);
                            } catch (ParseException e) {
                                System.out.println("Erro: Data invalida\nFormato correto: dd/mm/aaaa");
                            }
                        }
                        for (int i = 0; i < listaVoo.size(); i++) {
                            if (data.equals(listaVoo.get(i).data)) {
                                vazio = false;
                                System.out.println("ID: " + listaVoo.get(i).id);
                                System.out.println("ORIGEM: " + listaVoo.get(i).origem);
                                System.out.println("DESTINO: " + listaVoo.get(i).destino);
                                DateFormat consertandoData = new SimpleDateFormat("dd/MM/yyyy");
                                String dataCorreta;
                                dataCorreta = consertandoData.format(listaVoo.get(i).data);
                                System.out.println("DATA: " + dataCorreta);
                                DateFormat consertandoHorario = new SimpleDateFormat("HH:mm");
                                consertandoHorario.setLenient(false);
                                String horarioCorreto = consertandoHorario.format(listaVoo.get(i).horario);
                                System.out.println("HORARIO: " + horarioCorreto);
                                System.out.println("COMPANHIA AEREA: " + listaVoo.get(i).companhiaAerea);
                                System.out.println("NUMERO DO VOO: " + listaVoo.get(i).numeroVoo);
                            }
                        }
                        if (vazio){
                            System.out.println("Não existem voos com essa data");
                        }
                        break;
                    case 5:
                        Date horario = null;
                        while (horario == null) {
                            System.out.println("Digite o horario dos voos que deseja visualizar");
                            String horarioStirng = sc.nextLine();
                            DateFormat formatoHorario = new SimpleDateFormat("HH:mm");
                            formatoHorario.setLenient(false);
                            try {
                                horario = formatoHorario.parse(horarioStirng);
                            } catch (ParseException e) {
                                System.out.println("Erro: Horario invalido. Formato: HH:mm");
                            }
                        }
                        for (int i = 0; i < listaVoo.size(); i++) {
                            if (horario.equals(listaVoo.get(i).horario)) {
                                vazio = false;
                                System.out.println("ID: " + listaVoo.get(i).id);
                                System.out.println("ORIGEM: " + listaVoo.get(i).origem);
                                System.out.println("DESTINO: " + listaVoo.get(i).destino);
                                DateFormat consertandoData = new SimpleDateFormat("dd/MM/yyyy");
                                String dataCorreta;
                                dataCorreta = consertandoData.format(listaVoo.get(i).data);
                                System.out.println("DATA: " + dataCorreta);
                                DateFormat consertandoHorario = new SimpleDateFormat("HH:mm");
                                consertandoHorario.setLenient(false);
                                String horarioCorreto = consertandoHorario.format(listaVoo.get(i).horario);
                                System.out.println("HORARIO: " + horarioCorreto);
                                System.out.println("COMPANHIA AEREA: " + listaVoo.get(i).companhiaAerea);
                                System.out.println("NUMERO DO VOO: " + listaVoo.get(i).numeroVoo);
                            }
                        }
                        if (vazio){
                            System.out.println("Não existem voos com esse horario");
                        }
                        break;
                    case 6:
                        System.out.println("Digite o nome da companhia aerea dos voos que deseja visualizar");
                        String companhiaAerea = sc.nextLine();
                        for (int i = 0; i < listaVoo.size(); i++) {
                            if (companhiaAerea.equals(listaVoo.get(i).companhiaAerea)) {
                                vazio = false;
                                System.out.println("ID: " + listaVoo.get(i).id);
                                System.out.println("ORIGEM: " + listaVoo.get(i).origem);
                                System.out.println("DESTINO: " + listaVoo.get(i).destino);
                                DateFormat consertandoData = new SimpleDateFormat("dd/MM/yyyy");
                                String dataCorreta;
                                dataCorreta = consertandoData.format(listaVoo.get(i).data);
                                System.out.println("DATA: " + dataCorreta);
                                DateFormat consertandoHorario = new SimpleDateFormat("HH:mm");
                                consertandoHorario.setLenient(false);
                                String horarioCorreto = consertandoHorario.format(listaVoo.get(i).horario);
                                System.out.println("HORARIO: " + horarioCorreto);
                                System.out.println("COMPANHIA AEREA: " + listaVoo.get(i).companhiaAerea);
                                System.out.println("NUMERO DO VOO: " + listaVoo.get(i).numeroVoo);
                            }
                        }
                        if (vazio){
                            System.out.println("Não existem voos dessa companhia aerea");
                        }
                        break;
                    case 7:
                        System.out.println("Digite o número do voo que deseja visualizar");
                        String numeroVoo = sc.nextLine();
                        for (int i = 0; i < listaVoo.size(); i++) {
                            if (numeroVoo.equals(listaVoo.get(i).numeroVoo)) {
                                vazio = false;
                                System.out.println("ID: " + listaVoo.get(i).id);
                                System.out.println("ORIGEM: " + listaVoo.get(i).origem);
                                System.out.println("DESTINO: " + listaVoo.get(i).destino);
                                DateFormat consertandoData = new SimpleDateFormat("dd/MM/yyyy");
                                String dataCorreta;
                                dataCorreta = consertandoData.format(listaVoo.get(i).data);
                                System.out.println("DATA: " + dataCorreta);
                                DateFormat consertandoHorario = new SimpleDateFormat("HH:mm");
                                consertandoHorario.setLenient(false);
                                String horarioCorreto = consertandoHorario.format(listaVoo.get(i).horario);
                                System.out.println("HORARIO: " + horarioCorreto);
                                System.out.println("COMPANHIA AEREA: " + listaVoo.get(i).companhiaAerea);
                                System.out.println("NUMERO DO VOO: " + listaVoo.get(i).numeroVoo);
                            }
                        }
                        if (vazio){
                            System.out.println("Não existem voos com esse número");
                        }
                        break;
                    case 8:
                        for (int i = 0; i < listaVoo.size(); i++) {
                            System.out.println("ID: " + listaVoo.get(i).id);
                            System.out.println("ORIGEM: " + listaVoo.get(i).origem);
                            System.out.println("DESTINO: " + listaVoo.get(i).destino);
                            DateFormat consertandoData = new SimpleDateFormat("dd/MM/yyyy");
                            String dataCorreta;
                            dataCorreta = consertandoData.format(listaVoo.get(i).data);
                            System.out.println("DATA: " + dataCorreta);
                            DateFormat consertandoHorario = new SimpleDateFormat("HH:mm");
                            consertandoHorario.setLenient(false);
                            String horarioCorreto = consertandoHorario.format(listaVoo.get(i).horario);
                            System.out.println("HORARIO: " + horarioCorreto);
                            System.out.println("COMPANHIA AEREA: " + listaVoo.get(i).companhiaAerea);
                            System.out.println("NUMERO DO VOO: " + listaVoo.get(i).numeroVoo);
                        }
                        break;
                    case 9:
                        return;

                }
            }
        }
    }
}