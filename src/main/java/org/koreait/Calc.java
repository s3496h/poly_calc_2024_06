package org.koreait;

public class Calc {
    public static int run(String exp) {

        boolean needToMulti = exp.contains("*");
        boolean needToPlus = exp.contains("+");
         boolean needToCompound = needToMulti && needToPlus;

         if (needToCompound) {
             String[] bits  = exp.split(" \\+ ");
             return Integer.parseInt(bits[0]) + run(bits[1]);
         }
         if (needToPlus) {
           exp = exp.replace("- ", "- +");
            String[] bits = exp.split(" \\+ ");

            int sum = 0;

            for (int i = 0; i < bits.length; i++) {
                sum += Integer.parseInt(bits[i]);

            }

            return sum;
        } else if (needToMulti) {

            String[] bits = exp.split(" \\* ");

            int sum = 1;

            for (int i = 0; i < bits.length; i++) {
                sum *= Integer.parseInt(bits[i]);
            }

            return sum;
        }
        else
        throw new RuntimeException("해석 불가 : 올바른 계산식이 아니야");
    }
}
