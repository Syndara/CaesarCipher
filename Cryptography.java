import java.io.IOException;
import java.util.Scanner;

public class Cryptography
{

    public static void main(String[] args) throws IOException
    {
        int userArg = 0;
        @SuppressWarnings("resource")
        Scanner keyboard = new Scanner(System.in);
        String encryptedText, decryptedText;

        do
        {
            System.out.println("Welcome to the Caesar Cipher Tool\n");
            System.out.println("What would you like to do?\n");

            System.out.println("Enter '1' to encrypt text");
            System.out.println("Enter '2' to decrypt text");
            System.out.println("Enter '3' to exit the tool\n");

            System.out.print("Enter '1', '2', or '3': ");

            if (keyboard.hasNextInt())
            {
                userArg = keyboard.nextInt();
            }

            else
            {
                do
                {
                    keyboard.next();
                    System.out.println("Error: Please enter a valid number");
                    System.out.print("Enter '1', '2', or '3': ");

                }
                while (keyboard.hasNextInt() != true);

                userArg = keyboard.nextInt();
            }

            if ((userArg <= 0) || (userArg > 3))
            {
                do
                {
                    System.out.println("\nError: Number entered was not 1, 2, or 3..."
                            + "Please try again.");
                    System.out.print("Enter '1', '2', or '3': ");

                    userArg = keyboard.nextInt();
                }
                while ((userArg <= 0) || (userArg > 3));

            }
            if (userArg == 1)
            {
                encryptedText = encryptText();
                System.out.println("Your encrypted text was: " + encryptedText);
                System.out.println("Please press Enter to continue!");
                System.in.read();

            }

            else if (userArg == 2)
            {
                decryptedText = decryptText();
                System.out.println("Your encrypted text was: " + decryptedText);
                System.out.println("Please press Enter to continue!");
                System.in.read();
            }

            else if (userArg == 3)
            {
                System.out.println("\nThank you for using the Caesar Cipher Tool!");
            }

        }
        while (userArg != 3);

    }

    public static String encryptText()
    {
        char[] encryptedArray, encryptedAlphabet;
        int errorFlag, shiftValue, index;
        @SuppressWarnings("resource")
        Scanner keyboard = new Scanner(System.in);
        String userText, normalAlphabet, encryptedText;

        normalAlphabet = "abcdefghijklmnopqrstuvwxyz";
        encryptedAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        System.out.println("\nYou have decided to encrpyt a line of text");
        System.out.println("First, enter your text to be encrypted");

        System.out.print("Input: ");

        if (keyboard.hasNextLine())
        {
            userText = keyboard.nextLine();
            userText = userText.replaceAll("\\s+", "");
            userText = userText.toLowerCase();
        }

        else
        {
            do
            {
                keyboard.next();
                System.out.println("Error: Please enter valid text.");
                System.out.print("Input: ");

            }
            while (keyboard.hasNextLine() != true);

            userText = keyboard.nextLine();
            userText = userText.replaceAll("\\s", "");
            userText = userText.toLowerCase();
        }

        if (userText.matches("[^a-zA-Z ]"))
        {

        }

        else
        {
            do
            {
                char[] userArray = userText.toCharArray();
                errorFlag = -1;

                for (int i = 0; i < userArray.length; i++)
                {
                    if (((userArray[i] >= 'a' && userArray[i] <= 'z') || (userArray[i] >= 'A' && userArray[i] <= 'Z')))
                    {
                        errorFlag = 0;
                    }

                    else
                    {
                        System.out.println("Error: Special character entered at the " + (i + 1)
                                + " place, please try again.");
                        System.out.println("Input: ");

                        if (keyboard.hasNextLine())
                        {
                            userText = keyboard.nextLine();
                            userText = userText.replaceAll("\\s", "");
                            userText = userText.toLowerCase();
                        }

                        else
                        {
                            do
                            {
                                keyboard.next();
                                System.out.println("Error: Please enter valid text.");
                                System.out.print("Input: ");

                            }
                            while (keyboard.hasNextLine() != true);

                            userText = keyboard.nextLine();
                            userText = userText.replaceAll("\\s", "");
                            userText = userText.toLowerCase();
                            break;
                        }
                    }
                }

            }
            while (errorFlag == -1);

        }

        System.out.println("\nNext, please enter a shift value to ecnrypt your message");
        System.out.println("Please keep the shift value between positive and negative 25.");
        System.out.println("For a negative value, preceed the number with a minus sign '-'\n");
        System.out.print("Shift Value: ");

        if (keyboard.hasNextInt())
        {
            shiftValue = keyboard.nextInt();

            if ((shiftValue > 25) || (shiftValue < -25))
            {
                do
                {
                    System.out.println("\nError: Number entered was not between -25 and 25.");
                    System.out.println("Please enter a number between these two values");
                    System.out.print("Shift Value: ");

                    if (keyboard.hasNextInt())
                    {
                        shiftValue = keyboard.nextInt();
                    }

                    else
                    {
                        do
                        {
                            keyboard.next();
                            System.out.println("\nError: please enter a valid number");
                            System.out.println("shift Value: ");
                        }
                        while (keyboard.hasNextInt() != true);

                        shiftValue = keyboard.nextInt();
                    }
                }
                while ((shiftValue > 25) || (shiftValue < -25));
            }
        }

        else
        {
            do
            {
                keyboard.next();
                System.out.println("\nError: please enter a valid number");
                System.out.println("shift Value: ");
            }
            while (keyboard.hasNextInt() != true);

            shiftValue = keyboard.nextInt();

            if ((shiftValue > 25) || (shiftValue < -25))
            {
                do
                {
                    System.out.println("\nError: Number entered was not between -25 and 25.");
                    System.out.println("Please enter a number between these two values");
                    System.out.print("Shift Value: ");

                    if (keyboard.hasNextInt())
                    {
                        shiftValue = keyboard.nextInt();
                    }

                    else
                    {
                        do
                        {
                            keyboard.next();
                            System.out.println("\nError: please enter a valid number");
                            System.out.println("shift Value: ");
                        }
                        while (keyboard.hasNextInt() != true);

                        shiftValue = keyboard.nextInt();
                    }
                }
                while ((shiftValue > 25) || (shiftValue < -25));
            }
        }

        System.out.println();
        char[] userArray = userText.toCharArray();
        encryptedArray = new char[userArray.length];

        for (int i = 0; i < userText.length(); i++)
        {
            index = normalAlphabet.indexOf(userArray[i]);
            index = (((index + shiftValue) % 26) + 26) % 26;

            encryptedArray[i] = encryptedAlphabet[index];
        }

        encryptedText = new String(encryptedArray);
        System.out.println("Your plain-text message was: " + userText);

        return encryptedText;
    }
    
    public static String decryptText()
    {
        char[] decryptedArray, decryptedAlphabet;
        int errorFlag, shiftValue, index;
        @SuppressWarnings("resource")
        Scanner keyboard = new Scanner(System.in);
        String userText, normalAlphabet, decryptedText;

        normalAlphabet = "abcdefghijklmnopqrstuvwxyz";
        decryptedAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        System.out.println("\nYou have decided to encrpyt a line of text");
        System.out.println("First, enter your text to be encrypted");

        System.out.print("Input: ");

        if (keyboard.hasNextLine())
        {
            userText = keyboard.nextLine();
            userText = userText.replaceAll("\\s+", "!");
            userText = userText.toLowerCase();
        }

        else
        {
            do
            {
                keyboard.next();
                System.out.println("Error: Please enter valid text.");
                System.out.print("Input: ");

            }
            while (keyboard.hasNextLine() != true);

            userText = keyboard.nextLine();
            userText = userText.replaceAll("\\s", "");
            userText = userText.toLowerCase();
        }

        if (userText.matches("[^a-zA-Z ]"))
        {

        }

        else
        {
            do
            {
                char[] userArray = userText.toCharArray();
                errorFlag = -1;

                for (int i = 0; i < userArray.length; i++)
                {
                    if (((userArray[i] >= 'a' && userArray[i] <= 'z') || (userArray[i] >= 'A' && userArray[i] <= 'Z')))
                    {
                        errorFlag = 0;
                    }

                    else
                    {
                        userText = userText.replaceAll("!","");
                        System.out.println("Error: Special character or space entered at the " + (i + 1)
                                + " place, please try again.");
                        System.out.println("Input: ");                      

                        if (keyboard.hasNextLine())
                        {
                            userText = keyboard.nextLine();

                            userText = userText.toLowerCase();
                            userArray = userText.toCharArray();
                        }

                        else
                        {
                            do
                            {
                                keyboard.next();
                                System.out.println("Error: Please enter valid text.");
                                System.out.print("Input: ");

                            }
                            while (keyboard.hasNextLine() != true);

                            userText = keyboard.nextLine();

                            userText = userText.toLowerCase();
                            userArray = userText.toCharArray();
                            break;
                        }
                    }
                }

            }
            while (errorFlag == -1);

        }

        System.out.println("\nNext, please enter a shift value to ecnrypt your message");
        System.out.println("Please keep the shift value between positive and negative 25.");
        System.out.println("For a negative value, preceed the number with a minus sign '-'\n");
        System.out.print("Shift Value: ");

        if (keyboard.hasNextInt())
        {
            shiftValue = keyboard.nextInt();

            if ((shiftValue > 25) || (shiftValue < -25))
            {
                do
                {
                    System.out.println("\nError: Number entered was not between -25 and 25.");
                    System.out.println("Please enter a number between these two values");
                    System.out.print("Shift Value: ");

                    if (keyboard.hasNextInt())
                    {
                        shiftValue = keyboard.nextInt();
                    }

                    else
                    {
                        do
                        {
                            keyboard.next();
                            System.out.println("\nError: please enter a valid number");
                            System.out.println("shift Value: ");
                        }
                        while (keyboard.hasNextInt() != true);

                        shiftValue = keyboard.nextInt();
                    }
                }
                while ((shiftValue > 25) || (shiftValue < -25));
            }
        }

        else
        {
            do
            {
                keyboard.next();
                System.out.println("\nError: please enter a valid number");
                System.out.println("shift Value: ");
            }
            while (keyboard.hasNextInt() != true);

            shiftValue = keyboard.nextInt();

            if ((shiftValue > 25) || (shiftValue < -25))
            {
                do
                {
                    System.out.println("\nError: Number entered was not between -25 and 25.");
                    System.out.println("Please enter a number between these two values");
                    System.out.print("Shift Value: ");

                    if (keyboard.hasNextInt())
                    {
                        shiftValue = keyboard.nextInt();
                    }

                    else
                    {
                        do
                        {
                            keyboard.next();
                            System.out.println("\nError: please enter a valid number");
                            System.out.println("shift Value: ");
                        }
                        while (keyboard.hasNextInt() != true);

                        shiftValue = keyboard.nextInt();
                    }
                }
                while ((shiftValue > 25) || (shiftValue < -25));
            }
        }

        System.out.println();
        char[] userArray = userText.toCharArray();
        decryptedArray = new char[userArray.length];
        
        shiftValue = 26 - shiftValue;

        for (int i = 0; i < userText.length(); i++)
        {
            index = normalAlphabet.indexOf(userArray[i]);
            index = (((index + shiftValue) % 26) + 26) % 26;

            decryptedArray[i] = decryptedAlphabet[index];
        }

        decryptedText = new String(decryptedArray);
        System.out.println("Your plain-text message was: " + userText);

        return decryptedText;
    }


}
