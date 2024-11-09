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

public class ClasseContagemVotos {
    public VarHomoVota[] EleitoresSecao(VarHomoVota[] votos)throws IOException{
        int i; int j = 0; String NomeArq = "tempData2.jdata";
        votos = new VarHomoVota[200];
        int contagemvotos[] = new int[11];
        
        for (i=0;i<200;i++){
            votos[i] = new VarHomoVota();
        }
        
        BufferedReader Leitura = new BufferedReader(new FileReader(NomeArq));
            
            for (i=0;i<200;i++){
                votos[i].NumSec = Integer.parseInt(Leitura.readLine());
                votos[i].NumCand = Integer.parseInt(Leitura.readLine());
            }
        
        Leitura.close();
        
        System.out.println("A quantidade de votos por seção foi:");
        System.out.println("");
        for (i=0; i<11; i++){
            System.out.println("Seção " + i);
            
            for (j=j;j<200;j++){
                if (votos[j].NumSec == i){
                    contagemvotos[i]++;
                }
                else{
                    break;
                }
            }
            System.out.println(contagemvotos[i] + " votos");
            System.out.println("");
        }
  
        return votos;
    }
    
    public VarHomoVota[] MaiorMenor (VarHomoVota[] votos)throws IOException{
        int i; int j=0; 
        String NomeArq = "tempData2.jdata";
        String PromptIgualMaior = ": ";
        String PromptIgualMenor = ": ";
        votos = new VarHomoVota[200];
        int contagemvtsec [] = new int [11];
        int aux = 0;
        
        for (i=0; i<200; i++){
            votos[i] = new VarHomoVota();
        }
        
        BufferedReader Leitura = new BufferedReader(new FileReader(NomeArq));
            
            for (i=0;i<200;i++){
                votos[i].NumSec = Integer.parseInt(Leitura.readLine());
                votos[i].NumCand = Integer.parseInt(Leitura.readLine());
            }
        
        Leitura.close();
        
        for (i=0;i<11;i++){
            for (j=j;j<200;j++){
                if (votos[j].NumSec == i){
                    contagemvtsec[i]++;
                }
                else{
                    break;
                }
            }
        }
        
        for(i=1;i<11;i++){
            if(contagemvtsec[i-1]< contagemvtsec[i]){
                aux = i-1;
            }  
        }
        for(i=0;i<11;i++){
            if(contagemvtsec[aux] == contagemvtsec[i]){
                PromptIgualMenor = PromptIgualMenor + Integer.toString(i) + ", ";
            }
        }
        JOptionPane.showMessageDialog(null, "A seção com menor quantidade de votos foi a seção " + aux + " com " + contagemvtsec[aux] + " votos");
        
        for (i=0;i<10;i++){
            if(contagemvtsec[i] < contagemvtsec[i+1]){
                aux = i+1;
            }
        }
        
        
        for (i=0;i<11;i++){
            if(contagemvtsec[aux] == contagemvtsec[i]){
                PromptIgualMaior = PromptIgualMaior + Integer.toString(i) + ", ";
                j=1;
            }
        }
        
        if (j==1){
            JOptionPane.showMessageDialog(null,"As seções com a maior quantidade de voto são" + PromptIgualMaior);
        }
        
        else{
            JOptionPane.showMessageDialog(null, "A seção com maior quantidade de votos foi a seção " + aux + " com " + contagemvtsec[aux] + " votos");
        }
        
        return votos;
    }
    
    public VarHomoVota[] VotosPorCandidato(VarHomoVota[] votos)throws IOException{
        int i; int j; int aux;
        String NomeArq = "tempData2.jdata";
        votos = new VarHomoVota[200];
        int transferaux[] = new int [2];
        int contagemvts[] = new int [301];
        
        for (i=0;i<200;i++){
            votos[i] = new VarHomoVota();
        }
        
        BufferedReader Leitura = new BufferedReader(new FileReader(NomeArq));
            for(i=0; i<200; i++){
                votos[i].NumSec = Integer.parseInt(Leitura.readLine());
                votos[i].NumCand = Integer.parseInt(Leitura.readLine());
            }
        Leitura.close();
        
        for (i=0;i<200;i++){
            aux = i;
            for (j=i;j<200;j++){
                if (votos[aux].NumCand > votos[j].NumCand){
                    aux = j;
                }
            }
            
            //troca o valor de AUX com I
            transferaux[0] = votos[i].NumSec;
            transferaux[1] = votos[i].NumCand;
            votos[i].NumSec = votos[aux].NumSec;
            votos[i].NumCand = votos[aux].NumCand;
            votos[aux].NumSec = transferaux[0];
            votos[aux].NumCand = transferaux[1];
        }
        
        for (i=0;i<200;i++){
            contagemvts[votos[i].NumCand]++;
        }
        
        System.out.println("Votos por candidato: \n");
        for (i=0;i<301;i++){
            System.out.println("Candidato: " + i + " - votos: " + contagemvts[i]);
        }
        
        
        return votos;
    }
    
    
    public VarHomoVota[] DezPrimeiros(VarHomoVota[] votos)throws IOException{
        int i; int j; int aux; int maior [] = new int [2];
        String NomeArq = "tempData2.jdata";
        String NomeArqTeste = "teste.jdata";
        votos = new VarHomoVota[200];
        VarHomoVota aux1 = new VarHomoVota();
        VarHomoVota[] ctvotos = new VarHomoVota[301];
        
                
        for (i=0;i<200;i++){
            votos[i] = new VarHomoVota();
        }
        
        for (i=0;i<301;i++){
            ctvotos[i] = new VarHomoVota();
        }
        
        BufferedReader Leitura = new BufferedReader(new FileReader(NomeArq));
            for (i=0;i<200;i++){
                votos[i].NumSec = Integer.parseInt(Leitura.readLine());
                votos[i].NumCand = Integer.parseInt(Leitura.readLine());
            }
        Leitura.close();
            
        for (i=0;i<200;i++){
            aux = i;
            for (j=i;j<200;j++){
                if (votos[aux].NumCand < votos[j].NumCand){
                    aux = j;
                }
            }
            aux1 = votos[i];
            votos[i] = votos[aux];
            votos[aux]=aux1;
        }
        
        //acima ok
        
       
        for (i=0;i<301;i++){
            ctvotos[i].NumCand = i;
            ctvotos[i].NumSec = 0;
        }
        
        //acima ok
        
        for (i=0;i<200;i++){
            ctvotos[votos[i].NumCand].NumSec = ctvotos[votos[i].NumCand].NumSec + 1;
        }
        

        
        for (i=0;i<301;i++){
            aux = i;
            for (j=i;j<301;j++){
                if(ctvotos[aux].NumSec < ctvotos[j].NumSec){
                    aux = j;
                }
            }
            aux1 = ctvotos[aux];
            ctvotos[aux] = ctvotos[i];
            ctvotos[i] = aux1;
        }
        
        
        System.out.println("10 candidatos mais votados:\n");
        for (i=0;i<10;i++){
            System.out.println("Candidato: " + ctvotos[i].NumCand + " | Votos: " + ctvotos[i].NumSec);
        }
       
        
        return votos;
    }
           
  
}
