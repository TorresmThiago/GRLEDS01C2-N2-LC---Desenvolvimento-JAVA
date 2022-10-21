import java.util.Scanner;

public class ControleAcademico {

    private static String alunos[] = new String[100];
    private static float notasAV1[] = new float[100];
    private static float notasAV2[] = new float[100];

    private static int vetorIndex = 0;

    private static void cadastrarAluno() {  

        if (vetorIndex < 100) {
            
            Scanner entrada = new Scanner(System.in);
            System.out.println("Digite o nome do aluno: ");
            
            String nome = entrada.nextLine();
            System.out.println("Digite a nota da AV1: ");
            
            float notaAV1 = entrada.nextFloat();
            System.out.println("Digite a nota da AV2: ");
            
            float notaAV2 = entrada.nextFloat();
            
            if(notaAV1 >= 0 && notaAV1 <= 10 && notaAV2 >= 0 && notaAV2 <= 10) {
                alunos[vetorIndex] = nome;
                notasAV1[vetorIndex] = notaAV1;
                notasAV2[vetorIndex] = notaAV2;
                vetorIndex++;
            } else {
                System.out.println("Nota inválida");
            }
            
            vetorIndex++;
            
            System.out.println("Aluno cadastrado com sucesso!");

        } else {
            System.out.println("Limite de alunos atingido!");
        }
    }
    
    private static void consultarBoletimAluno() {  

        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o número do aluno: ");

        int numeroAluno = entrada.nextInt();

        if(numeroAluno >= 0 && numeroAluno < vetorIndex) {
            float media = (notasAV1[numeroAluno] + notasAV2[numeroAluno]) / 2;
            String situacao = "Reprovado";

            if(media >= 7) {
                situacao = "Aprovado";
            } else if(media >= 4 && media < 7) {
                situacao = "Prova final";
            }

            System.out.println("Aluno: " + alunos[numeroAluno]);
            System.out.println("AV1: " + notasAV1[numeroAluno]);
            System.out.println("AV2: " + notasAV2[numeroAluno]);
            System.out.println("Média: " + media);
            System.out.println("Situação: " + situacao);
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }
    
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
