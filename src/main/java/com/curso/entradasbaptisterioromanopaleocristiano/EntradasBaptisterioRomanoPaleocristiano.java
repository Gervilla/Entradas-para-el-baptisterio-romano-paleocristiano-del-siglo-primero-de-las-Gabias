/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.curso.entradasbaptisterioromanopaleocristiano;

import java.util.Scanner;

/**
 *
 * @author pgervill
 */
public class EntradasBaptisterioRomanoPaleocristiano {

    private static TicketOffice office = new TicketOffice();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String date, option;
        boolean exit = false;
        while (!exit) {
            String UI = """
                    ***********************************
                    *                                 *
                    *   ¡Bienvenido al baptisterio    *
                    *   romano paleocristiano del     *
                    *   del siglo primero de las      *
                    *   Gabias!                       *
                    *   ¿Quieres comprar entradas?    *
                    *       Si, No.                   *
                    *                                 *
                    ***********************************""";
            System.out.println(UI);
            option = sc.nextLine();

            if (option.toLowerCase().equals("si")) {
                System.out.println("Cuando desea acudir al Baptisterio?");
                date = sc.nextLine();
                if (office.correctDate(date)) {
                    System.out.println("Cuantas entradas desea para es dia?");
                    int numTickets = sc.nextInt();
                    sc.nextLine();
                    if (office.canSellTickets(numTickets, numTickets * 4, date)) {
                        System.out.println("Serian " + numTickets * 4 + "$.");
                        int money = sc.nextInt();
                        sc.nextLine();

                        if (office.canSellTickets(numTickets, money, date)) {
                            System.out.println("Aqui tiene sus tickets.");
                            office.sellTickets(numTickets, money, date);
                        } else
                            System.out.println("Ya se que te ha fascinado el baptisterio romano paleocristiano del siglo primero de las Gabias, pero aprende a contar, cariño.");
                    } else
                        System.out.println("Para ese dia ya estamos llenos cariño, pero es entendible, ¿A QUIEN NO LE VA A GUSTAR?"
                                + "\nNos quedan solo "+office.getRemainingTickets(date)+" entradas para el "+date+".");
                } else
                    System.out.println("No se de que planeta vienes, pero en este, eso no es una fecha, cariño.");
            } else if (option.toLowerCase().equals("no"))
                exit = true;
            else
                System.out.println("eeeeeh, ¿como?");
        }
    }
}
