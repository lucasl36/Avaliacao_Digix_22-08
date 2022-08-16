package com.lucasl.avaliacao_digix.enums;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

/**
 *
 * @author Lucas Lopes
 */
public class PontuacaoRendaTest {
    
    @Rule
    public ErrorCollector error = new ErrorCollector();
    
    @Test
    public void testToEnumRendaMaiorQue1500() {
        try {
            PontuacaoRenda pontuacao1 = PontuacaoRenda.toEnum(1501.0);
            error.checkThat(pontuacao1, is(PontuacaoRenda.RendaMaiorQue1500));
            PontuacaoRenda pontuacao2 = PontuacaoRenda.toEnum(Double.MAX_VALUE);
            error.checkThat(pontuacao2, is(PontuacaoRenda.RendaMaiorQue1500));
        } catch(Exception e) {
            error.addError(e);
        }
    }
    
    @Test
    public void testToEnumRendaDe900Ate1500() {
        try {
            PontuacaoRenda pontuacao1 = PontuacaoRenda.toEnum(901.0);
            error.checkThat(pontuacao1, is(PontuacaoRenda.RendaDe900Ate1500));
            PontuacaoRenda pontuacao2 = PontuacaoRenda.toEnum(1500.0);
            error.checkThat(pontuacao2, is(PontuacaoRenda.RendaDe900Ate1500));
        } catch(Exception e) {
            error.addError(e);
        }
    }
    
    @Test
    public void testToEnumRendaAte900() {
        try {
            PontuacaoRenda pontuacao1 = PontuacaoRenda.toEnum(1.0);
            error.checkThat(pontuacao1, is(PontuacaoRenda.RendaAte900));
            PontuacaoRenda pontuacao2 = PontuacaoRenda.toEnum(900.0);
            error.checkThat(pontuacao2, is(PontuacaoRenda.RendaAte900));
        } catch(Exception e) {
            error.addError(e);
        }
    }
    
    @Test
    public void testToEnumRendaInvalida() {
        error.checkThrows(Exception.class, () -> {
            PontuacaoRenda.toEnum(-1);
        });
    }
    
}
