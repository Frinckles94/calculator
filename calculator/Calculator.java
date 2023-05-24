package calculator;

import javax.swing.SwingUtilities;

public class Calculator{

    public String[] parse(String str){
      char[] res = str.toCharArray();
      String[] result = {"", "", ""};
      for(int i=0; i< res.length; i++){
        if (res[i] >= '0' && res[i] <= '9' || res[i] == '.') {
          if(result[1] == ""){
            result[0] += res[i];
          }else{
            result[2] += res[i];
          }
        }else{
          result[1] += res[i];
        }
      }
      return result; 
    }

    public boolean checkDot(String number){
      int length = number.length();
      for(int i= 0; i< length; i++){
        if(number.charAt(i) == '.') return true;
      }
      return false;
    }

    public void calculate(){
      
    }



    public static void main(String args[]) { 
        SwingUtilities.invokeLater(new Runnable() { 
          public void run() { 
            new UI();
          } 
        });
    }
}
