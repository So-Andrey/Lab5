package commands.concreteCommand;

import allForDragons.Dragon;
import allForDragons.DragonsCollection;
import allForDragons.HeadComparator;
import commands.Command;
import commands.Invoker;

import java.util.ArrayList;
import java.util.Collections;

public class MaxByHeadCommand implements Command {

    @Override
    public void execute() {
        if (Invoker.split.length == 1) {
            ArrayList<Dragon> dragons = new ArrayList<>(DragonsCollection.getDragons());
            HeadComparator headComparator = new HeadComparator();
            Dragon dragon = Collections.max(dragons, headComparator);
            System.out.println("Дракон " + dragon.getId() + "\n" +
                    "Имя: " + dragon.getName() + "\n" +
                    "Возраст: " + dragon.getAge() + "\n" +
                    "Тип: " + dragon.getType() + "\n" +
                    "Цвет: " + dragon.getColor() + "\n" +
                    "Характер: " + dragon.getCharacter() + "\n" +
                    "Количество глаз: " + dragon.getHead().getEyesCount() + "\n" +
                    "Координаты: (" + dragon.getCoordinates().getX() + "; " + dragon.getCoordinates().getY() + ")\n" +
                    "Дата и время создания: " + dragon.getCreationDate() + "\n");
        } else {
            System.out.println("Неверная команда");
        }
    }
}