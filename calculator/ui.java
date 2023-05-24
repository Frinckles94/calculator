package calculator;


import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

public class UI implements ActionListener{

    private JFrame frame;
    private JPanel panel;
    private GridBagConstraints gbc;

    private JTextField textField;

    private JButton b[], bDot, bEq;
    private JButton bAdd, bMinus, bMultiply, bDivide, bPow, bSqrt, bClear, bDel;
    
    private Calculator calc;

    UI(){
        frame = new JFrame("Calculator");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setSize(400,600);

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;

        textField = new JTextField(10);


        b = new JButton[10];      
        for (int i = 0; i < 10; i++) {
            b[i] = new JButton(String.valueOf(i));
            b[i].addActionListener(this);
        }    


        bEq = new JButton("=");
        bDot = new JButton(".");
        bAdd = new JButton("+");
        bMinus = new JButton("-");
        bMultiply = new JButton("*");
        bDivide = new JButton("/");
        bPow = new JButton("^");
        bClear = new JButton("C");
        bDel = new JButton("DEL");
        bSqrt = new JButton("sqrt");

        
        // Adding text field
        gbc.gridheight = 1;
        gbc.gridwidth = 4; 
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(textField, gbc);


        gbc.gridheight = 1;
        gbc.gridwidth = 1;



        // Adding 0
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(b[0], gbc);
        // Adding 1..9
        for(int y=2; y<5; y++){
            for(int x=0; x<3; x++){
                gbc.gridx = x;
                gbc.gridy = y;
                int i = 13-3*y+x;
                panel.add(b[i], gbc);
            }
        }
        // Adding =
        gbc.gridx = 2;
        gbc.gridy = 5;
        panel.add(bEq, gbc);
        bEq.addActionListener(this);
        // Adding dot
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(bDot, gbc);
        bDot.addActionListener(this);
        //Adding C
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(bClear, gbc);
        bClear.addActionListener(this);
        //Adding DEL
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(bDel, gbc);
        bDel.addActionListener(this);
        //Adding +
        gbc.gridx = 3;
        gbc.gridy = 5;
        panel.add(bAdd, gbc);
        bAdd.addActionListener(this);
        //Adding -
        gbc.gridx = 3;
        gbc.gridy = 4;
        panel.add(bMinus, gbc);
        bMinus.addActionListener(this);
        //Adding *
        gbc.gridx = 3;
        gbc.gridy = 3;
        panel.add(bMultiply, gbc);
        bMultiply.addActionListener(this);
        //Adding Sqrt
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(bSqrt, gbc);
        bSqrt.addActionListener(this);
        //Adding /
        gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(bDivide, gbc);
        bDivide.addActionListener(this);
        //Adding ^
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(bPow, gbc);
        bPow.addActionListener(this);
        

        frame.add(panel);
        frame.setVisible(true);

        calc = new Calculator();
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        String[] expr;
        String command = ae.getActionCommand();
        System.out.println(ae.getActionCommand());
        //System.out.println(object);
        



        switch(command){
            case "C":
                textField.setText("");
                break;
            case "DEL":
                int length = textField.getText().length();
                textField.select(length-1, length);
                textField.replaceSelection("");
                break;
            case ".":
                expr = calc.parse(textField.getText());
                if(expr[1] == ""){
                    if(expr[0] == "") textField.replaceSelection("0"+command);
                    else if(!calc.checkDot(expr[0])) textField.replaceSelection(command);
                }else{
                    if(expr[2] == "") textField.replaceSelection("0"+command);
                    else if(!calc.checkDot(expr[2])) textField.replaceSelection(command);
                }
                break;
            case "+":
                expr = calc.parse(textField.getText());
                if(expr[1] == ""){
                    textField.replaceSelection(command);
                }else{

                }
                break;
            case "sqrt":
                expr = calc.parse(textField.getText());
                if(expr[1] == ""){

                }else{

                }
                break;
            case "=":
                break;
            case "0":
                expr = calc.parse(textField.getText());
                int length1 = expr[0].length();
                int length2 = expr[2].length();
                System.out.println(textField.getText().length());
                if(expr[1] == ""){
                    if(!(length1==1 && expr[0].charAt(0) == '0')) textField.replaceSelection(command);
                }else{
                    if(!(length2==1 && expr[2].charAt(0) == '0')) textField.replaceSelection(command);
                }
                break;
            default:
                textField.replaceSelection(command);
        }

    }
    
}
