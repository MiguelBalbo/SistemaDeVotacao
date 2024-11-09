/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author miguelbalbo
 */
import java.io.*;
import javax.swing.JOptionPane;
public class ClassePrincipalVota {
    public static void main(String args[])throws IOException{
        int opc=0;
        //maneira certa de carregar uma variável externa
        VarHomoVota[] votos = new VarHomoVota[200];
        ClasseORDvotos io = new ClasseORDvotos(); //declara como variável heterogenea
        ClasseMenuPrincipal menu = new ClasseMenuPrincipal();
        
        
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: \n 1 - Cadastro \n 2 - Classificar \n 3 - Salvar em Arquivo \n 4 - Mostrar indicadores \n 9 - Sair "));
                    
                    
            switch(opc){
                case 1:
                    votos = io.CriaVotos(votos);
                break;
                case 2:
                    votos = io.ArrumaVotos(votos);
                break;
                case 3:
                    io.GravaVotos(votos);
                break;
                case 4:
                    menu.MenuPrincipal(votos);
                break;
                case 9:
                    JOptionPane.showMessageDialog(null,"OBRIGADO POR USAR NOSSO PROGRAMA 😁");
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Desculpe, código inválido ☹ ️👎");
                break;          
            }  
        }while (opc < 9);   
    }
}
