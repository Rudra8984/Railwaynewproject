/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Traininformation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author irudr
 */
public class Traininfo{
    public int trainnumber;
    public String trainname;
    public String sourseStation;
    public String destitionStation;
    public List<Station>stations;
    public Traininfo(int trainno,String trainname,String soursestation,String destn){
	this.stations = new ArrayList<>();
	this.trainnumber=trainno;
	this.trainname=trainname;
	this.sourseStation=soursestation;
	this.destitionStation=destn;
    }
    public int gettrainno(){
	    return trainnumber;
    }
    public void addStation(Station station) {
     stations.add(station);
    }
    public double getDepartureTime(String to) {
        for (Station station : stations) {
            if (station.stacode.equals(to)) { 
            	return station.deppaturetime;
            }
        }
       return -1; 
    }

    public int getTrainnumber() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
}

