package com.lucasl.avaliacao_digix.services;

import com.lucasl.avaliacao_digix.models.Familia;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

/**
 *
 * @author Lucas Lopes
 */
public class AvaliarExecutarFamiliaNulaTest {
    
    @Rule
    public ErrorCollector error = new ErrorCollector();
    
    @Test
    public void testExecutarFamiliaNula() {
        try {
            Avaliar service = new Avaliar(null);
            service.executar();
            error.addError(new Exception("Uma exceção deveria ter sido levantada neste ponto!"));
        } catch(Exception e) {
            error.checkThat(e.getMessage(), is("Não é possível executar este serviço sem antes informar uma família para ser avaliada"));
        }
    }
    
}
