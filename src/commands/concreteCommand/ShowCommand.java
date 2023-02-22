package commands.concreteCommand;

import commands.Command;
import allForDragons.*;

public class ShowCommand implements Command {

    @Override
    public void execute() {

        Dragon[] dragons = DragonsCollection.dragons.toArray(new Dragon[DragonsCollection.dragons.size()]);

        for (int i = 0; i < dragons.length; ++i) {
            System.out.println("Дракон " + dragons[i].getId() + "\n" +
                    "Имя: " + dragons[i].getName() + "\n" +
                    "Возраст: " + dragons[i].getAge() + "\n" +
                    "Тип: " + dragons[i].getType() + "\n" +
                    "Цвет: " + dragons[i].getColor() + "\n" +
                    "Характер: " + dragons[i].getCharacter() + "\n" +
                    "Количество глаз: " + dragons[i].getHead().getEyesCount() + "\n" +
                    "Координаты: (" + dragons[i].getCoordinates().getX() + "; " + dragons[i].getCoordinates().getY() + ")\n" +
                    "Дата и время создания: " + dragons[i].getCreationDate() + "\n");
        }
    }
}