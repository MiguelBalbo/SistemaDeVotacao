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
import java.util.Random;

public class ClasseORDvotos {
    //se colocar void depois do public, o menu não chegará aqui
    public VarHomoVota[] CriaVotos(VarHomoVota[] votos) throws IOException{//throws IOException - IOException só se usa quando o código tem leitura ou escrita
        int i; String NomeArq = "data.jdata";
        Random aleatorio = new Random();
        
        votos = new VarHomoVota[300];
        
        BufferedWriter Escrita = new BufferedWriter(new FileWriter(NomeArq, true));
        
            //limpa cada posição da variável;
            for (i=0;i<200;i++){
                votos[i] = new VarHomoVota();
            }

            //Grava a variável com os valores
            for (i=0;i<200;i++){
                
                //gera número aleatorio
                votos[i].NumSec = aleatorio.nextInt(11);
                Escrita.write(Integer.toString(votos[i].NumSec));
                Escrita.newLine();
                
                //gera numero aleatorio
                votos[i].NumCand = aleatorio.nextInt(301);
                Escrita.write(Integer.toString(votos[i].NumCand));
                Escrita.newLine();
          
            }
        Escrita.close();
        
        System.out.println("Cadastro OK");
           
        
        return votos;
    }
    
    public VarHomoVota[] ArrumaVotos(VarHomoVota[] votos)throws IOException{
        int i; int j; int aux;
        String NomeArq = "data.jdata"; String NomeArqOrg = "tempData2.jdata";
        votos = new VarHomoVota[200];
        int vetoraux[] = new int[2];
        
        
        //Ele referencia a si mesmo e diz pra ele criar um novo buffer de leitura, com o módulo de leitura lendo o arq da var
        BufferedReader Leitura = new BufferedReader(new FileReader(NomeArq));
        
        for (i=0;i<200;i++){
            //IMPORTANTE!!! O 'new' deve estar, porque ele está formatando as posições
            votos[i] = new VarHomoVota();
        }
        
        for(i=0; i<200; i++){
            //importante a leitura.readline, pois ele fará a leitura da linha
            //Integer.parseInt converte o string em texto
            votos[i].NumSec = Integer.parseInt(Leitura.readLine());
            votos[i].NumCand = Integer.parseInt(Leitura.readLine());
        }
        
        //para de ler
        Leitura.close();
        
        //eu tenho que fazer uma leitura por seção, ele deve olhar a seção e ir comparando até achar uma menor, 
        //e quando achar uma menor, verificar se é realmente menor ou igual as outras (se for igual, tratar como menor)
        //depois de achar a menor, devo pegar e subir o valor pra posição
        //na próxima itineração, ele deve começar depois da primeira posição, já que eu arrumei ela
        
        for (i=0;i<200;i++){
            aux = i;
            for (j=i;j<200;j++){
                if(votos[aux].NumSec > votos[j].NumSec){
                    aux = j;
                }
            }
            vetoraux[0] = votos[i].NumSec;
            vetoraux[1] = votos[i].NumCand;
            votos[i].NumSec = votos[aux].NumSec;
            votos[i].NumCand = votos[aux].NumCand;
            votos[aux].NumSec = vetoraux[0];
            votos[aux].NumCand = vetoraux[1];
        }
        
       
        
        BufferedWriter Escrita = new BufferedWriter(new FileWriter(NomeArqOrg));
           for (i=0;i<200;i++){
               Escrita.write(Integer.toString(votos[i].NumSec));
               Escrita.newLine();
               Escrita.write(Integer.toString(votos[i].NumCand));
               Escrita.newLine();
           }
        
        
        
        System.out.println("Organização OK");       
        Escrita.close();
        
        
        return votos;
    }
    
    public VarHomoVota[] GravaVotos (VarHomoVota[] votos) throws IOException{
        int i; int j; int k = 0;
        String NomeArqOrg = "tempData2.jdata"; String NomeArqUser = "Votação 2021.txt";
        votos = new VarHomoVota[200];
        
        for (i=0;i<200;i++){
            votos[i] = new VarHomoVota();
        }
        
        
        BufferedReader Leitura = new BufferedReader(new FileReader(NomeArqOrg));
            for (i=0;i<200;i++){
                //IMPORTANTE - INTEGER PARSE INT (converte string pra int)
                votos[i].NumSec = Integer.parseInt(Leitura.readLine());
                votos[i].NumCand = Integer.parseInt(Leitura.readLine());
            }
        
        Leitura.close();
        
        BufferedWriter Escrita = new BufferedWriter(new FileWriter(NomeArqUser));
            for(i=0;i<11;i++){
                Escrita.write("Seção " + i + " :");
                Escrita.newLine();
                for (j=k;j<200;j++){
                    if(votos[j].NumSec == i){
                        Escrita.write("Candidato " + votos[j].NumCand);
                        Escrita.newLine();
                    }
                    else{
                        k = j;
                        Escrita.newLine();
                        break;
                    }
                }
            }
        
        System.out.println("Gravação OK");
        Escrita.close();
        
        return votos;
    }
}
