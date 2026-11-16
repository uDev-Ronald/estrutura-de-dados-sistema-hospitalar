public class Paciente {
    private int prontuario;
    private String nome;
    private ListaConsultas historico;

    public Paciente(int prontuario, String nome) {
        this.prontuario = prontuario;
        this.nome = nome;
        this.historico = new ListaConsultas();
    }

    public int getProntuario() {
        return prontuario;
    }

    public ListaConsultas getHistorico() {
        return historico;
    }

    public String toString() {
        return "Prontuario " + prontuario + " | " + nome;
    }
}
