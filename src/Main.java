
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MrBet mrBet = new MrBet();
        boolean running = true;

        while (running) {
            System.out.print("\n");
            System.out.println("(M)Minha inclusão de times");
            System.out.println("(R)Recuperar time");
            System.out.println("(.)Adicionar campeonato");
            System.out.println("(B)Bora incluir time em campeonato e Verificar se time está em campeonato");
            System.out.println("(E)Exibir campeonatos que o time participa");
            System.out.println("(T)Tentar a sorte e status");
            System.out.println("(!)Já pode fechar o programa!");

            System.out.print("\nOpção> ");
            String option = scanner.nextLine();

            if (option == null || option.isEmpty()) {
                throw new IllegalArgumentException("Entrada inválida!");
            }

            switch (option.toUpperCase()) {
                case "M":
                    System.out.print("Código: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Mascote: ");
                    String mascote = scanner.nextLine();

                    boolean adicionado = mrBet.adicionarTime(codigo, nome, mascote);

                    if (adicionado) {
                        System.out.println("\nINCLUSÃO REALIZADA!");
                    } else {
                        System.out.println("\nTIME JÁ EXISTE!");
                    }
                    break;
                case "R":
                    System.out.print("Código: ");
                    codigo = scanner.nextLine();

                    Time time = mrBet.recuperarTime(codigo);

                    if (time == null) {
                        System.out.println("\nTIME NÃO EXISTE!");
                    } else {
                        System.out.printf("[%s] %s / %s\n", time.getCodigo(), time.getNome(), time.getMascote());
                    }
                    break;
                case ".":
                    System.out.print("Campeonato: ");
                    String nomeDoCampeonato = scanner.nextLine();
                    System.out.print("Participantes: ");
                    int participantes = Integer.parseInt(scanner.nextLine());
            
                    boolean adicionadoCamp = mrBet.adicionarCampeonato(nomeDoCampeonato, participantes);
            
                    if (adicionadoCamp) {
                    System.out.println("\nCAMPEONATO ADICIONADO!");
                    } else {
                    System.out.println("\nCAMPEONATO JÁ EXISTE!");
                    }
                    break;
                case "B":
                System.out.print("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato? ");
                String opcao = scanner.nextLine().toUpperCase();
            
                switch (opcao) {
                    case "I":
                        System.out.print("Código: ");
                        String codigoTime = scanner.nextLine();
                        System.out.print("Campeonato: ");
                        String nomeCampeonato = scanner.nextLine();
                        String resultado = mrBet.addTimeInCampeonato(codigoTime, nomeCampeonato);
                        System.out.println(resultado);
                        break;
                    case "V":
                    System.out.print("Código do time: ");
                    String codigoDoTime = scanner.nextLine();
                    System.out.print("Nome do campeonato: ");
                    String nomeDoCampeonatoVerificar = scanner.nextLine();
            
                    mrBet.verificarTimeEmCampeonato(codigoDoTime, nomeDoCampeonatoVerificar);
                    break;
                    default:
                    throw new IllegalArgumentException("\nOpção inválida!");
                }
                break;
                case "E":
                    System.out.print("Código do time: ");
                    String codigoTimeE = scanner.nextLine();
                
                    mrBet.exibirCampeonatosDoTime(codigoTimeE);
                
                    break;
                case "T":
                System.out.println("(A) Apostar ou (S) Status das Apostas?");
                String opcaoT = scanner.nextLine().toUpperCase();
            
                switch (opcaoT) {
                    case "A":
                        System.out.print("Código do time: ");
                        String codigoTimeT = scanner.nextLine();
                        System.out.print("Campeonato: ");
                        String nomeCampeonatoT = scanner.nextLine();
                        System.out.print("Colocação: ");
                        int colocacao = Integer.parseInt(scanner.nextLine());
                        System.out.print("Valor da Aposta: R$");
                        double valorAposta = Double.parseDouble(scanner.nextLine());
            
                        String resultadoAposta = mrBet.registrarAposta(codigoTimeT, nomeCampeonatoT, colocacao, valorAposta);
                        System.out.println(resultadoAposta);
                        break;
                    case "S":
                        mrBet.exibirApostas();
                        break;
                        default:
                        throw new IllegalArgumentException("\nOpção inválida!");
                }
                break;
                case "!":
                    running = false;
                    System.out.println("\nPor hoje é só pessoal!");
                    break;
                default:
                    throw new IllegalArgumentException("\nOpção inválida!");
            }
        }

        scanner.close();
    }
}
