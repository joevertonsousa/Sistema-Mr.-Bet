
import java.util.List;
import java.util.ArrayList;

/**
 * A classe Time representa um time de futebol.
 * Cada time possui um código, nome e mascote, além de uma lista de apostas associadas a ele.
 */
public class Time {
    private final String codigo;
    private final String nome;
    private final String mascote;
    private List<Aposta> apostas;


    /**
     * Construtor da classe Time.
     *
     * @param codigo  Código do time.
     * @param nome    Nome do time.
     * @param mascote Mascote do time.
     */
    public Time(String codigo, String nome, String mascote) {
        this.codigo = codigo;
        this.nome = nome;
        this.mascote = mascote;
        this.apostas = new ArrayList<>();
    }

    /**
     * Obtém o código do time.
     *
     * @return O código do time.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtém o nome do time.
     *
     * @return O nome do time.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o mascote do time.
     *
     * @return O mascote do time.
     */
    public String getMascote() {
        return mascote;
    }
    /**
     * Obtém a lista de apostas associadas ao time.
     *
     * @return A lista de apostas do time.
     */
    public List<Aposta> getApostas() {
        return this.apostas;
    }

    /**
     * Adiciona uma aposta à lista de apostas do time.
     *
     * @param aposta A aposta a ser adicionada.
     */
    public void addAposta(Aposta aposta) {
        apostas.add(aposta);
    }
}
