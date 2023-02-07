package number_operation;
import java.util.ArrayList;

/**
 * Operations with ArrayList witch contains numbers in string type
 */
public class NumbersOperations {
    /**
     * Searches and prints longest number in ArrayList.
     * @param numbers ArrayList of string type.
     */
    public static void findLongest(ArrayList<String> numbers) {
        String longestNum = null;
        int numLength = -1;

        for (String num : numbers) {
            if (numLength < num.length()) {
                longestNum = num;
                numLength = num.length();
            }
        }

        if (longestNum != null) {
            System.out.println("Longest number: " + longestNum + " - " + longestNum.length() + "-digit number");
        }
    }

    /**
     * Searches and prints shortest number in ArrayList.
     * @param numbers ArrayList of string type.
     */
    public static void findShortest(ArrayList<String> numbers) {
        String longestNum = null;
        int numLength = Integer.MAX_VALUE;

        for (String num : numbers) {
            if (numLength > num.length()) {
                longestNum = num;
                numLength = num.length();
            }
        }

        if (longestNum != null) {
            System.out.println("Shortest number: " + longestNum + " - " + longestNum.length() + "-digit number");
        }
    }

    /**
     * Calls private method quickSort and prints ArrayList of string
     * @param numbers ArrayList of string type.
     */
    public static void sortByLength(ArrayList<String> numbers) {
        int low = 0;
        int high = numbers.size() - 1;

        quickSort(numbers, low, high);

        System.out.println("Sorted numbers: ");
        for (String num : numbers) {
            System.out.println(num);
        }
    }

    /**
     * sorts ArrayList of string by string length.
     * @param numbers ArrayList of string type.
     * @param low left bound of ArrayList's part
     * @param high right bound of ArrayList's part
     */
    private static void quickSort(ArrayList<String> numbers, int low, int high) {
        if (numbers.size() == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int pivot = numbers.get(middle).length();
        int i = low;
        int j = high;

        while (i <= j) {
            while (numbers.get(i).length() < pivot) {
                i++;
            }

            while (numbers.get(j).length() > pivot) {
                j--;
            }

            if (i <= j) {
                String temp = numbers.get(i);
                numbers.set(i, numbers.get(j));
                numbers.set(j, temp);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(numbers, low, j);
        }

        if (high > i) {
            quickSort(numbers, i, high);
        }
    }

    /**
     * Searches and prints number with less than average length.
     * @param numbers  ArrayList of string type.
     */
    public static void findLessThanAverageLength(ArrayList<String> numbers) {
        int average = 0;

        for (String number : numbers) {
            average += number.length();
        }

        average /= numbers.size();

        for (String num : numbers) {
            if (num.length() < average) {
                System.out.println("Number with less than average length: "
                        + num + " - " + num.length() + "-digit number");
            }
        }
    }

    /**
     * Searches and prints number with minimal digit differences.
     * @param numbers  ArrayList of string type.
     */
    public static void findMinDifferenceDigits(ArrayList<String> numbers) {
        int minDifDigCount = Integer.MAX_VALUE;
        String minDifNum = null;

        int difCount;
        char digit;
        for (String num : numbers) {
            digit = num.charAt(0);
            difCount = 0;
            for (int i = 1; i < num.length(); i++) {
                if (!(digit == num.charAt(i))) {
                    difCount++;
                }
            }

            if (difCount < minDifDigCount) {
                minDifNum = num;
                minDifDigCount = difCount;
            }
        }

        System.out.println("Number with minimal digit differences: " + minDifNum);
    }

    /**
     * Searches and prints amount of numbers with only even digits.
     * @param numbers ArrayList of string type.
     */
    public static void findOnlyEvenDigits(ArrayList<String> numbers) {
        int evenNumCounter = 0;

        boolean evenStatus;
        for (String num : numbers) {
            evenStatus = true;
            for (int i = 0; i < num.length() && evenStatus; i++) {
                switch (num.charAt(i)) {
                    case '0':
                    case '2':
                    case '4':
                    case '6':
                    case '8':
                        break;
                    default:
                        evenStatus = false;
                        break;
                }
            }

            if (evenStatus) {
                evenNumCounter++;
            }
        }

        System.out.println("Amount of numbers with only even digits: " + evenNumCounter);
    }

    /**
     * Searches and prints amount of numbers with equal number of even and odd.
     * @param numbers ArrayList of string type.
     */
    public static void findEqualEvenAndOddDigits(ArrayList<String> numbers) {
        int numCounter = 0;

        int even;
        int odd;
        for (String num : numbers) {
            even = 0;
            odd = 0;

            for (int i = 0; i < num.length(); i++) {
                switch (num.charAt(i)) {
                    case '0':
                    case '2':
                    case '4':
                    case '6':
                    case '8':
                        even++;
                        break;
                    default:
                        odd++;
                        break;
                }
            }

            if (even == odd) {
                numCounter++;
            }
        }

        System.out.println("Amount of numbers with equal number of even and odd: " + numCounter);
    }

    /**
     * Searches and prints the first num with only uprising digits.
     * @param numbers ArrayList of string type.
     */
    public static void findUprising(ArrayList<String> numbers) {
        boolean uprisingStatus;
        char prevDigit;
        for (String num : numbers) {
            uprisingStatus = true;
            prevDigit = num.charAt(num.length() - 1);
            for (int i = num.length() - 2; i > 0 && uprisingStatus; i--) {
                if (prevDigit > num.charAt(i)) {
                    uprisingStatus = false;
                }

                prevDigit = num.charAt(i);
            }

            if (uprisingStatus) {
                System.out.println("First num with only uprising digits: " + num);
                return;
            }
        }

        System.out.println("Number not found");
    }

    /**
     * Searches and prints the first number with all difference digits.
     * @param numbers ArrayList of string type.
     */
    public static void findOnlyDifferenceDigits(ArrayList<String> numbers) {
        boolean differenceStatus;
        for (String num : numbers) {
            differenceStatus = true;
            for (int i = 0; i < num.length() && differenceStatus; i++) {
                for (int j = i + 1; j < num.length(); j++) {
                    if (num.charAt(i) == num.charAt(j)) {
                        differenceStatus = false;
                        break;
                    }
                }
            }

            if (differenceStatus) {
                System.out.println("First number with all difference digits: " + num);
                return;
            }
        }

        System.out.println("Number not found");
    }

    /**
     * Searches and prints palindrome. If palindrome more them one, then the output will be
     * the second palindrome. If palindromes not found, then will message about it.
     * @param numbers ArrayList of string type.
     */
    public static void findPalindrome(ArrayList<String> numbers) {
        int palindromeCounter = 0;
        int i, j;
        boolean equalStatus;
        String palindrome = null;
        for (String num : numbers) {
            equalStatus = true;
            for (i = 0, j = num.length() - 1; i < j; i++, j--) {
                if (num.charAt(i) != num.charAt(j)) {
                    equalStatus = false;
                    break;
                }
            }

            if (equalStatus) {
                palindromeCounter++;
                palindrome = num;
                if (palindromeCounter == 2) {
                    System.out.println("Second palindrome: " + palindrome);
                    return;
                }
            }
        }

        if (palindromeCounter > 0) {
            System.out.println("First palindrome: " + palindrome);
        } else {
            System.out.println("Palindrome not found");
        }
    }
}


