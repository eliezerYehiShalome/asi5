package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class window extends JFrame {

    public window() {

        this.setLayout(null);
        this.setSize(700, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        pannel pannel=new pannel();
        pannel.setSize(700,400);
        add(pannel);

        this.setVisible(true);

    }


}