// Pacote para a classe Principal
package br.senai.devtubaraosc.heroi;

// Classe principal que inicia a aplicação
public class Principal {
    // Método principal da aplicação
    public static void main(String[] args) {
        // Criando uma instância da classe de aplicação (HeroiCli)
        HeroiCli heroiCli = new HeroiCli();
        
        // Invocando o método 'executar' para deixar a aplicação rodando
        heroiCli.executar();
    }
}
