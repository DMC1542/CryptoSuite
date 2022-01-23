import Cipher.Affine;

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
    public static void main(String[] args)
    {
        switch (args[0]) {
            case "help", "-h", "-help" -> printHelp();
            case "affine" -> Affine.execute(args);
        }
    }

    public static void printHelp()
    {
        System.out.println("Usage: java -jar Cryptography.jar [cipher] [parameters]\n");
        // a value used to expand keyspace
        // b value used to offset shift
        // a's inverse, used for decryption
        System.out.println("""
                1) Affine Cipher: (affine)
                   -e  : Encryption
                   -d  : Decryption
                   -a [1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25]
                   -b [value]
                   -i [value] (optional)
                   -m "[message]" : Letters only. No punctuation. Must be wrapped in quotes if there are spaces.
                """);
    }
}
