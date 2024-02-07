/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Railreservation;
import java.util.*;
import java.time.LocalTime;
import Gui.*;
import Traininformation.*;
/**
 *
 * @author irudr
 */
public class Trainreservation{
    public List<Traininfo>Trains;
    private List<Station>Station;
    public List<Ticket>ticket;
    public List<User> users;
    private int ticketcounter;
    private Admin admin;
    private static Trainreservation instance;
    public UserInterface userInterface=UserInterface.getInstance();
    private AdminInterface adminInterface=AdminInterface.getInstance();
    LocalTime currentTime = LocalTime.now();
    double currentDoubleTime = currentTime.getHour() + (currentTime.getMinute() / 60.0);
    public Trainreservation(){
	Trains=new ArrayList<>();
        Station=new ArrayList<>();
	ticket=new ArrayList<>();
	users = new ArrayList<>();
        this.userInterface = new UserInterface();
	ticketcounter=100;
	admin=new Admin(this);
	User newUser = new User("suit", 12, "suiit", "suiit",this);
	users.add(newUser);
	Traininfo newtrain=new Traininfo(12842,"Coromandel Express", "Chennai Central","Howrah" );
        Trains.add(newtrain);
	Station chennaiCentral = new Station("Chennai Central", "1", 10.00, 10.30);
	Station vijayawada = new Station("Vijayawada", "2", 14.00, 14.30);
	Station visakhapatnam = new Station("Visakhapatnam", "3", 18.00, 18.30);
        newtrain.addStation(chennaiCentral);
        newtrain.addStation(vijayawada);
        newtrain.addStation(visakhapatnam);
    }
    
    public boolean loginAsAdmin(String username, String password) {
        if (admin.authenticate(username, password)) {
            System.out.println("Admin login successful");
                if (adminInterface != null) {
                    adminInterface.setVisible(true);
                } else {
                    System.out.println("UserInterface not initialized!");
                }
                return true;
       } else {
            System.out.println("Admin login failed");
            return false;
       }
    }
   public boolean loginAsUser(String username, String password) {
        for (User user : users) {
            if (user.userid.equals(username) && user.password.equals(password)) {
                System.out.println("User login successful");
                if (userInterface != null) {
                    System.out.print(user.name);
                    userInterface.setUser(user);
                    userInterface.setVisible(true);
                    userInterface.setTempUsername(user.name); // Pass username to UserInterface
                } else {
                    System.out.println("UserInterface not initialized!");
                }
                return true;
            }
        }
        System.out.println("User login failed");
        return false;
    }
    public void registerUser(String name,int age,String Userid,String Password) {
        User newUser=new User(name,age,Userid,Password,this);
        users.add(newUser);  
    }
    public static Trainreservation getInstance() {
        if (instance == null) {
            instance = new Trainreservation();
        }
        return instance;
    }
    public void addtrain(Traininfo newtrain) {
    	Trains.add(newtrain);
    }
    public void addtickets() {
        for (User uid : users) {
            uid.renewticket();
            List<Ticket> userTickets = uid.getticket();
        	for (Ticket userTicket : userTickets) {
        	    ticket.add(userTicket);
        	}
    	}	
    }

    public void remove(Traininfo trainToRemove) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   private class Admin {
	private final String adminPassword="su";
	private final String adminuserid="su";
	private Trainreservation trainreserv; 
	public Admin(Trainreservation trainreserv) {
            this.trainreserv = trainreserv;
    	}
	public boolean authenticate(String inputUserid,String inputPassword) {
	    return inputPassword.equals(adminPassword)&inputUserid.equals(adminuserid);
	}
	    	   
    }
    public class User{
        public String userid;
        String password;
        public String name;
        public List<Ticket>tickets;
        public int age;
        private Trainreservation trainreserv;
        public User(String name,int age,String userid,String password,Trainreservation trainreserv){
            this.userid=userid;
            this.password=password;
            this.name=name;
            this.age=age;
            this.trainreserv = trainreserv;
            this.tickets = new ArrayList<>();
        }
        public void renewticket(){
            for (Ticket userTicket : tickets) {
                if(userTicket.departuretime <= currentDoubleTime){
                    userTicket=null;
                }
            }
        }
        public List<Ticket> getticket(){
            return tickets;
        }
        public void BookTicket(Traininfo train,String from,String to){
            Ticket tick = new Ticket(name, age, train,from,to,train.getDepartureTime(to));	
            tickets.add(tick);
        }
    }
    
}