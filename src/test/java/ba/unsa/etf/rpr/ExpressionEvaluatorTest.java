package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

    public class ExpressionEvaluatorTest {

        @Test
        public void Test1(){
            ExpressionEvaluator e = new ExpressionEvaluator();
            Throwable exception = Assertions.assertThrows(RuntimeException.class,
                    ()->{e.evaluate("( 3 + ( 57fm3 - 9 ) )");});
        }

        @Test
        public void Test2(){
            ExpressionEvaluator e = new ExpressionEvaluator();
            Throwable exception = Assertions.assertThrows(RuntimeException.class,
                    ()->{e.evaluate("((3+7)*(2*3))");});
        }

        @Test
        public void Test3(){
            ExpressionEvaluator e = new ExpressionEvaluator();
            Assertions.assertEquals(101.0, e.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
        }

        @Test void Test4(){
            ExpressionEvaluator e = new ExpressionEvaluator();
            Assertions.assertEquals(16.0, e.evaluate("( 256 sqrt )"));
        }

        @Test
        public void Test5(){
            ExpressionEvaluator e = new ExpressionEvaluator();
            Assertions.assertEquals(11.0, e.evaluate("( 22 / 2 )"));
        }

        @Test void Test6(){
            ExpressionEvaluator e = new ExpressionEvaluator();
            Assertions.assertEquals(8.888, e.evaluate("( 22.22 / 2.5 )"));
        }

        @Test
        public void Test7(){
            ExpressionEvaluator e = new ExpressionEvaluator();
            Throwable exception = Assertions.assertThrows(RuntimeException.class,
                    ()->{e.evaluate("(3 + 4 )");});
        }
        @Test
        public void Test8(){
            ExpressionEvaluator e = new ExpressionEvaluator();
            Throwable exception = Assertions.assertThrows(RuntimeException.class,
                    ()->{e.evaluate("( 3 * 3 * / 3)");});
        }
        @Test
        public void Test9(){
            ExpressionEvaluator e = new ExpressionEvaluator();
            Throwable exception = Assertions.assertThrows(RuntimeException.class,
                    ()->{e.evaluate("( 3 * 3. * 3)");});
        }
    }

