import java.util.Scanner;
public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
        Scanner input = new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter a fractional expression (use an underscore as a space for mixed fractions):");
            String fraction = input.nextLine();
            System.out.println(produceAnswer(fraction));
            if(fraction.equals("quit"))
            {
                break;
            }
        }


    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"



    public static String produceAnswer(String fraction)
    { 
        // TODO: Implement this function to produce the solution to the input
        Scanner fract = new Scanner(fraction);

        String whole = "";
        String numerator = "";
        String denominator = "";

        fract.useDelimiter(" ");
        String firstOperand = fract.next();
        String operator = fract.next();
        String secondOperand = fract.next();
        Scanner secondOper = new Scanner(secondOperand);


            if (secondOperand.contains("_") && secondOperand.contains("/")) {
                secondOper.useDelimiter("[_/]");
                whole = secondOper.next();
                numerator = secondOper.next();
                denominator = secondOper.next();

            } else if (secondOperand.contains("/")) {
                secondOper.useDelimiter("/");
                whole = "0";
                numerator = secondOper.next();
                denominator = secondOper.next();
            } else {
                whole = secondOperand;
                numerator = "0";
                denominator = "1";
            }
        return "whole:" + whole + " " + "numerator:" + numerator + " " + "denominator:" + denominator;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
