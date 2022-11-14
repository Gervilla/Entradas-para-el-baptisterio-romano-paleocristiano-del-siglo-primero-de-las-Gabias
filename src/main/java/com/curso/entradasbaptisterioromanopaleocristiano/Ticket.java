/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.entradasbaptisterioromanopaleocristiano;

/**
 *
 * @author pgervill
 */
public class Ticket {
    private static int nTicket=0;
    private final int number;
    private String date;
    
    
    public Ticket(String date){
        nTicket++;
        this.number = nTicket;
        this.date = date;
    }
}
