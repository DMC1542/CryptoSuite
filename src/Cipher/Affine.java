package Cipher;

import java.util.Locale;

public class Affine
{
    private static final int ASCII_A = 97;

    //necessary?
    private final char[] charTable = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                                    'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                                    't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static void encrypt(int a, int b, String plaintext)
    {
        String ciphertext = "";
    }

    private static void decrypt(int b, int i, String text)
    {
        char[] plaintext = new char[text.length()];
        text = text.toLowerCase(Locale.ROOT);

        // Convert letters to indices
        int[] ciphertext = new int[text.length()];
        for (int k = 0; k < text.length(); k++)
            ciphertext[k] = (int)text.charAt(k) - ASCII_A;

        // Now to decrypt
        for (int k = 0; k < text.length(); k++)
            plaintext[k] = (char)(mod(i * (ciphertext[k] - b), 26) + ASCII_A);

        System.out.println(plaintext);
    }

    public static void execute(String[] arguments)
    {
        int a = 0, b = 0, i = 0;
        String message = null;

        // check arguments, starting after the encryption/decryption flag
        for (int k = 2; k < arguments.length; k++)
        {
            switch (arguments[k])
            {
                case "-a":
                    // need to check if the value is valid
                    a = Integer.parseInt(arguments[k + 1]);
                    k++;
                    break;
                case "-b":
                    // need to check if the value is valid
                    b = Integer.parseInt(arguments[k + 1]);
                    k++;
                    break;
                case "-i":
                    // need to check if the value is valid
                    i = Integer.parseInt(arguments[k + 1]);
                    k++;
                    break;
                case "-m":
                    // need to check if the value is valid
                    message = arguments[k + 1];
                    k++;
                    break;
                default:
                    System.out.println(arguments[k] + " is not a valid flag. Exiting.");
                    return;
            }
        }

        //TODO ensure all fields were provided

        // Check if encryption or decryption
        if (arguments[1].equals("-e"))
            encrypt(a, b, message);
        else if (arguments[1].equals("-d"))
            decrypt(b, i, message);
        else
            System.out.println("No encryption or decryption argument specified. Exiting.");
    }

    private static int mod(int a, int b)
    {
        int answer = a % b;

        if (answer < 0)
            return answer + b;
        else
            return answer;
    }
}
