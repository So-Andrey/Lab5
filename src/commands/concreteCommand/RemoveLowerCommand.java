package commands.concreteCommand;

import allForDragons.*;
import commands.Command;
import commands.Invoker;
import java.util.ArrayList;
import java.util.Collections;

public class RemoveLowerCommand implements Command {
    @Override
    public void execute() {

        if (Invoker.split.length == 2) {

            long id = Long.parseLong(Invoker.split[1]);
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
                    boolean isThereYoungerDragons = true;
                    do {
                        ArrayList<Dragon> dragons = new ArrayList<>(DragonsCollection.getDragons());
                        Collections.sort(dragons);
                        Dragon dragon = Collections.min(dragons);
                        if (dragon != thisDragon) {
                            DragonsCollection.getDragons().remove(dragon);
                            ++countOfDragons;
                        } else {
                            isThereYoungerDragons = false;
                        }
                    } while (isThereYoungerDragons);
                } else {
                    System.out.println("Заданного дракона не существует");
                }
                if (countOfDragons != 0) {
                    System.out.println("Количество удалённых драконов " + countOfDragons);
                } else if (dragonExists) {
                    System.out.println("Драконов младше заданного не существует");
                }
            } else {
                System.out.println("Коллекция пуста, заданного дракона не существует");
            }
        } else {
            System.out.println("Неверная команда");
        }
    }

    @Override
    public String description() {
        return "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
