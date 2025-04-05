package com.testando_api.primeiro_teste_api.util;

import java.util.Scanner;

public class LeitorEntrada
{
    private static Scanner scanner = new Scanner(System.in);

    public static String returnScannerString()
    {
        String entrada = scanner.nextLine();
        if(entrada.isBlank()) throw new IllegalArgumentException("Erro: entrada invalida.");
        return entrada;
    }

    public static Integer returnScannerInteger() throws NumberFormatException
    {
        return Integer.parseInt(scanner.nextLine());
    }

    public static void liberarScanner()
    {
        scanner.close();
    }
}
