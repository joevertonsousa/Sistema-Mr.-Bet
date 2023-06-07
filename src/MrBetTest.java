

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collections;

class MrBetTest {
    private MrBet mrBet;
    
    @BeforeEach
    void setUp() {
        mrBet = new MrBet();
        
        // Adicionar os times no sistema
        mrBet.adicionarTime("250_PB", "Nacional de Patos", "Canário");
        mrBet.adicionarTime("252_PB", "Sport Lagoa Seca", "Carneiro");
        mrBet.adicionarTime("002_RJ", "Clube de Regatas do Flamengo", "Urubu");
        mrBet.adicionarTime("105_PB", "Sociedade Recreativa de Monteiro (SOCREMO)", "Gavião");
    }

    @Test
    void adicionarTime() {
        // Testar adicionar um time que já existe
        boolean result = mrBet.adicionarTime("250_PB", "Nacional de Patos", "Canário");
        assertFalse(result);

        // Testar adicionar um time novo
        result = mrBet.adicionarTime("999_XZ", "Novo Time", "Novo Mascote");
        assertTrue(result);
    }

    @Test
    void adicionarCampeonato() {
        // Testar adicionar um campeonato novo
        boolean result = mrBet.adicionarCampeonato("Brasileirão série A 2023", 4);
        assertTrue(result);

        // Testar adicionar um campeonato que já existe
        result = mrBet.adicionarCampeonato("Brasileirão série A 2023", 4);
        assertFalse(result);
    }

    @Test
    void verificarTimeEmCampeonato() {
        // Adicionar um campeonato e um time
        mrBet.adicionarCampeonato("Brasileirão série A 2023", 4);
        mrBet.addTimeInCampeonato("250_PB", "Brasileirão série A 2023");

        // Verificar se o time está no campeonato
        boolean result = mrBet.verificarTimeEmCampeonato("250_PB", "Brasileirão série A 2023");
        assertTrue(result);

        // Verificar se um time que não está no campeonato
        result = mrBet.verificarTimeEmCampeonato("252_PB", "Brasileirão série A 2023");
        assertFalse(result);
    }
    
    @Test
    public void incluirTimeNoCampeonatoQueJaFoiIncluido() {
        MrBet mrBet = new MrBet();
        
        // Criação do campeonato
        String nomeCampeonato = "Brasileirão série A 2023";
        int numParticipantes = 10;
        assertTrue(mrBet.adicionarCampeonato(nomeCampeonato, numParticipantes));
        
        // Criação dos times
        String codigoTime1 = "250_PB";
        String nomeTime1 = "Time1";
        String mascoteTime1 = "Mascote1";
        assertTrue(mrBet.adicionarTime(codigoTime1, nomeTime1, mascoteTime1));
        
        String codigoTime2 = "252_PB";
        String nomeTime2 = "Time2";
        String mascoteTime2 = "Mascote2";
        assertTrue(mrBet.adicionarTime(codigoTime2, nomeTime2, mascoteTime2));
        
        // Adicionando os times ao campeonato
        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBet.addTimeInCampeonato(codigoTime1, nomeCampeonato));
        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBet.addTimeInCampeonato(codigoTime2, nomeCampeonato));
        
        // Tentando adicionar o time 2 novamente
        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBet.addTimeInCampeonato(codigoTime2, nomeCampeonato));
        
        // Verificando se o time 2 foi adicionado apenas uma vez
        Campeonato campeonato = mrBet.recuperarCampeonato(nomeCampeonato);
        int time2Frequency = Collections.frequency(campeonato.getTimes(), mrBet.recuperarTime(codigoTime2));
        assertEquals(1, time2Frequency);
    }
    
    @Test
    public void deveRetornarErroQuandoIncluirTimeNaoCadastradoEmUmCampeonato() {
        MrBet mrBet = new MrBet();
        mrBet.adicionarCampeonato("Brasileirão série A 2023", 20);

        String result = mrBet.addTimeInCampeonato("005_PB", "Brasileirão série A 2023");

        assertEquals("TIME NÃO EXISTE!", result);
    }
    
    @Test
    public void deveRetornarErroQuandoIncluirTimeEmCampeonatoNaoExistente() {
        MrBet mrBet = new MrBet();
        mrBet.adicionarTime("252_PB", "Palmeiras", "Porco");

        String result = mrBet.addTimeInCampeonato("252_PB", "Brasileirão série D 2023");

        assertEquals("CAMPEONATO NÃO EXISTE!", result);
    }
    
    @Test
    public void deveRetornarErroQuandoIncluirMaisTimesDoQueOPermitidoNoCampeonato() {
        MrBet mrBet = new MrBet();
        mrBet.adicionarTime("252_PB", "Palmeiras", "Porco");
        mrBet.adicionarTime("250_PB", "Santos", "Peixe");
        mrBet.adicionarCampeonato("Brasileirão série A 2023", 1);

        String result1 = mrBet.addTimeInCampeonato("252_PB", "Brasileirão série A 2023");
        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", result1);

        String result2 = mrBet.addTimeInCampeonato("250_PB", "Brasileirão série A 2023");
        assertEquals("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!", result2);
    }
    
    @Test
    public void deveVerificarSeUmTimePertenceAUmCampeonato() {
        MrBet mrBet = new MrBet();
        mrBet.adicionarTime("252_PB", "Palmeiras", "Porco");
        mrBet.adicionarTime("250_PB", "Santos", "Peixe");
        mrBet.adicionarCampeonato("Copa do Nordeste 2023", 2);

        mrBet.addTimeInCampeonato("250_PB", "Copa do Nordeste 2023");

        assertTrue(mrBet.verificarTimeEmCampeonato("250_PB", "Copa do Nordeste 2023"));
        assertFalse(mrBet.verificarTimeEmCampeonato("252_PB", "Copa do Nordeste 2023"));
    }
    
    @Test
    public void deveVerificarSeUmTimePertenceAUmCampeonatoQueNaoFoiCadastrado() {
        MrBet mrBet = new MrBet();
        mrBet.adicionarTime("252_PB", "Palmeiras", "Porco");

        assertFalse(mrBet.verificarTimeEmCampeonato("252_PB", "Brasileirão série D 2023"));
    }
    @Test
    public void deveVerificarSeUmTimeNaoCadastradoPertenceAUmCampeonato() {
        MrBet mrBet = new MrBet();
        mrBet.adicionarCampeonato("Copa do Nordeste 2023", 10);

        assertFalse(mrBet.verificarTimeEmCampeonato("005_PB", "Copa do Nordeste 2023"));
    }

}
