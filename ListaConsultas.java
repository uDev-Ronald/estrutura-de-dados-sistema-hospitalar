public class ListaConsultas {
    private NoLista primeiro;
    private NoLista ultimo;

    public void adicionar(Consulta consulta) {
        NoLista novo = new NoLista(consulta);

        if (primeiro == null) {
            primeiro = novo;
        } else {
            ultimo.proximo = novo;
        }
        ultimo = novo;
    }

    public Consulta buscar(String data) {
        NoLista atual = primeiro;

        while (atual != null) {
            if (atual.consulta.getData().equals(data)) {
                return atual.consulta;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public boolean remover(String data) {
        NoLista anterior = null;
        NoLista atual = primeiro;

        while (atual != null) {
            if (atual.consulta.getData().equals(data)) {
                if (anterior == null) {
                    primeiro = atual.proximo;
                } else {
                    anterior.proximo = atual.proximo;
                }
                if (atual == ultimo) {
                    ultimo = anterior;
                }
                return true;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        return false;
    }

    public void listar() {
        if (primeiro == null) {
            System.out.println("   Nenhuma consulta registrada.");
        }

        NoLista atual = primeiro;
        while (atual != null) {
            System.out.println("   " + atual.consulta);
            atual = atual.proximo;
        }
    }
}
