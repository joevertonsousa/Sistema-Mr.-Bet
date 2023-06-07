
import java.util.Set;    
import java.util.HashSet;


/**
 * A classe "Campeonato" representa um campeonato de futebol.
 * Cada campeonato possui um nome, quantidade de participantes e um conjunto de times participantes.
 */
public class Campeonato {
    private String nome; // Nome do campeonato
    private int participantes; // Quantidade de participantes
    private Set<Time> times; // Conjunto de times participantes

    /**
     * Construtor da classe Campeonato.
     *
     * @param nome           O nome do campeonato.
     * @param participantes  A quantidade de participantes do campeonato.
     */
    public Campeonato(String nome, int participantes) {
        this.nome = nome;
        this.participantes = participantes;
        this.times = new HashSet<>();
    }

    /**
     * Obtém o nome do campeonato.
     *
     * @return O nome do campeonato.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém a quantidade de participantes do campeonato.
     *
     * @return A quantidade de participantes do campeonato.
     */
    public int getParticipantes() {
        return participantes;
    }

    /**
     * Adiciona um time ao conjunto de times participantes do campeonato.
     *
     * @param time O time a ser adicionado.
     */
    public void addTime(Time time) {
        times.add(time);
    }

    /**
     * Obtém o conjunto de times participantes do campeonato.
     *
     * @return O conjunto de times participantes do campeonato.
     */
    public Set<Time> getTimes() {
        return times;
    }
}

