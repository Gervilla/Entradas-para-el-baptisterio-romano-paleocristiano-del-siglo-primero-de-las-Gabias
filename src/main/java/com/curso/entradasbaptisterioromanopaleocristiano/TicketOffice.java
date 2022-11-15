/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.entradasbaptisterioromanopaleocristiano;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author pgervill
 */
public class TicketOffice {

    private HashMap<Date, Integer> calendar;

    public TicketOffice() {
        calendar = new HashMap();
    }

    public boolean sellTickets(int numTickets, int money, Date ticketDate)throws ArithmeticException, Sintickets {
        boolean sellTickets =true;
        Integer selled = calendar.getOrDefault(ticketDate,0);
        
        if (canSellTickets(numTickets, money, ticketDate)) {         
                calendar.put(ticketDate, selled + numTickets);
                calendar.get(ticketDate);   
        }else{
            sellTickets=false;
        }
        
        return sellTickets;
    }

    public boolean canSellTickets(int numTickets, int money, Date ticketDate)throws ArithmeticException, Sintickets{
        boolean canSell = false;
        
        if (money != numTickets * 4){
            throw new ArithmeticException("Ya se que te ha fascinado el baptisterio romano paleocristiano "
                    + "del siglo primero de las Gabias, pero aprende a contar, cariño.");
        }
        
        if (numTickets > 10){
            throw new Sintickets ("Para ese dia ya estamos llenos cariño, pero es entendible, ¿A QUIEN NO LE VA A GUSTAR?" +
                                "\nNos quedan solo " + getRemainingTickets(ticketDate)+ " entradas para el " + ticketDate.toString() +".");
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

    public int getRemainingTickets(Date date) {
        int tickets;
        if(calendar.containsKey(date)){
            tickets=10 - calendar.get(date);
        }else{
            tickets=10;
        }
        return tickets;
    }
    
    public Date correctDate(String date) {
        Date day;
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            day=formatoFecha.parse(date);
        } catch (ParseException e) {
            return null;
        }
        return day;
    }
    
    public boolean proxDate(Date date){
        boolean proxDate=true;
        if (!date.after(Calendar.getInstance().getTime())){
                proxDate=false;
        }
        return proxDate;
    }
}
