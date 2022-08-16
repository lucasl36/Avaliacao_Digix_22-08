package com.lucasl.avaliacao_digix.enums;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

/**
 *
 * @author Lucas Lopes
 */
public class PontuacaoDependentesTest {
    
    @Rule
    public ErrorCollector error = new ErrorCollector();
    
    @Test
    public void testToEnumNulo() {
        try {
            PontuacaoDependentes pontuacao = PontuacaoDependentes.toEnum(0);
            error.checkThat(pontuacao, is(PontuacaoDependentes.Nulo));
        } catch(Exception e) {
            error.addError(e);
        }
    } 
    
    @Test
    public void testToEnumDependentes1ou2() {
        try {
            PontuacaoDependentes pontuacao1 = PontuacaoDependentes.toEnum(1);
            error.checkThat(pontuacao1, is(PontuacaoDependentes.Dependentes1ou2));
            PontuacaoDependentes pontuacao2 = PontuacaoDependentes.toEnum(2);
            error.checkThat(pontuacao2, is(PontuacaoDependentes.Dependentes1ou2));
        } catch(Exception e) {
            error.addError(e);
        }
    }
    
    @Test
    public void testToEnumDependentes3ouMais() {
        try {
            PontuacaoDependentes pontuacao1 = PontuacaoDependentes.toEnum(3);
            error.checkThat(pontuacao1, is(PontuacaoDependentes.Dependentes3ouMais));
            PontuacaoDependentes pontuacao2 = PontuacaoDependentes.toEnum(Integer.MAX_VALUE);
            error.checkThat(pontuacao2, is(PontuacaoDependentes.Dependentes3ouMais));
        } catch(Exception e) {
            error.addError(e);
        }        
    }
    
    @Test
    public void testToEnumDependentesInvalido() {
        error.checkThrows(Exception.class, () -> {
            PontuacaoDependentes.toEnum(-1);
        });
    }
    
}
