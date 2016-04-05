package ru.kvins.study;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Scanner;

public class Main {
    //Программа для определения нужно ли фермеру укрывать посевы
    private final static boolean runTests = false;

    public static void main(String[] args) {
        if(runTests){
            Solver.testSolver(0.5f, 0.98f, 0.2f, 0.2f, 0.2f);
            Solver.testSolver(0.2f, 0.2f, 0.5f, 0.98f, 0.2f);
        }

        Scanner in = new Scanner(System.in);

        if (in.hasNext()) {
            String input = in.nextLine();

            JSONParser parser = new JSONParser();
            JSONObject mainObject;
            try {
                mainObject = (JSONObject) parser.parse(input);

                final float income1 = Float.parseFloat(mainObject.get("income1").toString());
                final float income2 = Float.parseFloat(mainObject.get("income2").toString());
                final float income3 = Float.parseFloat(mainObject.get("income3").toString());
                final float income4 = Float.parseFloat(mainObject.get("income4").toString());
                final float frostChance = Float.parseFloat(mainObject.get("frostChance").toString());

                System.out.print(Solver.makeDecision(income1, income2, income3, income4, frostChance));
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.print("Ошибка ввода.");
            }
        }
    }
}
