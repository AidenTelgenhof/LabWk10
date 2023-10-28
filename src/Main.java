public class Main {
    public static void main(String[] args) {
        System.out.println(countOddDigits(235987));
        System.out.println(digitTotal(120348));
        int[] doubleUpperTestArray = arrayDoubleUpper(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        for (int num : doubleUpperTestArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(removeRepeats("qqqqqqqqqwweeerrttyyuuiioopppppppp"));
        System.out.println(dominos(5));
    }

    /*
    Count odd digits
    LearnCS states that method was not implemented recursively
     */
    public static int countOddDigits(int n) {
        int count = 0;
        if (n < 10) {
            if (n % 2 == 1) {
                count++;
            }
        } else if ((n % 10) % 2 == 1) {
            count += 1 + countOddDigits(n / 10);
        } else {
            count += countOddDigits(n / 10);
        }
        return count;
    }

    /*
    Digit Total
    LearnCS states that method was not implemented recursively
     */
    public static int digitTotal(int n) {
        int total = 0;
        if (n < 10) {
            total += n;
        } else {
            total += n % 10 + digitTotal(n / 10);
        }
        return total;
    }

    /*
    Array Double Upper
    LearnCS states that method was not implemented recursively
     */
    public static int[] arrayDoubleUpper(int[] nums, int index) {
        nums[index] *= 2;
        if (index == nums.length - 1) {
            return nums;
        }
        return arrayDoubleUpper(nums, index + 1);
    }

    public static int[] arrayDoubleUpper(int[] nums) {
        return arrayDoubleUpper(nums, 0);
    }

    /*
    Remove Repeats
    LearnCS states that given the input "8 circle", the code should output "8 circ"
    This output does not follow the problem's guidelines of removing repeating neighboring letters.
    Reason: l and e not repeat neighbors in circle and are even unique letters to the phrase.
     */
    public static String removeRepeats(String phrase) {
        String returnValue = "";
        if (phrase.length() == 1) {
            returnValue += phrase;
        } else if (phrase.length() == 2) {
            if (phrase.startsWith(phrase.substring(1, 2))) {
                returnValue += phrase.substring(0, 1);
            } else {
                returnValue += phrase;
            }
        } else if (phrase.startsWith(phrase.substring(1, 2))) {
            returnValue += removeRepeats(phrase.substring(1));
        } else {
            returnValue += phrase.substring(0, 1) + removeRepeats(phrase.substring(1));
        }
        return returnValue;
    }

    /*
    Dominos
    LearnCS produces the following console output:
    "reached end of file while parsing
     1 error"
     When drawing out the problem, I came to the conclusion that it was the fibonacci sequence with an offset.
     Even assuming my conclusion about the problem was wrong, I am still not quite sure how I got the error above
     when it should've just produced an error stating the correct return and my return.
     */
    public static int dominos(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        int returnValue = 0;
        if (n <= 2) {
            returnValue += n;
        } else {
            returnValue += dominos(n - 1) +  dominos(n - 2);
        }
        return returnValue;
    }
}