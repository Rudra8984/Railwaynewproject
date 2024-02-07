import Gui.login;
import Railreservation.Trainreservation;
import java.util.Timer;
import java.util.TimerTask;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author irudr
 */
public class Railway{
    public static void main(String[] args) {
        Timer timer = new Timer();
	Trainreservation trainReservation = Trainreservation.getInstance();
	TimerTask task = new TimerTask() {
            int count = 0;
            @Override
	    public void run() {
                count++;
		trainReservation.addtickets();
	    }
	};
	timer.schedule(task, 0, 30000);
	login loginform = new login();
        loginform.setVisible(true);
            
    }		
}
