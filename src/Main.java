import java.io.*;
import java.util.ArrayList;
import number_operation.*;

/**
 * Main class.
 */
public class Main {
    /**
     * Start point of the program.
     * Inputting numbers and calling methods of NumbersOperation class.
     * @param args command lines parameters
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String num;
            ArrayList<String> numbers = new ArrayList<>();

            while (!(num = br.readLine()).equals("q")) {
                try {
                    Integer.parseInt(num);
                    numbers.add(num);
                } catch (NumberFormatException ex) {
                    System.out.println("Not a number. try again: ");
                }
            }
            
            if (numbers.isEmpty()) {
                System.out.println("Numbers not entered. Exit");
            } else {
                NumbersOperations.findLongest(numbers);
                NumbersOperations.findShortest(numbers);
                NumbersOperations.findLessThanAverageLength(numbers);
                NumbersOperations.findMinDifferenceDigits(numbers);
                NumbersOperations.findOnlyEvenDigits(numbers);
                NumbersOperations.findEqualEvenAndOddDigits(numbers);
                NumbersOperations.findUprising(numbers);
                NumbersOperations.findOnlyDifferenceDigits(numbers);
                NumbersOperations.findPalindrome(numbers);
                NumbersOperations.sortByLength(numbers);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}