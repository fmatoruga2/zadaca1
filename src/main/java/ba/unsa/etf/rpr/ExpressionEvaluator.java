package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {

    private java.util.Stack operatori;
    private java.util.Stack vrijednosti;

    public Double evaluate(String string){

        operatori = new Stack<String>();
        vrijednosti = new Stack<Double> ();

        string = string.trim();
        if(!string.startsWith("(")) {
            throw new RuntimeException("Nevalidan unos!");
        }
        boolean space = false;
        for(int i = 0; i < string.length(); i++) {
            String str ="";
            //string koji se nalazi izmedju dva space-a, stavljamo u jedan string
            if(string.charAt(i) != ' '){
                do{
                    str = str + string.charAt(i);
                    if (i == string.length() - 1) break;
                    i++;
                }while(string.charAt(i) != ' ');
            }
            //provjera validnosti space-a
            if(string.charAt(i)==' ' && string.charAt(i+1)==' ') throw new RuntimeException("Nevalidan unos!");

            boolean validanUnos = false;

            //provjera validnosti sadrzaja stringa
            if (str.equals("(") || str.equals("+") || str.equals("-") || str.equals("/") ||
                str.equals("sqrt") || str.equals(")") || str.equals("*")) {
                validanUnos = true;
            } else {
                Double number = Double.parseDouble(str);
                validanUnos = true;
            }
            //djikstra algoritam
            if (validanUnos == true) {
                if (str.equals("(")) ;
                else if (str.equals("+")) operatori.push(str);
                else if (str.equals("-")) operatori.push(str);
                else if (str.equals("*")) operatori.push(str);
                else if (str.equals("/")) operatori.push(str);
                else if (str.equals("sqrt")) operatori.push(str);
                else if (str.equals(")")) {
                    String op = (String) operatori.pop();
                    double v = (double) vrijednosti.pop();
                    if (op.equals("+")) v = (double) vrijednosti.pop() + v;
                    else if (op.equals("-")) v = (double) vrijednosti.pop() - v;
                    else if (op.equals("*")) v = (double) vrijednosti.pop() * v;
                    else if (op.equals("/")) v = (double) vrijednosti.pop() / v;
                    else if (op.equals("sqrt")) v = Math.sqrt(v);
                    vrijednosti.push(v);
                } else vrijednosti.push(Double.parseDouble(str));
            } else {
                throw new RuntimeException("Nevalidan unos!");
            }
        }
        /* U slucaju da je unos nevalidan tipa " ( 1 + 2 + 3 + 4 + 5 ) " visak ostaje u steku,
            pa na ovaj nacin rjesavamo slucaj ovako pogresnog unosa */
        if(!operatori.isEmpty()) throw new RuntimeException("Nevalidan unos!");
        return (Double) vrijednosti.pop();
    }
}