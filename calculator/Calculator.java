package calculator;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

public class Calculator{

    private List<String> hList;
    private int hSize;

    Calculator(){
      hList = new ArrayList<String>();
      hSize = 0;
    }

    public String[] parse(String str){
      char[] res = str.toCharArray();
      String[] result = {"", "", ""};
      for(int i=0; i< res.length; i++){
        if (res[i] >= '0' && res[i] <= '9' || res[i] == '.' || res[i] == 'E') {
          if(result[1] == ""){
            result[0] += res[i];
          }else{
            result[2] += res[i];
          }
        }else{
          if(i==0){
            result[0] += res[i];
          }else{
            result[1] += res[i];
          }
          
        }
      }
      return result; 
    }

    public void evaluate(String[] expr){
        
    }

    public void remember(String res){
      if(hSize >= 15){
        hList.remove(hSize-1);
        hSize--;
      }
      hList.add(0,res);
      hSize++;
    }

    public String getHValue(){
      String res = "";
      for(int i = 0; i < hSize; i++){
        res += hList.get(i);
      }
      return res;
    }


    public boolean checkDot(String number){
      int length = number.length();
      for(int i= 0; i< length; i++){
        if(number.charAt(i) == '.') return true;
      }
      return false;
    }

    public String calculate(String[] expr){
      double result = 0;
      //System.out.println();
      switch(expr[1]) {
        case "+":
          result = Double.parseDouble(expr[0]) + Double.parseDouble(expr[2]);
          break;
        case "-":
          result = Double.parseDouble(expr[0]) - Double.parseDouble(expr[2]);
          break;
        case "*":
          result = Double.parseDouble(expr[0]) * Double.parseDouble(expr[2]);
          break;
        case "/":
          result = Double.parseDouble(expr[0]) / Double.parseDouble(expr[2]);
          break;
        case "^":
          result = Math.pow(Double.parseDouble(expr[0]), Double.parseDouble(expr[2]));
          break;
      }
      remember(expr[0]+expr[1]+expr[2]+"="+result+"\n");
      return String.valueOf(result);
    }

    public String calculateRoot(String expr){
      double result = Math.sqrt(Double.parseDouble(expr));
      remember("\u221A"+"("+expr+")="+result+"\n");
      return String.valueOf(result);
    }

    public static void main(String args[]) { 
        SwingUtilities.invokeLater(new Runnable() { 
          public void run() { 
            new UI();
          } 
        });
    }
}
