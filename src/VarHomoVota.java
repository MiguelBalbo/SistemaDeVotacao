/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author miguelbalbo
 */
public class VarHomoVota {
    int NumSec; int NumCand;
    
    
    //constructor - bob o construtor
    VarHomoVota(){
        this (0,0);
    }
    
    //NumeroSecao e NumeroCandidato é o número que está recebendo (como uma procedure);
    //NumSec e NumCand é o valor que a var será escrita;
    VarHomoVota(int NumeroSecao, int NumeroCandidato){
        NumSec = NumeroSecao;
        NumCand = NumeroCandidato;
    }
}
