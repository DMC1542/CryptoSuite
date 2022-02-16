import Cipher.Affine;
import Operations.Functions;

import Operations.ModularArithmetic;

/**
 * Handles the command line arguments for the Cryptographic Services program
 *
 * File: Main.java
 * Language: Java 17
 *
 * @author Domenic Cacace
 *
 * Date Created: 1/17/2022
 * Last Modified 1/23/2022
 */

public class Main
{
    /**
     * Runs the program via the command line
     * @param args Command line arguments provided for encryption services.
     */
    public static void main(String[] args)
    {
        switch (args[0])
        {
            case "help", "-h", "-help" -> printHelp();
            case "affine" -> Affine.execute(args);
            case "factor" -> {
                int[] factors = Functions.getFactorsOf(Integer.parseInt(args[1]));
                for (int i = 0; i < factors.length - 1; i++)
                {       System.out.print(factors[i] + ", ");     }

                System.out.println(factors[factors.length - 1]);
            }
            case "totient" -> System.out.println(Functions.getTotientOf(Integer.parseInt(args[1])));
            case "inverse" -> {
                int result = ModularArithmetic.getMultiplicativeInverseEEA(
                        Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                if (result == -1)
                    System.out.println("No multiplicative inverse");
                else
                    System.out.println(result);
            }
        }
    }

    public static void printHelp()
    {
        System.out.println("Usage: java -jar Cryptography.jar [cipher/function] [parameters]\n");
        // a value used to expand keyspace
        // b value used to offset shift
        // a's inverse, used for decryption
        System.out.println("""
                CIPHERS
                1) Affine Cipher: (affine)
                   -e  : Encryption
                   -d  : Decryption
                   -a [1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25]
                   -b [value]
                   -i [value] (optional)
                   -m "[message]" : Letters only. No punctuation. Must be wrapped in quotes if there are spaces.
                   
                FUNCTIONS
                1) Factors
                    Usage: java -jar Cryptography.jar factor [integer]
                2) Totient
                    Usage: java -jar Cryptography.jar totient [integer]
                3) Multiplicative Inverse
                    Usage: java -jar Cryptography.jar inverse [a] [b]
                """);
    }
}
