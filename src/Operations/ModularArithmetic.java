package Operations;

import java.util.ArrayList;

public class ModularArithmetic
{
    /**
     * Finds the modular multiplicative inverse of (a mod b)
     * @param a The number for which to find the inverse
     * @param b The modulo m
     * @return The multiplicative inverse OR -1 if NO multiplicative inverse.
     */
    public static int getMultiplicativeInverseEEA(int a, int b)
    {
        // Guard against Div by Zero errors
        if (b == 0)
            return -1;

        ArrayList<Integer[]> states = new ArrayList<>();
        int remainder;

        // Do the first step outside the loop
        Integer[] initialState = {a, b, (a / b), (a % b)};
        states.add(initialState);

        // First loop to determine if the GCD is 1
        int i = 1;
        do
        {
            Integer[] lastState = states.get(i - 1);

            int newA = lastState[1], newB = lastState[3];
            remainder = (newA % newB);

            // a = b, b = r
            Integer[] state = {newA, newB, (newA / newB), remainder};
            states.add(state);
            i++;
        } while (remainder != 0);

        // Remainder is zero, if b is 1 then gcd is 1.
        Integer[] lastState = states.get(states.size() - 1);

        if (lastState[1] != 1)
            return -1;

        // We have a gcd. Work to find the inverse
        i = states.size() - 2;
        int x = 0, y= 1, xPrime, yPrime;
        do
        {
            xPrime = x;
            yPrime = y;

            x = yPrime;
            y = xPrime - (yPrime * states.get(i)[2]);
            i--;
        } while (i >= 0);

        // Calibrate the output
        if (x < 0)
            return x + b;
        else
            return x;
    }

    public static int mod(int a, int b)
    {
        int answer = a % b;

        if (answer < 0)
            return answer + b;
        else
            return answer;
    }
}
