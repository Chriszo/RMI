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
interface MovementListener extends Remote {
    
    public void MovementEventDetected(MovementEvent mEvent) throws RemoteException;
    
}
