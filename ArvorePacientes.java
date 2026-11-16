public class ArvorePacientes {
    private NoArvore raiz;

    public NoArvore getRaiz() {
        return raiz;
    }

    public void inserirPaciente(Paciente paciente) {
        NoArvore novo = new NoArvore(paciente);

        if (raiz == null) {
            raiz = novo;
            return;
        }

        NoArvore atual = raiz;
        NoArvore pai = null;

        while (atual != null) {
            pai = atual;
            if (paciente.getProntuario() < atual.paciente.getProntuario()) {
                atual = atual.esq;
            } else {
                atual = atual.dir;
            }
        }

        if (paciente.getProntuario() < pai.paciente.getProntuario()) {
            pai.esq = novo;
        } else {
            pai.dir = novo;
        }
    }

    public Paciente buscarPaciente(int prontuario) {
        NoArvore atual = raiz;

        while (atual != null) {
            if (prontuario == atual.paciente.getProntuario()) {
                return atual.paciente;
            }
            if (prontuario < atual.paciente.getProntuario()) {
                atual = atual.esq;
            } else {
                atual = atual.dir;
            }
        }
        return null;
    }

    public void removerPaciente(int prontuario) {
        raiz = remover(raiz, prontuario);
    }

    private NoArvore remover(NoArvore atual, int prontuario) {
        if (atual == null) {
            return null;
        }

        if (prontuario < atual.paciente.getProntuario()) {
            atual.esq = remover(atual.esq, prontuario);
        } else if (prontuario > atual.paciente.getProntuario()) {
            atual.dir = remover(atual.dir, prontuario);
        } else {

            if (atual.esq == null && atual.dir == null) {
                return null;
            }

            if (atual.esq == null) {
                return atual.dir;
            }
            if (atual.dir == null) {
                return atual.esq;
            }

            NoArvore maior = atual.esq;
            while (maior.dir != null) {
                maior = maior.dir;
            }
            atual.paciente = maior.paciente;
            atual.esq = remover(atual.esq, maior.paciente.getProntuario());
        }
        return atual;
    }

    public void emOrdem(NoArvore atual) {
        if (atual != null) {
            emOrdem(atual.esq);
            System.out.println(atual.paciente);
            emOrdem(atual.dir);
        }
    }

    public void preOrdem(NoArvore atual) {
        if (atual != null) {
            System.out.println(atual.paciente);
            preOrdem(atual.esq);
            preOrdem(atual.dir);
        }
    }

    public void posOrdem(NoArvore atual) {
        if (atual != null) {
            posOrdem(atual.esq);
            posOrdem(atual.dir);
            System.out.println(atual.paciente);
        }
    }
}
