
import java.util.Map;
import java.util.HashMap;

/**
 * Representa o sistema MrBet para gerenciamento de times, apostas e campeonatos.
 * @author Joeverton Bento de sousa - 121211066
 */
public class MrBet {
    private Map<String, Time> times;
    private Map<String, Campeonato> campeonatos;
    /**
     * Cria uma nova instância do sistema MrBet.
     */
    public MrBet() {
        this.times = new HashMap<>();
        this.campeonatos = new HashMap<>();
    }
     /**
     * Adiciona um novo time ao sistema.
     *
     * @param codigo   O código do time.
     * @param nome     O nome do time.
     * @param mascote  O mascote do time.
     * @return True se o time foi adicionado com sucesso, False caso contrário.
     */

    public boolean adicionarTime(String codigo, String nome, String mascote) {
        if (times.containsKey(codigo)) {
            return false;
        } else {
            Time time = new Time(codigo, nome, mascote);
            times.put(codigo, time);
            return true;
        }
    }
    /**
     * Recupera um time pelo seu código.
     *
     * @param codigo O código do time a ser recuperado.
     * @return O time correspondente ao código, ou null se não for encontrado.
     */
    public Time recuperarTime(String codigo) {
        return times.get(codigo);
    }
      /**
     * Adiciona um novo campeonato ao sistema.
     *
     * @param nome          O nome do campeonato.
     * @param participantes O número de participantes no campeonato.
     * @return True se o campeonato foi adicionado com sucesso, False caso contrário.
     */
    public boolean adicionarCampeonato(String nome, int participantes) {
        String nomeLowercase = nome.toLowerCase();

        if (campeonatos.containsKey(nomeLowercase)) {
            return false;
        }

        Campeonato campeonato = new Campeonato(nome, participantes);
        campeonatos.put(nomeLowercase, campeonato);
        return true;
    }
      /**
     * Adiciona um time a um campeonato.
     *
     * @param codigoTime       O código do time a ser adicionado.
     * @param nomeCampeonato   O nome do campeonato em que o time será adicionado.
     * @return Uma mensagem indicando o resultado da operação.
     */
    public String addTimeInCampeonato(String codigoTime, String nomeCampeonato) {
        Time time = times.get(codigoTime);
        if (time == null) {
            return "TIME NÃO EXISTE!";
        }
    
        Campeonato campeonato = campeonatos.get(nomeCampeonato.toLowerCase());
        if (campeonato == null) {
            return "CAMPEONATO NÃO EXISTE!";
        }
    
        if (campeonato.getTimes().size() >= campeonato.getParticipantes()) {
            return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
        }
    
        campeonato.addTime(time);
        return "TIME INCLUÍDO NO CAMPEONATO!";
    }
    /**
 * Verifica se um time está participando de um campeonato.
 *
 * @param codigoTime       O código do time a ser verificado.
 * @param nomeCampeonato   O nome do campeonato a ser verificado.
 * @return True se o time está participando do campeonato, False caso contrário.
 */
    public boolean verificarTimeEmCampeonato(String codigoTime, String nomeCampeonato) {
        Time time = times.get(codigoTime);
        if (time == null) {
            System.out.println("O TIME NÃO EXISTE!");
            return false; // Time não existe
        }
        
        Campeonato campeonato = campeonatos.get(nomeCampeonato.toLowerCase());
        if (campeonato == null) {
            System.out.println("O CAMPEONATO NÃO EXISTE!");
            return false; // Campeonato não existe
        }
        
        if (campeonato.getTimes().contains(time)) {
            System.out.println("O TIME ESTÁ NO CAMPEONATO!");
            return true;
        } else {
            System.out.println("O TIME NÃO ESTÁ NO CAMPEONATO!");
            return false;
        }
    }
    /**
 * Exibe os campeonatos em que um time está participando.
 *
 * @param codigoTime O código do time a ser verificado.
 */
    public void exibirCampeonatosDoTime(String codigoTime) {
        Time time = times.get(codigoTime);
        if (time == null) {
            System.out.println("TIME NÃO EXISTE!");
            return;
        }
        
        System.out.println("\nCampeonatos do " + time.getNome() + ":");
        for (Campeonato campeonato : campeonatos.values()) {
            if (campeonato.getTimes().contains(time)) {
                System.out.println("* " + campeonato.getNome() + " - " + campeonato.getTimes().size() + "/" + campeonato.getParticipantes());
            }
        }
    }
    /**
 * Registra uma aposta para um determinado time em um campeonato.
 *
 * @param codigoTime       O código do time para a aposta.
 * @param nomeCampeonato   O nome do campeonato para a aposta.
 * @param colocacao        A colocação prevista na aposta.
 * @param valorAposta      O valor da aposta.
 * @return Uma mensagem indicando o resultado da operação.
 */
    public String registrarAposta(String codigoTime, String nomeCampeonato, int colocacao, double valorAposta) {
        Time time = times.get(codigoTime);
        if (time == null) {
            return "TIME NÃO EXISTE!";
        }
        
        Campeonato campeonato = campeonatos.get(nomeCampeonato.toLowerCase());
        if (campeonato == null) {
            return "CAMPEONATO NÃO EXISTE!";
        }
        
        if (colocacao > campeonato.getParticipantes()) {
            return "Colocação excede número de participantes do campeonato!";
        }
        
        Aposta aposta = new Aposta(time, campeonato, colocacao, valorAposta);
        time.addAposta(aposta);
        
        return "APOSTA REGISTRADA!";
    }
/**
 * Exibe todas as apostas registradas.
 */
    public void exibirApostas() {
        System.out.println("Apostas:\n");
    
        int index = 1;
        for (Time time : times.values()) {
            for (Aposta aposta : time.getApostas()) {
                System.out.printf("%d. %s\n\n", index++, aposta.toString());
            }
        }
    }
/**
 * Recupera um campeonato pelo nome.
 *
 * @param nomeCampeonato O nome do campeonato a ser recuperado.
 * @return O objeto Campeonato correspondente ao nome especificado, ou null se não for encontrado.
 */
    public Campeonato recuperarCampeonato(String nomeCampeonato) {
        return campeonatos.get(nomeCampeonato.toLowerCase());
    }
    
}