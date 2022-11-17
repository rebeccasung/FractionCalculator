import java.util.InputMismatchException;
import java.util.Scanner;
public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
        Scanner input = new Scanner(System.in);

        // keeps asking user for input until user enters quit
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
        // scanner to break up the user input into 3 parts (1st operand, operator, 2nd operand)
        Scanner fract = new Scanner(fraction);


        // initializing variables used later on
        int whole = 0;
        int numerator = 0;
        int denominator = 1;
        String finalFraction = "";

        //using space delimiter to divide the input
        fract.useDelimiter(" ");
        String firstOperand = fract.next();
        String operator = fract.next();
        String secondOperand = fract.next();

        //scanners to further divide each operand into numerators and denominators
        Scanner secondOper = new Scanner(secondOperand);
        Scanner firstOper = new Scanner(firstOperand);

        //firstOperand conversions to regular or improper fractions
        if (firstOperand.contains("_") && firstOperand.contains("/")) {
            firstOper.useDelimiter("[_/]");
            whole = firstOper.nextInt();
            numerator = firstOper.nextInt();
            denominator = firstOper.nextInt();
            // converting mixed fractions to improper fractions
            if(whole<0){
                firstOperand = (whole * denominator - numerator) +  "/" + denominator;
            }
            else
            {
                firstOperand = (whole * denominator + numerator) +  "/" + denominator;
            }
        } else if (firstOperand.contains("/")) {
            firstOper.useDelimiter("/");
            numerator = firstOper.nextInt();
            denominator = firstOper.nextInt();
        } else {
            whole = Integer.parseInt(firstOperand);
            numerator = 0;
            denominator = 1;
        }



        // secondOperand conversions to a regular fraction
            if (secondOperand.contains("_") && secondOperand.contains("/")) {
                secondOper.useDelimiter("[_/]");
                whole = secondOper.nextInt();
                numerator = secondOper.nextInt();
                denominator = secondOper.nextInt();

                // converting mixed numbers to improper fractions
                if(whole<0){
                    secondOperand = (whole * denominator - numerator) +  "/" + denominator;
                }
                else
                {
                    secondOperand = (whole * denominator + numerator) +  "/" + denominator;
                }
            } else if (secondOperand.contains("/")) {
                secondOper.useDelimiter("/");
                numerator = secondOper.nextInt();
                denominator = secondOper.nextInt();
            } else {
                whole = Integer.parseInt(secondOperand);
                numerator = 0;
                denominator = 1;
            }


            // Scanners for numerators of denominators of fractions

        //Scanner for first operand
        Scanner first = new Scanner(firstOperand);
            int num1 = 0;
            int den1 = 0;

            //fractions
        if(firstOperand.contains("/")) {
            first.useDelimiter("/");
            num1 = first.nextInt();
            den1 = first.nextInt();
        }

        //whole numbers
        else {
            num1 = first.nextInt();
            den1 = 1;
        }

        //Scanner for second operand
        Scanner second = new Scanner(secondOperand);
        int num2 = 0;
        int den2 = 0;

        //fractions
        if (secondOperand.contains("/"))
        {
            second.useDelimiter("/");
            num2 = second.nextInt();
            den2 = second.nextInt();
        }

        //whole numbers
        else
        {
            num2 = second.nextInt();
            den2 = 1;
        }

        // calculations

            //addition
            if (operator.equals("+"))
            {
                finalFraction = (num2*den1 + den2*num1) + "/" + (den2*den1);
            }

            // subtraction
            else if (operator.equals("-"))
            {
                finalFraction = -(num2*den1 - den2*num1) + "/" + (den2*den1);
            }

            //multiplication
            else if(operator.equals("*"))
            {
                finalFraction = (num1*num2) + "/" + (den1*den2);
            }

            // division
            else if(operator.equals("/"))
            {
                finalFraction = (num1*den2) + "/" + (den1*num2);
            }

            //@throws InputMismatchException if user does not input a valid operator
            else
            {
                throw new InputMismatchException("Not a valid operator!");
            }


        return finalFraction;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
