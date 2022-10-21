import java.util.Scanner;

public class ControleAcademico {

    private static void cadastrarAluno() {    }
    
    private static void consultarBoletimAluno() {    }
    
    private static void consultarNotasTurma() {    }
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);

        while(true){
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Consultar Boletim de um aluno");
            System.out.println("3 - Consultar notas da turma");
            System.out.println("4 - Sair");
            System.out.println("Digite a opção desejada: ");
            int opcao = entrada.nextInt();
            switch(opcao){
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    consultarBoletimAluno();
                    break;
                case 3:
                    consultarNotasTurma();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

    }
}
