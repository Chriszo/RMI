/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmimovementmonitor;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author user
 */
public interface MovementSensor extends Remote{
    
    public void addMovementListener(MovementListener listener) throws RemoteException;
    
    public void removeMovementListener(MovementListener listener) throws RemoteException;
    
    public MovementEvent getMovementChange() throws RemoteException;
    
}
