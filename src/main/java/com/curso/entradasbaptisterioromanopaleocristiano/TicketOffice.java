/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.entradasbaptisterioromanopaleocristiano;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pgervill
 */
public class TicketOffice {

    private HashMap<String, Integer> calendar;

    public TicketOffice() {
        calendar = new HashMap();
    }

    public boolean sellTickets(int numTickets, int money, String ticketDate)throws ArithmeticException, Sintickets {
        boolean sellTickets =true;
        Integer selled = calendar.get(ticketDate);
        
        if (canSellTickets(numTickets, money, ticketDate)) {
            if (selled == null) {
                calendar.put(ticketDate, numTickets);
            } else {
                calendar.put(ticketDate, selled + numTickets);
                calendar.get(ticketDate);
            }
        }else{
            sellTickets=false;
        }
        
        return sellTickets;
    }

    public boolean canSellTickets(int numTickets, int money, String ticketDate)throws ArithmeticException, Sintickets{
        boolean canSell = false;
        
        if (money != numTickets * 4){
            throw new ArithmeticException("Ya se que te ha fascinado el baptisterio romano paleocristiano "
                    + "del siglo primero de las Gabias, pero aprende a contar, cariño.");
        }
        
        if (numTickets > 10){
            throw new Sintickets ("Para ese dia ya estamos llenos cariño, pero es entendible, ¿A QUIEN NO LE VA A GUSTAR?" +
                                "\nNos quedan solo " + getRemainingTickets(ticketDate)+ "entradas para el" + ticketDate +".");
        }
        
        if(money == numTickets * 4 && numTickets <= 10) {
            if (calendar.containsKey(ticketDate)) {
                if (calendar.get(ticketDate) + numTickets <= 10) {
                    canSell = true;
                }
            } else {
                canSell = true;
            }
        }
        return canSell;
    }

    public int getRemainingTickets(String date) {
        int tickets=0;
        if(calendar.containsKey(date)){
            tickets=10 - calendar.get(date);
        }else{
            tickets=10;
        }
        return tickets;
    }

    public boolean correctDate(String date) {
        Pattern pattern = Pattern.compile("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(date);
        boolean correctDate = matcher.find();
        return correctDate;
    }
}
