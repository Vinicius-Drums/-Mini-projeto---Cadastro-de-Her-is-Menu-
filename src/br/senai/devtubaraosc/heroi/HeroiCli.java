// Pacote para a classe HeroiCli
package br.senai.devtubaraosc.heroi;

// Importações necessárias
import br.senai.devtubaraosc.heroi.model.Heroi;
import br.senai.devtubaraosc.heroi.utils.ConsoleColors;
import br.senai.devtubaraosc.heroi.utils.ConsoleLog;

import java.util.Scanner;

// Classe responsável pela lógica de interação com o usuário
public class HeroiCli {
    // Scanner para entrada de dados do usuário
    private Scanner scanner;

    // Construtor da classe
    public HeroiCli() {
        this.scanner = new Scanner(System.in);
    }

    // Método para exibir o menu da aplicação
    public void exibirMenu() {
        ConsoleLog.info("");
        ConsoleLog.info(ConsoleColors.BLUE + "===== MENU =====" + ConsoleColors.RESET);
        ConsoleLog.info("");
        ConsoleLog.info(ConsoleColors.BLUE + "1. Adicionar Herói" + ConsoleColors.RESET);
        ConsoleLog.info("");
        ConsoleLog.info(ConsoleColors.BLUE + "2. Listar Heróis" + ConsoleColors.RESET);
        ConsoleLog.info("");
        ConsoleLog.info(ConsoleColors.BLUE + "3. Sair" + ConsoleColors.RESET);
        ConsoleLog.info("");
        ConsoleLog.info(ConsoleColors.BLUE + "Escolha uma opção: " + ConsoleColors.RESET);
        ConsoleLog.info("");
    }

    // Método para solicitar e retornar a opção escolhida pelo usuário
    public String solicitarOpcao() {
        return scanner.nextLine();
    }

    // Método principal para execução do programa
    public void executar() {
        // Variáveis locais
        Heroi heroi = null;
        Heroi[] heroisCadastrados = new Heroi[5]; // Capacidade para 5 heróis
        int indice = 0; // Índice para controle dos heróis cadastrados

        try {
            // Loop principal do programa
            while (true) {
                exibirMenu(); // Exibe o menu

                // Ler a opção do usuário
                String opcao = solicitarOpcao();

                // Realizar a ação correspondente à opção escolhida
                switch (opcao) {
                    case "1":
                        // Adicionar um novo herói
                        ConsoleLog.info("");
                        ConsoleLog.info("Nome do Herói: ");
                        String nome = scanner.nextLine();

                        ConsoleLog.info("Superpoder do Herói: ");
                        String superpoder = scanner.nextLine();

                        ConsoleLog.info("Idade do Herói: ");
                        String idadeStr = scanner.nextLine();

                        // Verificar se a idade é um número
                        if (!idadeStr.matches("\\d+")) {
                            // Se a idade não for um número válido, exibe mensagem de erro e continua para a próxima iteração
                            ConsoleLog.error("Por favor, insira uma idade válida.");
                            continue;
                        }
                        
                        // Converte a idade para inteiro
                        int idade = Integer.parseInt(idadeStr);

                        // Cria um novo objeto herói
                        heroi = new Heroi(nome, superpoder, idade);
                        heroisCadastrados[indice] = heroi;
                        indice++; // Incrementa o índice
                        ConsoleLog.success("");
                        ConsoleLog.success("Herói adicionado com sucesso!");
                        ConsoleLog.success("");
                        break;
                    case "2":
                        // Listar todos os heróis cadastrados
                        if (indice == 0) {
                            ConsoleLog.warning("Nenhum herói cadastrado.");
                        } else {
                            ConsoleLog.info("");
                            ConsoleLog.info(ConsoleColors.YELLOW + "===== LISTA DE HERÓIS =====" + ConsoleColors.RESET);
                            for (int i = 0; i < indice; i++) {
                                ConsoleLog.info(ConsoleColors.YELLOW + "Nome: " + heroisCadastrados[i].getNome());
                                ConsoleLog.info(ConsoleColors.YELLOW + "Superpoder: " + heroisCadastrados[i].getSuperpoder());
                                ConsoleLog.info(ConsoleColors.YELLOW + "Idade: " + heroisCadastrados[i].getIdade());
                                ConsoleLog.info(ConsoleColors.YELLOW + "-----------------------------" + ConsoleColors.RESET);
                            }
                        }
                        break;
                    case "3":
                        // Sair do sistema
                        ConsoleLog.warning("Saindo do sistema...");
                        return; // Encerra o método executar()
                    default:
                        // Opção inválida
                        ConsoleLog.error("Opção inválida. Por favor, escolha uma opção válida.");
                }
            }
        } finally {
            // Fecha o scanner ao sair do loop principal
            scanner.close();
        }
    }
}
