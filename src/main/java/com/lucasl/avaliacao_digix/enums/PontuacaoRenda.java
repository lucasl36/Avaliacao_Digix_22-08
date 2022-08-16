package com.lucasl.avaliacao_digix.enums;

/**
 *
 * @author Lucas Lopes
 */
public enum PontuacaoRenda implements IPontuacao {
    
    RendaMaiorQue1500(1501.0, 0),
    RendaDe900Ate1500(901.0, 3),
    RendaAte900(0.0, 5);
    
    private final double vlrMinRenda;
    private final int pontos;
        
    PontuacaoRenda(double vlrMinRenda, int pontos) {
        this.vlrMinRenda = vlrMinRenda;
        this.pontos = pontos;
    }
    
    public double getVlrMinRenda() {
        return this.vlrMinRenda;
    }
        
    public int getPontos() {
        return this.pontos;
    }
    
    public static PontuacaoRenda toEnum(double valor) throws Exception {
        if (valor < 0.0) {
            throw new Exception("Valor de renda inválido");
        } else {
            for(PontuacaoRenda pt : PontuacaoRenda.values()) {
                if(valor >= pt.getVlrMinRenda()) {
                    return pt;
                }
            }
        }
        throw new Exception("Valor de renda inválido");
    }    
    
}
