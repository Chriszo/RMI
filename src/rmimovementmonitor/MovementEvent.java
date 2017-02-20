/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmimovementmonitor;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author user
 */
public class MovementEvent implements Serializable{
    
    private Date movementEventDate;
    private String iconFileName;
    private boolean direction;
    
    
    public MovementEvent(Date date,String icon,boolean direction){
        movementEventDate = date;
        iconFileName = icon;
        this.direction = direction;
    }
    
    public MovementEvent getMovementEvent(){
        return this;
    }
    
    
    public Date getDate(){
        return movementEventDate;
    }
    
    public String getIconPath(){
        return this.iconFileName;
    }
    
    public boolean getDirection(){
        return this.direction;
    }
    
}
