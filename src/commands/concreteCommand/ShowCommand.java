package commands.concreteCommand;

import commands.Command;
import allForDragons.*;
import commands.Executor;

public class ShowCommand implements Command {

    @Override
    public void execute() {

        if (Executor.split.length == 1) {

            if (DragonsCollection.getDragons().size() == 0) {

                System.out.println("Коллекция пуста");

            } else {

                for (Dragon dragon : DragonsCollection.getDragons()) {
                    System.out.println("Дракон " + dragon.getId() + "\n" +
                            "Имя: " + dragon.getName() + "\n" +
                            "Возраст: " + dragon.getAge() + "\n" +
                            "Тип: " + dragon.getType() + "\n" +
                            "Цвет: " + dragon.getColor() + "\n" +
                            "Характер: " + dragon.getCharacter() + "\n" +
                            "Количество глаз: " + dragon.getHead().getEyesCount() + "\n" +
                            "Координаты: (" + dragon.getCoordinates().getX() + "; " + dragon.getCoordinates().getY() + ")\n" +
                            "Дата и время создания: " + dragon.getCreationDate() + "\n");
                }
            }

        } else {
            System.out.println("Неверная команда");
        }
    }
}
