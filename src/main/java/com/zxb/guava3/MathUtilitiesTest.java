package com.zxb.guava3;

import com.google.common.math.BigIntegerMath;
import com.google.common.math.IntMath;
import org.junit.Test;

import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2016/1/5.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class MathUtilitiesTest {
    @Test
    public void testIntMath() {
        try {
            System.out.println(IntMath.checkedAdd(Integer.MAX_VALUE, Integer.MAX_VALUE));
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

        System.out.println(IntMath.divide(100, 5, RoundingMode.UNNECESSARY));

        try {
            System.out.println(IntMath.divide(100, 3, RoundingMode.UNNECESSARY));
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());

        }

        System.out.println("Log2(2):" + IntMath.log2(2, RoundingMode.HALF_EVEN));
        System.out.println("Log10(10):" + IntMath.log10(10, RoundingMode.HALF_EVEN));
        System.out.println("sqrt(100):" + IntMath.sqrt(IntMath.pow(10, 2), RoundingMode.HALF_EVEN));
        System.out.println("gcd(100,50):" + IntMath.gcd(100, 50));
        System.out.println("modules(100,50):" + IntMath.mod(100, 50));
        System.out.println("factorial(5):" + IntMath.factorial(5));


    }
    @Test
    public void testLongMath() {

        System.out.println(BigIntegerMath.divide(BigInteger.TEN, new BigInteger("2"), RoundingMode.UNNECESSARY));

        try{
            //exception will be thrown as 100 is not completely divisible by 3
            // thus rounding is required, and RoundingMode is set as UNNESSARY
            System.out.println(BigIntegerMath.divide(BigInteger.TEN, new BigInteger("3"), RoundingMode.UNNECESSARY));

        }
        catch(ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Log2(2): " + BigIntegerMath.log2(new BigInteger("2"), RoundingMode.HALF_EVEN));

        System.out.println("Log10(10): " + BigIntegerMath.log10(BigInteger.TEN, RoundingMode.HALF_EVEN));

        System.out.println("sqrt(100): " + BigIntegerMath.sqrt(BigInteger.TEN.multiply(BigInteger.TEN), RoundingMode.HALF_EVEN));

        System.out.println("factorial(5): "+BigIntegerMath.factorial(5));
    }

    private void testBigIntegerMath(){

        System.out.println(BigIntegerMath.divide(BigInteger.TEN, new BigInteger("2"), RoundingMode.UNNECESSARY));

        try{
            //exception will be thrown as 100 is not completely divisible by 3
            // thus rounding is required, and RoundingMode is set as UNNESSARY
            System.out.println(BigIntegerMath.divide(BigInteger.TEN, new BigInteger("3"), RoundingMode.UNNECESSARY));

        }
        catch(ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Log2(2): " + BigIntegerMath.log2(new BigInteger("2"), RoundingMode.HALF_EVEN));

        System.out.println("Log10(10): " + BigIntegerMath.log10(BigInteger.TEN, RoundingMode.HALF_EVEN));

        System.out.println("sqrt(100): " + BigIntegerMath.sqrt(BigInteger.TEN.multiply(BigInteger.TEN), RoundingMode.HALF_EVEN));

        System.out.println("factorial(5): "+BigIntegerMath.factorial(5));
    }
}
