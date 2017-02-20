/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmimovementmonitor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class MovementSensorImpl extends UnicastRemoteObject implements MovementSensor,Runnable{
    
    
    private CopyOnWriteArrayList<MovementListener> listenersList;
    private final String filePath = "path_to_png_file";
    private MovementEvent movementEvent;
    
    public MovementSensorImpl() throws RemoteException{
        listenersList = new CopyOnWriteArrayList<>();
        movementEvent = null;
    }
    
    
    @Override
    public void addMovementListener(MovementListener listener) throws RemoteException {
        System.out.println("Adding listener : " + listener);
        listenersList.add(listener);
    }

    @Override
    public void removeMovementListener(MovementListener listener) throws RemoteException {
        System.out.println("Removing listener : " + listener);
        listenersList.remove(listener);
    }

    @Override
    public MovementEvent getMovementChange() throws RemoteException {
        return movementEvent;
    }

    @Override
    public void run() {
        Random random = new Random();
        
        while(true){
            try{
                int seconds = random.nextInt(6);
                if(seconds < 3){
                    seconds = 3;
                }
                Thread.sleep(seconds * 1000);
                
            }
            catch(InterruptedException e){}
            
            
                Date date = new Date();
                int direction  = random.nextInt();
                if(direction < 0){
                    movementEvent = new MovementEvent(date, filePath, false);
                }
                else{
                    movementEvent = new MovementEvent(date, filePath, true);
                }
                notifyListeners();
            
            
        }
        
    }

    private void notifyListeners() {
        
        for(MovementListener ml:listenersList){
            try{
                ml.MovementEventDetected(movementEvent);
            } catch (RemoteException ex) {
                try {
                    this.removeMovementListener(ml);
                } catch (RemoteException ex1) {
                    Logger.getLogger(MovementSensorImpl.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
    }
    
}
