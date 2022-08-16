package com.lucasl.avaliacao_digix.enums;

/**
 *
 * @author Lucas Lopes
 */
public enum PontuacaoDependentes implements IPontuacao {
    
    Nulo(0, 0),
    Dependentes1ou2(2, 2),
    Dependentes3ouMais(Integer.MAX_VALUE, 3);
    
    private final int qtdMaxDependentes;
    private final int pontos;
        
    PontuacaoDependentes(int qtdMaxDependentes, int pontos) {
        this.qtdMaxDependentes = qtdMaxDependentes;
        this.pontos = pontos;
    }
    
    public int getMaxDependentes() {
        return this.qtdMaxDependentes;
    }
    
    public int getPontos() {
        return this.pontos;
    }
    
    public static PontuacaoDependentes toEnum(int dependentes) throws Exception {
        if(dependentes < 0) {
            throw new Exception("Valor de dependentes inválido");
        }
        else if(dependentes == 0) {
            return Nulo;
        } else {
            for(PontuacaoDependentes pt : PontuacaoDependentes.values()) {
                if(dependentes <= pt.getMaxDependentes()) {
                    return pt;
                }
            }
        }
        throw new Exception("Valor de dependentes inválido");
    }
    
}
