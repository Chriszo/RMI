/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmimovementmonitor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author user
 */
public class RMIMovementMonitor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        // TODO code application logic here
        
        int port = 1661;
        //String serviceUrl = "rmi//localhost:" + port + "/MovementSensor";
        
        MovementSensorImpl moventSensorServer = new MovementSensorImpl();
        
        Registry registry = LocateRegistry.createRegistry(port);
        
        registry.rebind("MovementSensor", moventSensorServer);
        
        Thread thread = new Thread(moventSensorServer);
        thread.start();    
        
    }
    
}
