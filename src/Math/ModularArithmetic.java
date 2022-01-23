package Math;

public class ModularArithmetic
{
    // Does not yet utilize Euclidean Algorithm
    public static int getInverseOf(int a, int mod)
    {
        for (int i = 0; i < mod; i++)
        {
            if ((a * i) % mod == 1)
                return i;
        }

        return 0;
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
