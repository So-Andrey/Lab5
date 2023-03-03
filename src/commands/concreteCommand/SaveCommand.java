package commands.concreteCommand;

import allForDragons.Dragon;
import allForDragons.DragonsCollection;
import commands.Command;
import commands.Invoker;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SaveCommand implements Command {

    @Override
    public void execute() {

        try (PrintWriter writer = new PrintWriter(Invoker.file)) {

            for (Dragon dragon : DragonsCollection.getDragons()) {
                writer.write(dragon.getName() + ", " + dragon.getAge() + ", " + dragon.getCoordinates().getX() + ", " + dragon.getCoordinates().getY() + ", " + dragon.getColor() + ", " + dragon.getType() + ", " + dragon.getCharacter() + ", " + dragon.getHead().getEyesCount() + "\n");
            }
            writer.flush();
            System.out.println("Коллекция успешно сохранена в файл");

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Отсутствует имя файла");
        }
    }

    @Override
    public String description() {
        return "save : сохранить коллекцию в файл";
    }
}