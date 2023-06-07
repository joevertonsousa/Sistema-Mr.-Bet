
/**
 * Representa uma aposta em um campeonato esportivo.
 */
public class Aposta {

    private Time time;

    private Campeonato campeonato;

    private int colocacao;
  
    private double valorAposta;

     /**
     * Cria uma nova instância da classe Aposta.
     *
     * @param time         O time selecionado para a aposta.
     * @param campeonato   O campeonato em que a aposta está sendo feita.
     * @param colocacao    A colocação prevista na aposta.
     * @param valorAposta  O valor apostado.
     * **/

     /**Construtor da Classe Aposta */
    public Aposta(Time time, Campeonato campeonato, int colocacao, double valorAposta) {
        this.time = time;
        this.campeonato = campeonato;
        this.colocacao = colocacao;
        this.valorAposta = valorAposta;
    }
 /**
     * Obtém o time selecionado para a aposta.
     *
     * @return O time selecionado.
     */
    public Time getTime() {
        return time;
    }
/**
     * Define o time selecionado para a aposta.
     *
     * @param time O time selecionado.
     */

    public void setTime(Time time) {
        this.time = time;
    }
/**
     * Obtém o campeonato em que a aposta está sendo feita.
     *
     * @return O campeonato.
     */
    public Campeonato getCampeonato() {
        return campeonato;
    }
  /**
     * Define o campeonato em que a aposta está sendo feita.
     *
     * @param campeonato O campeonato.
     */
    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }
 /**
     * Obtém a colocação prevista na aposta.
     *
     * @return A colocação prevista.
     */
    public int getColocacao() {
        return colocacao;
    }
 /**
     * Define a colocação prevista na aposta.
     *
     * @param colocacao A colocação prevista.
     */
    public void setColocacao(int colocacao) {
        this.colocacao = colocacao;
    }
 /**
     * Obtém o valor apostado.
     *
     * @return O valor apostado.
     */
    public double getValorAposta() {
        return valorAposta;
    }

    /**
     * Define o valor apostado.
     *
     * @param valorAposta O valor apostado.
     */
    public void setValorAposta(double valorAposta) {
        this.valorAposta = valorAposta;
    }
    /**
     * Retorna uma representação em formato de string da instância da classe Aposta.
     *
     * @return A representação em formato de string.
     */
    

    @Override
    public String toString() {
    return String.format("[%s] %s / %s\n%s\n%d/%d\nR$ %.2f",
            time.getCodigo(), time.getNome(), time.getMascote(),
            campeonato.getNome(), colocacao, campeonato.getParticipantes(), valorAposta);
}
}