package ru.geekbrains.java1.dz.dz8_redkin_vladimir;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class  CalcButtonFrame extends JFrame {
    private JLabel instructions=new JLabel("Введите 2 числа и нажмите Submit btn");
    private JTextField firstNumber=new JTextField(5);
    private JLabel plusSign=new JLabel("+");
    private JTextField secondNumber=new JTextField(5);
    private JLabel equalSign=new JLabel("=");
    private JTextField product=new JTextField(5);
    private JButton submit=new JButton("Submit");
    private JButton clear=new JButton("Clear");
    CalcDrawing drawing=new CalcDrawing();
    private JLabel changeColor=new JLabel("меняем цвет фона");
    private  JSlider slider=new JSlider();
    private JPanel panel=new JPanel();


    public CalcButtonFrame(){


        panel.add(instructions);
        panel.add(firstNumber);
        panel.add(plusSign);
        panel.add(secondNumber);
        panel.add(equalSign);
        panel.add(product);
        panel.add(submit);
        panel.add(clear);
        panel.add(drawing);
        drawing.setPreferredSize(new Dimension(200,60));
        panel.add(changeColor);
        panel.add(slider);


        ClearButtonListner cbl=new ClearButtonListner();
        clear.addActionListener(cbl);
        SubmitButtonListner sbl=new SubmitButtonListner();
        submit.addActionListener(sbl);
        //slider.addChangeListener(e->panel.setBackground(new Color(100+slider.getValue(),100+slider.getValue(),100+slider.getValue())));
        SliderListener sl=new SliderListener();
        slider.addChangeListener(sl);

        this.add(panel);
    }

    class SliderListener implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            int v=slider.getValue();
            panel.setBackground(new Color(100+v,100+v,100+v));
        }
    }


    class ClearButtonListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            firstNumber.setText("");
            secondNumber.setText("");
            product.setText("");
            Calculator empty=new Calculator();
            drawing.adjustFill(empty.determinePercentage());

        }
    }
    class SubmitButtonListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Integer first = null;
            first=first.parseInt(firstNumber.getText());
            Integer second=null;
            second=second.parseInt(secondNumber.getText());

            Calculator usr=new Calculator(first,second);
            product.setText(usr.getTotal()+"");
            drawing.adjustFill(usr.determinePercentage());

        }
    }
}
