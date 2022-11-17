package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

    public class ExpressionEvaluatorTest {


        @Test
        public void Test1(){
            ExpressionEvaluator e = new ExpressionEvaluator();
            Throwable exception = Assertions.assertThrows(RuntimeException.class,
                    ()->{e.evaluate("((3+7)*(2*3))");});
        }

        @Test
        public void Test2(){
            ExpressionEvaluator e = new ExpressionEvaluator();
            Throwable exception = Assertions.assertThrows(RuntimeException.class,
                    ()->{e.evaluate("( 3 + ( ( 57fm3 - 9 ) * ( 1 / 1 ) ) )");});
        }

        @Test
        public void Test3(){
            ExpressionEvaluator e = new ExpressionEvaluator();
            Assertions.assertEquals(101.0, e.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
        }

       /* @Test
        public void Test4(){
            ExpressionEvaluator e = new ExpressionEvaluator();
            Assertions.assertEquals(2.0, e.evaluate("( 10. / 5 ) "));
        }

        @Test void Test5(){
            ExpressionEvaluator e = new ExpressionEvaluator();
            Assertions.assertEquals(2.625, e.evaluate("( 2.2 / 1 ) "));
        }

        @Test void Test6(){
            ExpressionEvaluator e = new ExpressionEvaluator();
            Assertions.assertEquals(16.0, e.evaluate("( 256 sqrt )"));
        }

        @Test
        public void Test7 () {
            ExpressionEvaluator el = new ExpressionEvaluator();
            Assertions.assertEquals(RuntimeException.class, el.evaluate("(10. / 5 ) "));
        }*/
    }

