package com.lucasl.avaliacao_digix.services;

import com.lucasl.avaliacao_digix.enums.PontuacaoDependentes;
import com.lucasl.avaliacao_digix.enums.PontuacaoRenda;
import com.lucasl.avaliacao_digix.models.Familia;

/**
 *
 * @author Lucas Lopes
 */
public class Avaliar implements IService {
    
    private Familia familiaAvaliada;
    
    private Avaliar() {
        this.familiaAvaliada = null;
    }
    
    public Avaliar(Familia familia) {
        this.familiaAvaliada = familia;
    }

    @Override
    public void executar() throws Exception {
        if(familiaAvaliada == null) {
            throw new Exception("Não é possível executar este serviço sem antes informar uma família para ser avaliada");
        }
        PontuacaoDependentes ptsDependentes = PontuacaoDependentes.toEnum(familiaAvaliada.getDependentes());
        PontuacaoRenda ptsRenda = PontuacaoRenda.toEnum(familiaAvaliada.getRenda());
        this.familiaAvaliada.setPontos(ptsDependentes.getPontos() + ptsRenda.getPontos());
    }
    
}
