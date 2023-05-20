package calculator;


import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

public class ui implements ActionListener{

    private JFrame frame;
    private JPanel panel, subpanel1,subpanel2;
    private GridBagConstraints gbc;

    private JTextField textField;

    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bDot, bEq;
    private JButton bAdd, bMinus, bMultiply, bDivide; 

    ui(){
        frame = new JFrame("Calculator");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setSize(300,450);

        gbc = new GridBagConstraints();
        gbc.weightx = 0;
        gbc.weighty = 0;

        textField = new JTextField(11);


        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        bEq = new JButton("=");
        bDot = new JButton(".");
        
        bAdd = new JButton("+");
        bMinus = new JButton("-");
        bMultiply = new JButton("*");
        
        // Adding text field
        gbc.gridheight = 1;
        gbc.gridwidth = 4; // acting weird in combination with textField width
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(textField, gbc);

        // Adding 9 
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(b9, gbc);
        // Adding 8
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(b8, gbc);
        // Adding 7
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(b7, gbc);
        // Adding 6
        gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(b6, gbc);
        // Adding 5
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(b5, gbc);
        // Adding 4
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(b4, gbc);
        // Adding 3
        gbc.gridx = 3;
        gbc.gridy = 3;
        panel.add(b3, gbc);
        // Adding 2
        gbc.gridx = 2;
        gbc.gridy = 3;
        panel.add(b2, gbc);
        // Adding 1
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(b1, gbc);
        // Adding 0
        gbc.gridx = 2;
        gbc.gridy = 4;
        panel.add(b0, gbc);
        // Adding =
        gbc.gridx = 3;
        gbc.gridy = 4;
        panel.add(bEq, gbc);
        // Adding dot
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(bDot, gbc);

        frame.add(panel);
        


        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
