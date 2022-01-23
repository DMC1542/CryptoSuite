package Math;

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
}
