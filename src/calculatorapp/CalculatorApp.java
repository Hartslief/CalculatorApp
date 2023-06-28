
package calculatorapp;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class CalculatorApp {
    ArrayList <String> operation = new ArrayList <String> ();
    ArrayList <Integer> firstNumEntered = new ArrayList <Integer> ();
    ArrayList <Integer> secondNumEntered = new ArrayList <Integer> ();
    ArrayList <Integer> sum = new ArrayList <Integer> ();
    
    public int index = 0;
    public int output = 0;
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to my calculator app!");
        run();        
    }
    
    public static void run() {
        CalculatorApp run = new CalculatorApp();
        run.mainMenu();
        
    }
    
    public void simpleCalc() {
        getFirstNum();
        getOperation();
        getSecondNum();
        calculatorOutput();
    }
    
    public void mainMenu() {
        int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter what action you would like to perform: \n"
                                                                                        + "1. Do a simple calculation\n"
                                                                                        + "2. Clear calculator\n"
                                                                                        + "3. See output"));
        
        switch(choice) {
            case 1:
                simpleCalc();
                break;
            case 2:
                output = 0;
                break;
            case 3:
                JOptionPane.showMessageDialog(null, sum.get(0));
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid input please try again.");
                mainMenu();
        }
        
    }
    
    
    public void getFirstNum() {
        String[] firstNum = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        int selectedNumOne = JOptionPane.showOptionDialog(null, "Select a number: ", "Calculator",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, firstNum, firstNum[0]);
        firstNumEntered.add(index, selectedNumOne);
        
        if(firstNumEntered.get(index) < 0) {
            JOptionPane.showMessageDialog(null, "Thank you for using my calculator app! \n\nBye!");
            System.exit(0);
        }
    }
    
    public void getOperation() {
        String[] options = { "+", "-", "*", "/" };
        int selectedOption = JOptionPane.showOptionDialog(null, "Select an operation:", "Calculator",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        String selectedOperation = "";
        switch(selectedOption) {
            case 0:
                selectedOperation = "+";
                break;
            case 1:
                selectedOperation = "-";
                break;
            case 2:
                selectedOperation = "*";
                break;
            case 3:
                selectedOperation = "/";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid input please try again.");
                getOperation();
        }
        operation.add(index, selectedOperation);
    }
    
    
    public void getSecondNum() {
        String[] secondNum = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        int selectedNumTwo = JOptionPane.showOptionDialog(null, "Select a number: ", "Calculator",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, secondNum, secondNum[0]);
        secondNumEntered.add(index, selectedNumTwo);
        if(secondNumEntered.get(index) < 0) {
            JOptionPane.showMessageDialog(null, "Thank you for using my calculator app! \n\nBye!");
            System.exit(0);
        }
    }
    
    public void calculatorOutput() {
        
        switch(operation.get(index)) {
            case "+":
                output = firstNumEntered.get(index) + secondNumEntered.get(index);
                break;
            case "-":
                output = firstNumEntered.get(index) - secondNumEntered.get(index);
                break;
            case "*":
                output = firstNumEntered.get(index) * secondNumEntered.get(index);
                break;
            case "/":
                output = firstNumEntered.get(index) / secondNumEntered.get(index);
                break;        
        }
        JOptionPane.showMessageDialog(null, firstNumEntered.get(index) + " " + operation.get(index) + " " + secondNumEntered.get(index) + " = \n\n" + output);
        sum.add(index, output);
        index++;
        run();
    }
}
