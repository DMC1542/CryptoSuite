package Operations;

import java.util.ArrayList;

public class Functions
{
    public static int getTotientOf(int a)
    {
        int totient = 0;
        for (int i = 0; i < a; i++)
        {
            if (Functions.getGCD(a, i) == 1)
                totient++;
        }

        return totient;
    }

    public static int getGCD(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return getGCD( b, a % b );
    }

    public static int[] getFactorsOf(int a)
    {
        ArrayList<Integer> factors = new ArrayList<>();
        int sqrt = (int)Math.sqrt(a);

        // Efficiently find factors
        for (int i = 1; i < sqrt; i++)
        {
            if (a % i == 0)
                factors.add(i);
        }

        // Add both the current factors and their pairs to an array
        int[] factorArray = new int[factors.size() * 2];
        int numFactors = factors.size();

        for (int i = 0; i < numFactors; i++)
        {
            factorArray[i] = factors.get(i);
            factorArray[numFactors * 2 - i - 1] = a / factors.get(i);
        }

        return factorArray;
    }


}
