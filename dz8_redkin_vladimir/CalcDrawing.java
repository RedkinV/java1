package ru.geekbrains.java1.dz.dz8_redkin_vladimir;

import javax.swing.*;
import java.awt.*;

public class CalcDrawing extends JComponent {

    private int x=10;
    private int y=10;
    private int totalLength=170;
    private int height=30;
    private int fillForFirstSection=170;

    public void paintComponent(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(x,y,totalLength,height);

        g.setColor(Color.red);
        g.fillRect(x,y,fillForFirstSection,height);


    }

    public void adjustFill(double fillAmount) {
        double fill=totalLength*fillAmount;
        fillForFirstSection=(int)fill;
        repaint();
    }
}
