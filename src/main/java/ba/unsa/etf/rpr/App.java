package ba.unsa.etf.rpr;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner ulaz = new Scanner(System.in);
        String ulazniString = ulaz.nextLine();
        ExpressionEvaluator eval = new ExpressionEvaluator();
            System.out.println(eval.evaluate(ulazniString));

    }
}
