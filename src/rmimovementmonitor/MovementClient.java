/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmimovementmonitor;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class MovementClient extends UnicastRemoteObject implements MovementListener{

    private List<MovementEvent> movementEvents;
    private boolean eventDetected;
    private MovementMonitor movementMonitor;
    
    public MovementClient() throws RemoteException{
        movementEvents = new ArrayList<>();
        eventDetected = false;
        movementMonitor = new MovementMonitor();
    }
    
    
    public void addMovementEvent(MovementEvent mvEvent){
        
        movementEvents.add(mvEvent);
    }
    
    @Override
    public void MovementEventDetected(MovementEvent mEvent) throws RemoteException {
       // System.out.println("Client : adding the movement event to buffer.:" + mEvent);
        movementEvents.add(mEvent);
        eventDetected = true;
        showMovementEvent(mEvent);
    }
    
    private void showMovementEvent(MovementEvent mvEvent){
        if(movementEvents.size() > 0){
            if(eventDetected){
               //movementMonitor = new MovementMonitor(mvEvent.getDirection());
               movementMonitor.setText(mvEvent.getDate());
               movementMonitor.updateDirection(mvEvent.getDirection());
               movementMonitor.showMovement(mvEvent.getDirection());
            }
        }
        eventDetected = false;
    }
    
    
    public static void main(String[] args) throws RemoteException, NotBoundException{
        
        int port = 1661;
        
        Registry registry = LocateRegistry.getRegistry(port);
        
        Remote service = registry.lookup("MovementSensor");
        
        MovementSensor moveSensor = (MovementSensor) service;
        
        
        
        MovementClient mvClient = new MovementClient();
        //MovementEvent mvEvent = moveSensor.getMovementChange();
        //mvClient.addMovementEvent(mvEvent);
//        mvClient.showMovementEvent();
        
        moveSensor.addMovementListener(mvClient);
        
        
        
        
        
        
        
    }
    
}
