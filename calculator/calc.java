package calculator;

import javax.swing.SwingUtilities;

public class calc{

    public static void main(String args[]) { 
        SwingUtilities.invokeLater(new Runnable() { 
          public void run() { 
            new ui(); 
          } 
        });
    }
}
