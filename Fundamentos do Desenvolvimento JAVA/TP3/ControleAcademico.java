import java.util.Scanner;
import Exceptions.*;

public class ControleAcademico {

    private static String alunos[] = new String[100];
    private static float notasAV1[] = new float[100];
    private static float notasAV2[] = new float[100];

    private static int indexAlunosCadastrados = 0;

    private static String validaEntradaNome(String nome) throws NomeInvalidoException {
        if (nome.length() < 3) {
            throw new NomeInvalidoException("Nome inválido. O nome deve ter pelo menos 3 caracteres.");
        }

        return nome;
    }

    private static float validaEntradaNota(float nota) throws NotaInvalidaException {
        if (nota < 0 || nota > 10) {
            throw new NotaInvalidaException("Nota inválida. A nota deve estar entre 0 e 10.");
        }

        return nota;
    }

    private static void cadastrarAluno() throws NotaInvalidaException, NomeInvalidoException {

        if (indexAlunosCadastrados < 100) {

            Scanner entrada = new Scanner(System.in);
            String nome;
            float notaAV1;
            float notaAV2;

            try {
                System.out.println("Digite o nome do aluno: ");
                nome = validaEntradaNome(entrada.nextLine());

                System.out.println("Digite a nota da AV1: ");
                notaAV1 = validaEntradaNota(entrada.nextFloat());

                System.out.println("Digite a nota da AV2: ");
                notaAV2 = validaEntradaNota(entrada.nextFloat());

            } catch (NomeInvalidoException e) {
                System.out.println(e.getMessage());
                terminarLinhaConsole();
                return;

            } catch (NotaInvalidaException e) {
                System.out.println(e.getMessage());
                terminarLinhaConsole();
                return;

            } catch (Exception e) {
                System.out.println("Erro desconhecido.");
                terminarLinhaConsole();
                return;

            } finally {
                entrada.close();
            }

            if (notaAV1 >= 0 && notaAV1 <= 10 && notaAV2 >= 0 && notaAV2 <= 10) {
                alunos[indexAlunosCadastrados] = nome;
                notasAV1[indexAlunosCadastrados] = notaAV1;
                notasAV2[indexAlunosCadastrados] = notaAV2;
            } else {
                System.out.println("Nota inválida");
            }

            System.out.println("Aluno cadastrado com sucesso! Número no registro: " + indexAlunosCadastrados);

            indexAlunosCadastrados++;

        } else {
            System.out.println("Limite de alunos atingido!");
        }

        terminarLinhaConsole();
    }

    private static void consultarBoletimAluno(int alunoId) {

        if (alunoId >= 0 && alunoId + 1 < indexAlunosCadastrados) {
            float media = (notasAV1[alunoId] + notasAV2[alunoId]) / 2;
            String situacao = "Reprovado";

            if (media >= 7) {
                situacao = "Aprovado";
            } else if (media >= 4 && media < 7) {
                situacao = "Prova final";
            }

            System.out.println("Aluno: " + alunos[alunoId]);
            System.out.println("AV1: " + notasAV1[alunoId]);
            System.out.println("AV2: " + notasAV2[alunoId]);
            System.out.println("Média: " + media);
            System.out.println("Situação: " + situacao);
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    private static void consultarNotasTurma() {
        if (indexAlunosCadastrados > 0) {
            for (int i = 0; i < indexAlunosCadastrados; i++) {
                consultarBoletimAluno(i);
                System.out.println("----------------------------");
            }
        } else {
            System.out.println("Não há alunos cadastrados!");
        }

        terminarLinhaConsole();
    }

    private static void terminarLinhaConsole() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Pressione ENTER para continuar...");
        entrada.nextLine();
    }

    public static void main(String[] args) throws NotaInvalidaException, NomeInvalidoException {

        Scanner entrada = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu do controle acadêmico - TP1");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Consultar Boletim de um aluno");
            System.out.println("3 - Consultar notas da turma");
            System.out.println("4 - Sair");
            System.out.println("Digite a opção desejada: ");
            int opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    System.out.println("Digite o número do aluno: ");
                    int numeroAluno = entrada.nextInt();
                    consultarBoletimAluno(numeroAluno);
                    terminarLinhaConsole();
                    break;
                case 3:
                    consultarNotasTurma();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    terminarLinhaConsole();
                    break;
            }
        }

    }
}
