package vetortamanhodinamico;
import java.util.Scanner;
public class VetorTamanhoDinamico {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char fimProg = 'N';
        String[] vetNomes;
      
        while (fimProg =='N'); {
        
        System.out.println("Informe qtde de aluno");
        var qtdAlunos = sc.nextInt();
  
        vetNomes = new String[qtdAlunos];
        
        for (int i =    0; i < qtdAlunos; i++) {
            System.out.println("Informe o nome nr " + (i++) ) ;
            vetNomes [i] = sc.next();
                    }

        for (int i =    0; i < qtdAlunos; i++) {
        System.out.println("Informe o nome nr " +" - ") ;
        }           
            System.out.println("Finaliza? (S/N) ");
            sc.next();
    }       
            
        }
}

