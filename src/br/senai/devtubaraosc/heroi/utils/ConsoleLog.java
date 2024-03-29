package br.senai.devtubaraosc.heroi.utils;

// Classe utilitária para exibição de mensagens no console com cores
public class ConsoleLog {

    // Método para exibir uma mensagem de erro no console
    public static void error(String message) {
        System.out.println(ConsoleColors.RED + message + ConsoleColors.RESET);
    }

    // Método para exibir uma mensagem de sucesso no console
    public static void success(String message) {
        System.out.println(ConsoleColors.GREEN + message + ConsoleColors.RESET);
    }

    // Método para exibir uma mensagem de aviso no console
    public static void warning(String message) {
        System.out.println(ConsoleColors.YELLOW + message + ConsoleColors.RESET);
    }

    // Método para exibir uma mensagem informativa no console
    public static void info(String message) {
        System.out.println(ConsoleColors.BLUE + message + ConsoleColors.RESET);
    }

    // Método para exibir uma mensagem genérica no console
    public static void log(String message) {
        System.out.println(message);
    }

    // Método para exibir uma mensagem com uma cor específica no console
    public static void log(String message, String color) {
        System.out.println(color + message + ConsoleColors.RESET);
    }
}
