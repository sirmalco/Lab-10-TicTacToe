import java.util.Scanner;

public class SafeInput
{

    /**
     * Prompts the user for a non-empty string and returns it.
     *
     * @param pipe Scanner object to read user input
     * @param prompt The message shown to prompt the user
     * @return A non-zero length String
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }
    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;

        boolean valid = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                valid = true;
            }

            else
            {
                String trash = pipe.nextLine();
                System.out.println("Invalid: " + trash + "enter an int:");
            }
            pipe.nextLine();
        }
        while (valid == false);

        return retVal;
    }
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0.0;

        boolean valid = false;

        do
        {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                valid = true;
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("Invalid input: " + trash + ". Please enter a double.");
            }
            pipe.nextLine();
        } while (!valid);
        return retVal;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = 0;

        boolean valid = false;

        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();

                if (retVal >= low && retVal <= high)
                {
                    valid = true;
                }
                else
                {
                    System.out.println("Invalid input enter int between " + low + " and " + high);
                }
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("Invalid: " + trash + "enter an integer.");
            }
            pipe.nextLine();
        }
        while (!valid);

        return retVal;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {

        double retVal = 0.0;

        boolean valid = false;

        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");

            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();

                if (retVal >= low && retVal <= high)
                {
                    valid = true;
                }
                else
                {
                    System.out.println("Invalid input. Enter a value between " + low + " and " + high + ".");
                }
            }
            else
            {
                String trash = pipe.nextLine();
                System.out.println("Invalid input: " + trash + ". Please enter a double.");
            }
            pipe.nextLine();

        }
        while (!valid);

        return retVal;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response;

        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");

            response = pipe.nextLine().trim().toLowerCase();

            if (response.equals("y"))
            {
                return true;
            }
            else if (response.equals("n"))
            {
                return false;
            }
            else
            {
                System.out.println("Invalid ... Enter Y or N.");
            }
        }
        while (true);

    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String retString;

        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();

            if (retString.matches(regEx))
            {
                return retString;
            }
            else
            {
                System.out.println("Input does not match format");
            }
        }
        while (true);
    }

}