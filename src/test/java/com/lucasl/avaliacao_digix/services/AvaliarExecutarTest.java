package com.lucasl.avaliacao_digix.services;

import static org.hamcrest.CoreMatchers.is;

import com.lucasl.avaliacao_digix.enums.PontuacaoDependentes;
import com.lucasl.avaliacao_digix.enums.PontuacaoRenda;
import com.lucasl.avaliacao_digix.models.Familia;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Lucas Lopes
 */
@RunWith(Parameterized.class)
public class AvaliarExecutarTest {
    
    @Rule
    public ErrorCollector error = new ErrorCollector();
    
    @Parameters(name="AvaliarTest {index} - {0}")
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][] {
            {"Fam1", 3, 900.0, 0, 8},
            {"Fam2", 2, 900.0, 0, 7},
            {"Fam3", 3, 1500.0, 0, 6},
            {"Fam4", 2, 1500.0, 0, 5},
            {"Fam5", 4, 6500.0, 0, 3},
            {"Fam6", 0, 1400.0, 0, 3},
            {"Fam7", 0, 450.0, 0, 5},
            {"Fam8", 0, 2500.0, 0, 0},
            {"Fam9", 1, 8000.0, 0, 2}
        });
    }
    
    private final Familia familia;
    private final int pontosEsperados;
    private Avaliar service;
    
    public AvaliarExecutarTest(String descricao, int dependentes, double renda, int pontos, int pontosEsperados) {
        this.familia = new Familia(descricao, dependentes, renda, pontos);
        this.pontosEsperados = pontosEsperados;
    }
    
    @Before
    public void setup() {
        this.service = new Avaliar(this.familia);        
    }
    
    @Test
    public void testExecutar() {
        try {
            this.service.executar();
            PontuacaoDependentes ptsDep = PontuacaoDependentes.toEnum(familia.getDependentes()); 
            PontuacaoRenda ptsRen = PontuacaoRenda.toEnum(familia.getRenda());
            int somaPts = ptsDep.getPontos() + ptsRen.getPontos();
            error.checkThat(familia.getPontos(), is(pontosEsperados));
            error.checkThat(familia.getPontos(), is(somaPts));
        } catch(Exception e) {
            error.addError(e);
        }
    }
}
