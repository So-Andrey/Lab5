package commands.concreteCommand;

import allForDragons.*;
import commands.Command;
import commands.Executor;

import java.util.ArrayList;
import java.util.Collections;

public class RemoveGreaterCommand implements Command {
    @Override
    public void execute() {

        if (Executor.split.length == 2) {

            long id = Long.parseLong(Executor.split[1]);
            int countOfDragons = 0;
            boolean dragonExists = false;
            Dragon thisDragon = new Dragon("", new Coordinates(0,0), Long.parseLong("0"),Color.ORANGE, DragonType.WATER, DragonCharacter.FICKLE,new DragonHead(Double.parseDouble("0")));

            if (!DragonsCollection.getDragons().isEmpty()) {
                for (Dragon dragon : DragonsCollection.getDragons()) {
                    if (dragon.getId() == id) {
                        dragonExists = true;
                        thisDragon = dragon;
                    }
                }
                if (dragonExists) {
                    boolean isThereOlderDragons = true;
                    do {
                        ArrayList<Dragon> dragons = new ArrayList<>(DragonsCollection.getDragons());
                        AgeComparator ageComparator = new AgeComparator();
                        Dragon dragon = Collections.max(dragons, ageComparator);
                        if (dragon != thisDragon) {
                            DragonsCollection.getDragons().remove(dragon);
                            ++countOfDragons;
                        } else {
                            isThereOlderDragons = false;
                        }
                    } while (isThereOlderDragons);
                } else {
                    System.out.println("Заданного дракона не существует");
                }
                if (countOfDragons != 0) {
                    System.out.println("Количество удалённых драконов " + countOfDragons);
                } else if (dragonExists) {
                    System.out.println("Драконов старше заданного не существует");
                }
            } else {
                System.out.println("Коллекция пуста, заданного дракона не существует");
            }
        } else {
            System.out.println("Неверная команда");
        }

    }
}
