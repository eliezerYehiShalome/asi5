package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class pannel extends JPanel {



    public pannel(){




        this.setLayout(null);
        int y = 100;
        int x = 50;
        int textFieldH = 15;
        int textFieldW = 80;


        double w;
        String na;
        JLabel heightTitle = new JLabel();
        JLabel bodyFramTitle = new JLabel();
        JLabel bmiText = new JLabel();
        JLabel idealWeight  = new JLabel();

        JButton buttonToSentData = new JButton();

        JTextField[] textField = new JTextField[5];
        JLabel[] thing = new JLabel[5];
        String[] data = {"משקל", "שם", "שם משפחה", "גיל"};
        String[] dataInput = new String[7];
        for (int i = 0; i < textField.length - 1; i++) {
            thing[i] = new JLabel();
            thing[i].setText(data[i] + ":");

            thing[i].setBounds(x + textFieldW + 20, y, textFieldW, textFieldH);
            textField[i] = new JTextField(); // Initialize each element in the array
            textField[i].setBounds(x, y, textFieldW, textFieldH);

            add(textField[i]);
            add(thing[i]);
            y += 50;

        }
        System.out.println(textField[0].getText());


        String[] options = {"זכר", "נקבה"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(x, 20, 150, 25);
        dataInput[6] = (String) comboBox.getSelectedItem();
        add(comboBox);

        bodyFramTitle.setText("body frame");
        bodyFramTitle.setBounds(x + 160, 55, 150, 25);

        String[] bodyFram = {"small", "medium", "large"};
        JComboBox<String> bodyFram1 = new JComboBox<>(bodyFram);
        bodyFram1.setBounds(x, 55, 150, 25);
        double slimness=0;
        if (bodyFram1.getSelectedItem().equals("small")){slimness = 0.9;}
        if(bodyFram1.getSelectedItem().equals("medium")){slimness = 1;}
        if(bodyFram1.getSelectedItem().equals("large")){ slimness = 1.1;}
        add(bodyFram1);
        add(bodyFramTitle);

        JSlider slider = new JSlider(JSlider.VERTICAL, 0, 200, 0);
        slider.setBounds(300, 100, 50, 200);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(20);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        add(slider);


        heightTitle.setText("0");
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                heightTitle.setText( value+"");

            }
        });
        Font font =new Font("eli",Font.BOLD,20);

        Font fontH =new Font("eli",Font.BOLD,20);
        heightTitle.setFont(fontH);
        heightTitle.setBounds(300, 70, 50, 30);
        add(heightTitle);

        buttonToSentData =new JButton();
        buttonToSentData.setText("חשב");
        buttonToSentData.setFont(font);
        buttonToSentData.setBounds(x,300,80,30);
        double finalSlimness = slimness;

        bmiText.setText("BMI");
        idealWeight.setText("ideal weight");
        buttonToSentData.addActionListener((e)-> {
            int hig = 0;
            int ag = 0;
            int c = 0;

            int age= Integer.parseInt(textField[3].getText());

            hig+=slider.getValue();
            ag+=age;
            c+=finalSlimness;

                    System.out.println(slider.getValue());
                    dataInput[0] = textField[0].getText();
                    dataInput[1] = textField[1].getText();
                    dataInput[2] = textField[2].getText();


                   if (hig!=0||ag!=0|| c!=0)
                       idealWeight.setText("ideal weight: "+idealWeight(slider.getValue(),age, finalSlimness));
                   else
                      JOptionPane.showMessageDialog(this, "אנה מלא את השדות המבוקשים");



            bmiText.setText("BMI: "+BMI(slider.getValue(),dataInput[0]));


        });
        idealWeight.setBounds(370,70,300,50);
        idealWeight.setFont(font);
        add(idealWeight);

        bmiText.setBounds(370,20,300,50);
        bmiText.setFont(font);
        add(bmiText);
        add(buttonToSentData);
        this.setVisible(true);

    }
    public static double bmi;
    public String BMI(int h, String w){
        double hi= (double) h /100;
        double we = 0;
        we=Integer.valueOf(w);
        this.bmi = we /(hi* hi);
        if (bmi<=15){return (int)bmi+":  Anorexic";}
        if (bmi>15&&bmi<18.5){return (int)bmi+":  Underweight ";}
        if (bmi>18.5&&bmi<24.9){return (int)bmi+":  Normal";}
        if (bmi>25&&bmi<29.9){return (int) bmi+":  Overweight ";}
        if (bmi>30&&bmi<35){return (int)bmi+":  Obese";}
        if (bmi>35){return (int)bmi+":  Extreme Obese";}
        return null;
    }



    public double idealWeight(int height,int age ,double slimness){
        double idealWeight = (height - 100 + (age / 10)) * 0.9 * slimness;

        return idealWeight;

    }

}
