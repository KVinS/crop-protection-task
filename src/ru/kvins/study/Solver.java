package ru.kvins.study;

/**
 * Created by Эдуард on 05.04.2016.
 */
public class Solver {
    //Доходы:
    //income1 - защищены + заморозки (низкий доход)
    //income2 - защищны + !заморозки (средний доход)
    //income3 - !защищны + заморозки (убытки)
    //income3 - !защищны + !заморозки (высокий доход)

    //frostChance - вероятность заморозков

    public static String makeDecision(float income1, float income2, float income3, float income4, float frostChance) {
        if (frostChance < 0) {
            frostChance = 0;
        }

        if (frostChance > 1) {
            frostChance = 1;
        }

        //Защищать посевы
        float ud1 = (frostChance * income1 + (1 - frostChance) * income2);

        //Не защищать посевы
        float ud2 = (frostChance * income3 + (1 - frostChance) * income4);

        String decision;

        //Жадный алгоритм
        if(ud1 > ud2) {
            decision = "Мы рекомендуем защищать посевы от заморозков из-за того, что в данном случае, доход может пострадать.";
        } else {
            decision = "Мы рекомендуем не защищать посевы, в связи с тем, что доход не пострадает от этого решения, но увеличит шанс получения дополнительной прибыли за счёт экономии.";
        }
        decision += "Вес защиты: " + ud1 + ", вес бездействия: " + ud2 + ".";

        return decision;
    }


    public  static void testSolver(float income1, float income2, float income3, float income4, float frostChance) {
        System.out.println("Input: "+income1 + ", " + income2 + ", " + income3 + ", " + income4 + ", " + frostChance);
        System.out.println(makeDecision(income1, income2, income3, income4, frostChance));
    }


}
