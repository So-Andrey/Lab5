package allForDragons;

import commands.Executor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DragonsCollection {

    public static LinkedHashSet<Dragon> dragons = new LinkedHashSet<>();
    public static Date dateOfInitialization = new Date();

    public static void putDragonsFromFile() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(Executor.file));
        String name;
        long x;
        float y;
        Long age;
        Color color = null;
        DragonType type = DragonType.FIRE;
        DragonCharacter character = DragonCharacter.WISE;
        Double eyesCount;

        boolean scan = true;
        while (scan) {

            String[] dragon = scanner.nextLine().split(", ");
            if (dragon.length == 8) {
                try {
                    if (!dragon[0].trim().isEmpty()) {
                        name = dragon[0];
                    } else {
                        throw new InputMismatchException();
                    }
                    age = Long.parseLong(dragon[1]);
                    x = Long.parseLong(dragon[2]);
                    y = Float.parseFloat(dragon[3]);
                    if (dragon[4].equals("GREEN")||dragon[4].equals("ORANGE")||dragon[4].equals("BROWN")||dragon[4].equals("null")|dragon[5].equals("WATER")||dragon[5].equals("UNDERGROUND")||dragon[5].equals("FIRE")||dragon[6].equals("CUNNING")||dragon[6].equals("CHAOTIC_EVIL")||dragon[6].equals("WISE")||dragon[6].equals("FICKLE")) {
                        switch (dragon[4]) {
                            case "GREEN" -> color = Color.GREEN;
                            case "ORANGE" -> color = Color.ORANGE;
                            case "BROWN" -> color = Color.BROWN;
                            case "null" -> color = null;
                        }
                        switch (dragon[5]) {
                            case "WATER" -> type = DragonType.WATER;
                            case "UNDERGROUND" -> type = DragonType.UNDERGROUND;
                            case "FIRE" -> type = DragonType.FIRE;
                        }
                        switch (dragon[6]) {
                            case "CUNNING" -> character = DragonCharacter.CUNNING;
                            case "WISE" -> character = DragonCharacter.WISE;
                            case "CHAOTIC_EVIL" -> character = DragonCharacter.CHAOTIC_EVIL;
                            case "FICKLE" -> character = DragonCharacter.FICKLE;
                        }
                    } else {
                        throw new InputMismatchException();
                    }
                    eyesCount = Double.parseDouble(dragon[7]);
                    dragons.add(new Dragon(name, new Coordinates(x, y), age, color, type, character, new DragonHead(eyesCount)));
                } catch (Exception ignored) {}
            }
            scan = scanner.hasNext();
        }
    }
}