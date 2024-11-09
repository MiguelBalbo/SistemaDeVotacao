/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author miguelbalbo
 */
import javax.swing.JOptionPane;
import java.io.*;
public class ClasseMenuPrincipal {
    public VarHomoVota[] MenuPrincipal(VarHomoVota[] votos)throws IOException{
        int opc; int i; String NomeArq = "tempData2.jdata";
        votos = new VarHomoVota[200];
        ClasseContagemVotos contagem = new ClasseContagemVotos();
        
        BufferedReader Leitura = new BufferedReader(new FileReader(NomeArq));
            for (i=0;i<200;i++){
                votos[i] = new VarHomoVota();
            }
        Leitura.close();
        
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada \n1 – Quantidade Eleitores por Seção \n" +
            "2 – Seção com Maior e Menor número de Eleitores      \n" +
            "3 – Quantidade de votos por candidato               \n" +
            "4 – 10 primeiros colocadas (nro cand. e qtd votos)  \n" +
            "9 – Finaliza consulta"));
            switch (opc){
                case 1:
                    contagem.EleitoresSecao(votos);
                break;
                case 2:
                    contagem.MaiorMenor(votos);
                break;
                case 3:
                    contagem.VotosPorCandidato(votos);
                break;
                case 4:
                    contagem.DezPrimeiros(votos);
                break;
                case 9:
                    JOptionPane.showMessageDialog(null,"Indo para o menu principal...");
                break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção inválida");
                break;      
            }
        }while(opc != 9);
        return votos;
    }
}
