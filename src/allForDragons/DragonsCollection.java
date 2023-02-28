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
        Color color;
        DragonType type;
        DragonCharacter character;
        Double eyesCount;

        boolean scan = true;
        while (scan) {

            try {
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
                        if (dragon[4].equals("GREEN") || dragon[4].equals("ORANGE") || dragon[4].equals("BROWN") || dragon[4].equals("null") | dragon[5].equals("WATER") || dragon[5].equals("UNDERGROUND") || dragon[5].equals("FIRE") || dragon[6].equals("CUNNING") || dragon[6].equals("CHAOTIC_EVIL") || dragon[6].equals("WISE") || dragon[6].equals("FICKLE")) {
                            color = Color.valueOf(dragon[4]);
                            type = DragonType.valueOf(dragon[5]);
                            character = DragonCharacter.valueOf(dragon[6]);
                        } else {
                            throw new InputMismatchException();
                        }
                        eyesCount = Double.parseDouble(dragon[7]);
                        dragons.add(new Dragon(name, new Coordinates(x, y), age, color, type, character, new DragonHead(eyesCount)));
                    } catch (Exception ignored) {}
                }
            } catch (Exception ignored) {}
            scan = scanner.hasNext();
        }
    }
}