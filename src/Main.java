import Cipher.Affine;
import Math.Functions;

/**
 * Handles the command line arguments for the Cryptographic Services program
 *
 * File: Main.java
 * Language: Java 17
 *
 * @author Domenic Cacace
 *
 * Date Created: 1/17/2022
 * Last Modified 1/17/2022
 */

public class Main
{
    /**
     * Runs the program via the command line
     * @param args Command line arguments provided for encryption services.
     */
    public static void main(String args[])
    {
        switch (args[0])
        {
            case "help":
            case "-h":
            case "-help":
                printHelp();
                break;
            case "affine":
                Affine.execute(args);
                break;
        }

        System.out.println(Functions.getTotientOf(4));
        System.out.println(Functions.getTotientOf(5));
        System.out.println(Functions.getTotientOf(9));
        System.out.println(Functions.getTotientOf(26));
    }

    public static void printHelp()
    {
        System.out.println("Usage: java -jar Cryptography.jar [cipher] [parameters]\n");
        System.out.println("1) Affine Cipher: (affine)\n" +
                "   -e  : Encryption\n" +
                "   -d  : Decryption\n" +
                "   -a [1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25]\n" +     // a value used to expand keyspace
                "   -b [value]\n" +                                         // b value used to offset shift
                "   -i [value] (optional)\n" +                              // a's inverse, used for decryption
                "   -m \"[message]\" : Letters only. No punctuation. Must be wrapped in quotes if there are spaces.\n");
    }
}
