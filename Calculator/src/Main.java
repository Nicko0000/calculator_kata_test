import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input : ");
        String input = scanner.nextLine();
        input = input.toUpperCase();

        calc(input);

    }
    public static String calc(String input){

        String[] string = input.split("");
        String string1 = Arrays.toString(string);

        int order = 0;
        String operation = "";
        String[] splitted = new String[2];


        for (int i = 1; i < string.length; i++) {
            if(string[i].equals("+")) {
                operation = "+";
                String[] firststr = string1.split("\\+");
                splitted = firststr;
            } else if (string[i].equals("-")) {
                operation = "-";
                String[] firststr = string1.split("\\-");
                splitted = firststr;
            } else if (string[i].equals("*")) {
                operation = "*";
                String[] firststr = string1.split("\\*");
                splitted = firststr;
            } else if (string[i].equals("/")) {
                operation = "/";
                String[] firststr = string1.split("\\/");
                splitted = firststr;
            }

        }
        
        String str1 = splitted[0];
        String str2 = splitted[1];

        if (str1 == null || str2 == null) {
            try {
                throw new IOException();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        
        String str11 = str1.replace(",","");
        String str111 = str11.replace(" ","");
        String first = str111.replace("[","");
        String str22 = str2.replace(",","");
        String str222 = str22.replace(" ","");
        String second = str222.replace("]","");
        String[] second1 = second.split("");

        String testout = first + operation + second;

        if (string.length > testout.length()) {
            try {
                throw new IOException();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        boolean firstenrom = true;
        boolean secondenrom = true;

        try {
            RomanNumbers.valueOf(first);
        }catch (IllegalArgumentException e) {
            firstenrom = false;
        }

        try {
            RomanNumbers.valueOf(second);
        }catch (IllegalArgumentException e) {
            secondenrom = false;
        }

        if((firstenrom == true && secondenrom == false) ||
                (firstenrom == false && secondenrom == true)) {
            try {
                throw new IOException();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if(firstenrom == false && secondenrom == false) {



            int firstint = Integer.parseInt(first);
            int secondint = Integer.parseInt(second);

            if (firstint > 10 || firstint < 1 ||
                        secondint > 10 || secondint < 1) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            switch (operation) {
                case "+" :
                    order = firstint + secondint;
                    break;
                case "-" :
                    order = firstint - secondint;
                    break;
                case "*" :
                    order = firstint * secondint;
                    break;
                case "/" :
                    order = firstint / secondint;
                    break;
            }



            String orderstr = Integer.toString(order);
            System.out.println("Output:\n"+orderstr);

        } else if (firstenrom == true && secondenrom == true) {

            RomanNumbers firstrome = RomanNumbers.valueOf(first);
            RomanNumbers secondrome = RomanNumbers.valueOf(second);

            String operand = firstrome.getValue();
            String operands = secondrome.getValue();

            int operand1 = Integer.parseInt(operand);
            int operand2 = Integer.parseInt(operands);

            if (operand1 > 10 || operand2 > 10 ||
                        operand1 < 1 || operand2 < 1) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            switch (operation) {
                case "+" :
                    order = operand1 + operand2;
                    break;
                case "-" :
                    if (operand2 > operand1){
                        try {
                                throw new IOException();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                    }else {
                        order = operand1 - operand2;
                    }break;
                case "*" :
                    order = operand1 * operand2;
                    break;
                case "/" :
                    order = operand1 / operand2;
                    break;
            }

            RomanNumbers resultt = RomanNumbers.fromString(Integer.toString(order));
            System.out.println("Output:\n"+resultt);

        }return input;
    }
}
