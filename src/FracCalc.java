//need to import to use throw statements
import java.util.InputMismatchException;
//needs a scanner imported for user input

import java.util.Scanner;

/**A class that has a produceAnswer method
 * @author rebeccasung
*/
public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
        Scanner input = new Scanner(System.in);

        // keeps asking user for input until user enters quit
        /**
         * @break stops the loop if the user enters "quit"
         */
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


    //@param fraction
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

        //using space delimiter to divide the input into 3 parts
        fract.useDelimiter(" ");
        String firstOperand = fract.next();
        String operator = fract.next();
        String secondOperand = fract.next();

        //scanners to further divide each operand into numerators and denominators
        Scanner secondOper = new Scanner(secondOperand);
        Scanner firstOper = new Scanner(firstOperand);


        //firstOperand conversions to regular or improper fractions

        // converting mixed fractions to improper fractions
        if (firstOperand.contains("_") && firstOperand.contains("/")) {
            firstOper.useDelimiter("[_/]");
            whole = firstOper.nextInt();
            numerator = firstOper.nextInt();
            denominator = firstOper.nextInt();
            // different equations for conversion depending on if the mixed fraction was negative or positive
            if(whole<0){
                firstOperand = (whole * denominator - numerator) +  "/" + denominator;
            }
            else
            {
                firstOperand = (whole * denominator + numerator) +  "/" + denominator;
            }
            //breaks up first operand if it is in this format: #/#
        } else if (firstOperand.contains("/")) {
            firstOper.useDelimiter("/");
            numerator = firstOper.nextInt();
            denominator = firstOper.nextInt();
            //for a whole number
        } else {
            whole = Integer.parseInt(firstOperand);
            numerator = 0;
            denominator = 1;
        }



        // secondOperand conversions to a regular fraction (same process as firstOperand)

        // converting mixed numbers to improper fractions
            if (secondOperand.contains("_") && secondOperand.contains("/")) {
                secondOper.useDelimiter("[_/]");
                whole = secondOper.nextInt();
                numerator = secondOper.nextInt();
                denominator = secondOper.nextInt();

                // different equations for conversion depending on if the mixed fraction was negative or positive
                if(whole<0){
                    secondOperand = (whole * denominator - numerator) +  "/" + denominator;
                }
                else
                {
                    secondOperand = (whole * denominator + numerator) +  "/" + denominator;
                }
            }
            //breaks up first operand if it is in this format: #/#
            else if (secondOperand.contains("/"))
            {
                secondOper.useDelimiter("/");
                numerator = secondOper.nextInt();
                denominator = secondOper.nextInt();
            }
            //for a whole number
            else
            {
                whole = Integer.parseInt(secondOperand);
                numerator = 0;
                denominator = 1;
            }


            // Scanners for numerators and denominators of fractions

        //Scanner for first operand
        Scanner first = new Scanner(firstOperand);
            // initializing firstOperand numerator and denominator
            int num1 = 0;
            int den1 = 0;

            // breaking up fractions
        if(firstOperand.contains("/")) {
            first.useDelimiter("/");
            num1 = first.nextInt();
            den1 = first.nextInt();
        }

        //breaking up whole numbers into #/1
        else {
            num1 = first.nextInt();
            den1 = 1;
        }

        //Scanner for second operand
        Scanner second = new Scanner(secondOperand);
        // initializing secondOperator numerator and denominator
        int num2 = 0;
        int den2 = 0;

        //breaking up fractions
        if (secondOperand.contains("/"))
        {
            second.useDelimiter("/");
            num2 = second.nextInt();
            den2 = second.nextInt();
        }

        //breking up whole numbers into #/1
        else
        {
            num2 = second.nextInt();
            den2 = 1;
        }

        // calculations

        // initializing variables for final numerator and denominator
        int numer = 0;
        int denom = 0;

        //addition
            if (operator.equals("+"))
            {
                numer = (num2*den1 + den2*num1);
                denom = (den2*den1);

                // if the answer is 0
                if(numer == 0)
                {
                    finalFraction = "0";
                }
                // if the answer is a regular fraction
                else if (Math.abs(numer) < denom)
                {
                    // keeps simplifying until the fraction is in the simplest form
                        for (int counter = 2; counter < denom; counter++)
                        {
                            while (numer % counter == 0 && denom % counter == 0)
                            {
                                numer /= counter;
                                denom /= counter;
                            }
                        }
                        finalFraction = numer + "/" + denom;
                }
                // if the answer can be simplified to a whole number
                else if (numer % denom == 0)
                {
                    finalFraction = (numer/denom) + "";
                }
                // if the answer is a mixed fraction
                else
                {
                    // keeps simplifying until the fraction is in the simplest form
                    for (int counter = 2; counter < denom; counter++)
                    {
                        while (numer % counter == 0 && denom % counter == 0)
                        {
                            numer /= counter;
                            denom /= counter;
                        }
                    }
                    finalFraction = (numer/denom) + "_" + Math.abs(numer % denom) + "/" + Math.abs(denom);
                }

            }

            // subtraction
            else if (operator.equals("-"))
            {
                numer = (num1*den2 - den1*num2);
                denom = (den2 * den1);

                // if the answer is 0
                if(numer == 0)
                {
                    finalFraction = "0";
                }
                // if the answer is a regular fraction
                else if ( Math.abs(numer) < denom)
                {
                    // keeps simplifying until the fraction is in the simplest form
                    for (int counter = 2; counter < denom; counter++)
                    {
                        while (numer % counter == 0 && denom % counter == 0)
                        {
                            numer /= counter;
                            denom /= counter;
                        }
                    }
                        finalFraction = numer + "/" + denom;
                }
                // if the answer can be simplified to a whole number
                else if (numer % denom == 0)
                {
                    finalFraction = (numer/denom) + "";
                }
                // if the answer is a mixed fraction
                else
                {
                    // keeps simplifying until the fraction is in the simplest form
                    for (int counter = 2; counter < denom; counter++)
                    {
                        while (numer % counter == 0 && denom % counter == 0)
                        {
                            numer /= counter;
                            denom /= counter;
                        }
                    }
                    finalFraction = (numer / denom) + "_" + (Math.abs(numer % denom)) + "/" + Math.abs(denom);

                }
            }

            //multiplication
            else if(operator.equals("*"))
            {
                numer = (num1*num2);
                denom = (den1*den2);

                // if the answer is 0
                if(numer == 0)
                {
                    finalFraction = "0";
                }
                // if the answer is a regular fraction
                else if (Math.abs(numer) < denom)
                {
                    // keeps simplifying until the fraction is in the simplest form
                    for (int counter = 2; counter < denom; counter++)
                    {
                        while (numer % counter == 0 && denom % counter == 0)
                        {
                            numer /= counter;
                            denom /= counter;
                        }
                    }
                    finalFraction = numer + "/" + denom;
                }
                // if the answer can be simplified to a whole number
                else if (numer % denom == 0)
                {
                    finalFraction = (numer/denom) + "";
                }
                // if the answer is a mixed fraction
                else
                {
                    // keeps simplifying until the fraction is in the simplest form
                    for (int counter = 2; counter < denom; counter++)
                    {
                        while (numer % counter == 0 && denom % counter == 0)
                        {
                            numer /= counter;
                            denom /= counter;
                        }
                    }
                    finalFraction = (numer/denom) + "_" + (Math.abs(numer % denom)) + "/" + Math.abs(denom);
                }
            }

            // division
            else if(operator.equals("/"))
            {
                numer = (num1*den2);
                denom = (den1*num2);

                // if the answer is 0
                if(numer == 0)
                {
                    finalFraction = "0";
                }
                // if the answer is a regular fraction
                else if (Math.abs(numer) < Math.abs(denom))
                {
                    // keeps simplifying until the fraction is in the simplest form
                    for (int counter = 2; counter < Math.abs(denom); counter++)
                    {
                        while (numer % counter == 0 && denom % counter == 0)
                        {
                            numer /= counter;
                            denom /= counter;
                        }
                    }
                    if (denom < 0 && numer > 0)
                    {
                        denom *= -1;
                        numer *= -1;
                    }
                    finalFraction = numer + "/" + denom;
                }
                // if the answer can be simplified to a whole number
                else if (numer % denom == 0)
                {
                    finalFraction = (numer/denom) + "";
                }
                // if the answer is a mixed fraction
                else
                {
                    // keeps simplifying until the fraction is in the simplest form
                    for (int counter = 2; counter < Math.abs(denom); counter++)
                    {
                        while (numer % counter == 0 && denom % counter == 0)
                        {
                            numer /= counter;
                            denom /= counter;
                        }
                    }
                    finalFraction = (numer/denom) + "_" + (Math.abs(numer % denom)) + "/" + Math.abs(denom);
                }

            }

        /**
         * @throws InputMismatchException if user does not input a valid operator
         */
            else
            {
                throw new InputMismatchException("Not a valid operator!");
            }

        /**
         * @return returns the simplified final answer
         */
        return finalFraction;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
