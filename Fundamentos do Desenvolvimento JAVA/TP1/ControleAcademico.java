import java.util.Scanner;

public class ControleAcademico {

    private static String alunos[] = new String[100];
    private static float notasAV1[] = new float[100];
    private static float notasAV2[] = new float[100];

    private static int vetorIndex = 0;

    private static void cadastrarAluno() {  
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do aluno: ");

        String nome = sc.nextLine();
        System.out.println("Digite a nota da AV1: ");
        
        float notaAV1 = sc.nextFloat();
        System.out.println("Digite a nota da AV2: ");
        
        float notaAV2 = sc.nextFloat();
        
        alunos[vetorIndex] = nome;
        notasAV1[vetorIndex] = notaAV1;
        notasAV2[vetorIndex] = notaAV2;

        vetorIndex++;

        System.out.println("Aluno cadastrado com sucesso!");
    }
    
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
