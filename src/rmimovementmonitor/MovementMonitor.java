/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmimovementmonitor;

import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author user
 */
public class MovementMonitor extends JFrame{
    
    private JPanel jpanel1;
    //JPanel jpanel2;
    private JScrollPane jscroll;
    private static JTextArea timeArea;
    
    private JLabel movementLabel;
    
    private StringBuilder sb;
    
    
    boolean direction;
    
    public MovementMonitor(){
        
//        this.direction = direction;
        //this.setSize(600, 800);
        
        sb = new StringBuilder();
        
        jpanel1 = new JPanel(new BorderLayout());
        jpanel1.setSize(600, 800);
        
        timeArea = new JTextArea(10, 50);
        timeArea.setSize(jpanel1.getWidth(),300);
        timeArea.setEditable(false);
        
        jscroll = new JScrollPane(timeArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        jscroll.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
//            @Override
//            public void adjustmentValueChanged(AdjustmentEvent e) {
//                e.getAdjustable().setValue(e.getAdjustable().getValue());
//            }
//        });
        jscroll.setSize(jpanel1.getWidth(),300);

        
        //this.updateDirection(direction);
//        movementLabel = new JLabel(new ImageIcon("C:\\Users\\user\\Desktop\\ΕΑΠ\\ΣΔΥ50\\Εργασίες\\ΓΕ3\\movement\\movement2.png"));
//        movementLabel.setSize(jpanel1.getWidth(), jpanel1.getHeight()/2);
//        
//        jpanel1.add(timeArea,BorderLayout.NORTH);
        jpanel1.add(jscroll,BorderLayout.NORTH);
        //jpanel1.add(movementLabel,BorderLayout.SOUTH);
        
        
    }
    
    public void setText(Date date){
        String dateText = date.toString() + "\n";
        sb.append(dateText);
        timeArea.append(dateText);
        timeArea.setCaretPosition((int) JTextArea.BOTTOM_ALIGNMENT);
//        timeArea.setCaretPosition(timeArea.getCaretPosition() + sb.toString().length());
    }
    
    public void updateDirection(boolean direction){
        System.out.println(direction);
       ImageIcon img = null;
       if(movementLabel == null){
           movementLabel = new JLabel();
       }
        if(direction){
            img = new ImageIcon("C:\\Users\\user\\Desktop\\ΕΑΠ\\ΣΔΥ50\\Εργασίες\\ΓΕ3\\movement\\movement1.png");
            img.getImage().flush();
            movementLabel.setIcon(img);
//            movementLabel = new JLabel(new ImageIcon("C:\\Users\\user\\Desktop\\ΕΑΠ\\ΣΔΥ50\\Εργασίες\\ΓΕ3\\movement\\movement1.png"));
        }
        else{
            img = new ImageIcon("C:\\Users\\user\\Desktop\\ΕΑΠ\\ΣΔΥ50\\Εργασίες\\ΓΕ3\\movement\\movement2.png");
//            movementLabel = new JLabel(new ImageIcon("C:\\Users\\user\\Desktop\\ΕΑΠ\\ΣΔΥ50\\Εργασίες\\ΓΕ3\\movement\\movement2.png"));
        }
        img.getImage().flush();
        movementLabel.setIcon(img);
//          
    }
    
    
    public void showMovement(boolean direction){
        
        this.direction = direction;
        this.setSize(600, 500);
        
        
        //jpanel1 = new JPanel(new BorderLayout());
        jpanel1.setSize(600, 800);
        
        //timeArea = new JTextArea();
        timeArea.setSize(jpanel1.getWidth(),300);
        jscroll.setSize(timeArea.getWidth(), timeArea.getHeight());
        
        this.updateDirection(direction);
//        movementLabel = new JLabel(new ImageIcon("C:\\Users\\user\\Desktop\\ΕΑΠ\\ΣΔΥ50\\Εργασίες\\ΓΕ3\\movement\\movement2.png"));
        movementLabel.setSize(jpanel1.getWidth(), 300);
//        
//        jpanel1.add(timeArea,BorderLayout.NORTH);
        jpanel1.add(jscroll,BorderLayout.NORTH);
        jpanel1.add(movementLabel,BorderLayout.CENTER);
        
        this.add(jpanel1);
        jpanel1.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
    
}
