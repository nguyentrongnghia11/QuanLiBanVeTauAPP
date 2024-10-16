/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;

/**
 *
 * @author THANH PHU
 */
public class CheckBox extends JCheckBox{
    public CheckBox(){
        setText("Hiển Thị Mật Khẩu");
        setFont(new Font("Tahoma", Font.PLAIN, 17));
        setBackground(new Color(0, 0, 0));
        setForeground(new Color(255, 255, 255));
        setBounds(60, 238, 147, 23);
    }

    
    
    
}
