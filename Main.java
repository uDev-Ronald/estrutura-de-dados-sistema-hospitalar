import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArvorePacientes arvore = new ArvorePacientes();
    static FilaEmergencia fila = new FilaEmergencia();

    public static void main(String[] args) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println();
            System.out.println("=== HOSPITAL: TRIAGEM ===");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Buscar paciente");
            System.out.println("3 - Remover paciente do cadastro");
            System.out.println("4 - Mostrar pacientes (3 percursos)");
            System.out.println("5 - Colocar paciente na fila");
            System.out.println("6 - Atender proximo da fila");
            System.out.println("7 - Listar fila de espera");
            System.out.println("8 - Ver historico de consultas");
            System.out.println("9 - Remover consulta do historico");
            System.out.println("0 - Sair");
            opcao = lerNumero("Escolha: ");

            if (opcao == 1) {
                cadastrarPaciente();
            } else if (opcao == 2) {
                buscarPaciente();
            } else if (opcao == 3) {
                removerPaciente();
            } else if (opcao == 4) {
                mostrarPercursos();
            } else if (opcao == 5) {
                colocarNaFila();
            } else if (opcao == 6) {
                atenderProximo();
            } else if (opcao == 7) {
                fila.listar();
            } else if (opcao == 8) {
                verHistorico();
            } else if (opcao == 9) {
                removerConsulta();
            } else if (opcao != 0) {
                System.out.println("Opcao invalida.");
            }
        }
        System.out.println("Sistema encerrado.");
    }

    static void cadastrarPaciente() {
        int prontuario = lerNumero("Prontuario: ");
        String nome = lerTexto("Nome: ");

        if (arvore.buscarPaciente(prontuario) != null) {
            System.out.println("Ja existe paciente com esse prontuario.");
        } else {
            arvore.inserirPaciente(new Paciente(prontuario, nome));
            System.out.println("Paciente cadastrado.");
        }
    }

    static void buscarPaciente() {
        Paciente paciente = arvore.buscarPaciente(lerNumero("Prontuario: "));

        if (paciente == null) {
            System.out.println("Paciente nao encontrado.");
        } else {
            System.out.println(paciente);
        }
    }

    static void removerPaciente() {
        int prontuario = lerNumero("Prontuario: ");

        if (arvore.buscarPaciente(prontuario) == null) {
            System.out.println("Paciente nao encontrado.");
        } else if (fila.buscar(prontuario) != null) {
            System.out.println("Paciente esta na fila. Atenda antes de remover.");
        } else {
            arvore.removerPaciente(prontuario);
            System.out.println("Paciente removido.");
        }
    }

    static void mostrarPercursos() {
        System.out.println("--- Em-ordem ---");
        arvore.emOrdem(arvore.getRaiz());
        System.out.println("--- Pre-ordem ---");
        arvore.preOrdem(arvore.getRaiz());
        System.out.println("--- Pos-ordem ---");
        arvore.posOrdem(arvore.getRaiz());
    }

    static void colocarNaFila() {
        int prontuario = lerNumero("Prontuario: ");
        Paciente paciente = arvore.buscarPaciente(prontuario);

        if (paciente == null) {
            System.out.println("Paciente nao cadastrado.");
        } else if (fila.buscar(prontuario) != null) {
            System.out.println("Paciente ja esta na fila.");
        } else {
            fila.enfileirar(paciente);
            System.out.println("Paciente colocado na fila.");
        }
    }

    static void atenderProximo() {
        Paciente paciente = fila.desenfileirar();

        if (paciente == null) {
            System.out.println("Fila vazia.");
            return;
        }

        String data = lerTexto("Data da consulta: ");
        String descricao = lerTexto("Descricao: ");
        paciente.getHistorico().adicionar(new Consulta(data, descricao));
        System.out.println("Atendido: " + paciente);
    }

    static void verHistorico() {
        Paciente paciente = arvore.buscarPaciente(lerNumero("Prontuario: "));

        if (paciente == null) {
            System.out.println("Paciente nao encontrado.");
        } else {
            System.out.println("Historico de " + paciente);
            paciente.getHistorico().listar();
        }
    }

    static void removerConsulta() {
        Paciente paciente = arvore.buscarPaciente(lerNumero("Prontuario: "));

        if (paciente == null) {
            System.out.println("Paciente nao encontrado.");
        } else if (paciente.getHistorico().remover(lerTexto("Data da consulta: "))) {
            System.out.println("Consulta removida.");
        } else {
            System.out.println("Consulta nao encontrada.");
        }
    }

    static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine();
    }

    static int lerNumero(String mensagem) {
        System.out.print(mensagem);
        return Integer.parseInt(sc.nextLine().trim());
    }
}
