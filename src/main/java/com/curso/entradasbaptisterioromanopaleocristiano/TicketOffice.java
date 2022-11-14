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

    public void sellTickets(int numTickets, int money, String ticketDate) {

        Integer selled = calendar.get(ticketDate);
        if (selled == null) {
            calendar.put(ticketDate, numTickets);
        } else {
            calendar.put(ticketDate, selled + numTickets);
            calendar.get(ticketDate);
        }
    }

    public boolean canSellTickets(int numTickets, int money, String ticketDate) {
        boolean canSell = false;
        if (money == numTickets * 4 && numTickets <= 10) {
            if (calendar.containsKey(ticketDate)) {
                if (calendar.get(ticketDate) + numTickets <= 10)
                    canSell = true;
            } else
                canSell = true;
        }
        return canSell;
    }
    
    public int getRemainingTickets(String date){
        return 10 - calendar.get(date);
    }

    public boolean correctDate(String date) {
        Pattern pattern = Pattern.compile("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(date);
        boolean correctDate = matcher.find();
        return correctDate;
    }
}
