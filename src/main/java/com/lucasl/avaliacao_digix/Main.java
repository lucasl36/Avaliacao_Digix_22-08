package com.lucasl.avaliacao_digix;

import com.lucasl.avaliacao_digix.models.Familia;
import com.lucasl.avaliacao_digix.daos.FamiliaMockDAO;
import com.lucasl.avaliacao_digix.services.Avaliar;
import java.util.List;

/**
 *
 * @author Lucas Lopes
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("DEMONSTRAÇÃO");
        System.out.println("Projeto para seleção de famílias aptas a ganharem uma casa popular");
        System.out.println("Buscando famílias para avaliação...");
        System.out.println();
        
        List<Familia> familiasParaAvaliar = FamiliaMockDAO.getInstance().getFamilias();
        for(Familia familia : familiasParaAvaliar) {
            try {
                Avaliar service = new Avaliar(familia);
                service.executar();
                System.out.println(familia);
                System.out.println();
            } catch(Exception e) {
                System.out.println("Não foi possível avaliar família " + familia.getDescricao());
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        System.out.println("Finalizando...");
    }
    
}
