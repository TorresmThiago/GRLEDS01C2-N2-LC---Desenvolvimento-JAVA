import java.util.Arrays;
import java.util.Scanner;
import Exceptions.*;
import Entidades.*;

public class ControleAcademico {

    private static Aluno alunos[] = new Aluno[100];

    private static int indexAlunosCadastrados = 0;

    private static String validaEntradaNome(String nome) throws NomeInvalidoException {
        if (nome.length() < 3) {
            throw new NomeInvalidoException("Nome inválido. O nome deve ter pelo menos 3 caracteres.");
        }

        if (nome.length() > 50) {
            throw new NomeInvalidoException("Nome inválido. O nome deve ter no máximo 50 caracteres.");
        }

        if (!nome.contains(" ")) {
            throw new NomeInvalidoException("Nome inválido. Favor inserir nome e sobrenome.");
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
            Aluno aluno = new Aluno();

            try {
                System.out.println("Digite o nome do aluno: ");
                String[] nomeCompleto = validaEntradaNome(entrada.nextLine()).split(" ");
                aluno.setNome(nomeCompleto[0]);
                aluno.setSobrenome(Arrays.copyOfRange(nomeCompleto, 1, nomeCompleto.length).toString());

                System.out.println("Digite a nota da AV1: ");
                aluno.setNotaAV1(validaEntradaNota(Float.parseFloat(entrada.nextLine())));

                System.out.println("Digite a nota da AV2: ");
                aluno.setNotaAV2(validaEntradaNota(Float.parseFloat(entrada.nextLine())));

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
                // entrada.close();
            }

            alunos[indexAlunosCadastrados] = aluno;
            System.out.println("Aluno cadastrado com sucesso! Número no registro: " + indexAlunosCadastrados);
            indexAlunosCadastrados++;
        } else {
            System.out.println("Limite de alunos atingido!");
        }

        terminarLinhaConsole();
    }

    private static void consultarBoletimAluno(int alunoId) {
        if (alunoId >= 0 && alunoId < indexAlunosCadastrados) {
            System.out.println(alunos[alunoId].toString());
        } else {
            System.out.println("Aluno não encontrado.");
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

        Scanner entrada;

        while (true) {
            entrada = new Scanner(System.in);

            System.out.println("\nMenu do controle acadêmico - TP1");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Consultar Boletim de um aluno");
            System.out.println("3 - Consultar notas da turma");
            System.out.println("4 - Sair");
            System.out.println("Digite a opção desejada: ");
            switch (entrada.nextInt()) {
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
                    entrada.close();
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
