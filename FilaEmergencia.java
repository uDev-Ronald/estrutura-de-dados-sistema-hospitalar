public class FilaEmergencia {
    private NoFila inicio;
    private NoFila fim;

    public boolean estaVazia() {
        return inicio == null;
    }

    public void enfileirar(Paciente paciente) {
        NoFila novo = new NoFila(paciente);

        if (inicio == null) {
            inicio = novo;
        } else {
            fim.proximo = novo;
        }
        fim = novo;
    }

    public Paciente desenfileirar() {
        if (inicio == null) {
            return null;
        }

        Paciente paciente = inicio.paciente;
        inicio = inicio.proximo;

        if (inicio == null) {
            fim = null;
        }
        return paciente;
    }

    public Paciente buscar(int prontuario) {
        NoFila atual = inicio;

        while (atual != null) {
            if (atual.paciente.getProntuario() == prontuario) {
                return atual.paciente;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public void listar() {
        if (inicio == null) {
            System.out.println("Fila vazia.");
        }

        int posicao = 1;
        NoFila atual = inicio;
        while (atual != null) {
            System.out.println(posicao + " - " + atual.paciente);
            posicao++;
            atual = atual.proximo;
        }
    }
}
