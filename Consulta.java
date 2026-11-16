public class Consulta {
    private String data;
    private String descricao;

    public Consulta(String data, String descricao) {
        this.data = data;
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public String toString() {
        return data + " - " + descricao;
    }
}
