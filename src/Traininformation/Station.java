/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Traininformation;

/**
 *
 * @author irudr
 */
public class Station{
    public String station;
    public String stacode;
    public double arravingtime;
    public double deppaturetime;
    public Station(String station, String stacode, double arravingtime, double deppaturetime) {
        this.station = station;
        this.stacode = stacode;
        this.arravingtime = arravingtime;
        this.deppaturetime = deppaturetime;
    }
}
