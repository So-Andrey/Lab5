package commands.concreteCommand;

import allForDragons.Dragon;
import allForDragons.DragonsCollection;
import commands.Command;
import commands.Executor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SaveCommand implements Command {

    @Override
    public void execute() {

        try (PrintWriter writer = new PrintWriter(Executor.file)) {

            for (Dragon dragon : DragonsCollection.dragons) {
                writer.write(dragon.getId() + ", " + dragon.getName() + ", " + dragon.getAge() + ", " + dragon.getCoordinates().getX() + "," + dragon.getCoordinates().getY() + ", " + dragon.getColor() + ", " + dragon.getType() + ", " + dragon.getCharacter() + ", " + dragon.getHead().getEyesCount() + ", " + dragon.getCreationDate() + "\n");
            }
            System.out.println("Коллекция успешно сохранена в файл");

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Отсутсвует имя файла");
        }
    }
}