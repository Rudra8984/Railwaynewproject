/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Traininformation;

import java.util.Random;

/**
 *
 * @author irudr
 */
public class Ticket{
    Random rand = new Random();
    public int Ticketno;
    public String passengername;
    public int passengerage;
    public int Seatno;
    public String from;
    public String to;
    public Traininfo trainInfo;
    public double departuretime;
    public Ticket(String passenger,int passengeagee,Traininfo train,String from,String to,double departureTime){
	this.passengername=passenger;
	this.passengerage=passengeagee;
	Ticketno = (int)(rand.nextDouble()*100000000);
	Seatno=rand.nextInt(100);
	this.trainInfo = train;
	this.from=from;
	this.to=to;
	this.departuretime = departureTime;
    }
}

