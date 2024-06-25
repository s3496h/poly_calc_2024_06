package org.koreait;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Calc {
    public static int run(String exp) {

        if (!exp.contains(" ")) {
            return Integer.parseInt(exp);
        }

        boolean needToMulti = exp.contains("*");
        boolean needToPlus = exp.contains("+");

        boolean needToCompound = needToMulti && needToPlus;


        if (needToCompound) {
            String[] bits = exp.split(" \\+ ");

            //단일항이 들어오면 바로 리턴
            String newExp = Arrays.stream(bits)

                    .mapToInt(Calc::run)
                    .mapToObj(e -> e + "")
                    //객체가 아닌데 객체로 바꿔야할 때
                    .collect(Collectors.joining(" + "));
            return run(newExp);
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
        } else
            throw new RuntimeException("해석 불가 : 올바른 계산식이 아니야");
    }
}
