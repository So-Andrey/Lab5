package commands.concreteCommand;

import allForDragons.DragonsCollection;
import commands.Command;

public class InfoCommand implements Command {
    @Override
    public void execute() {

        String type = DragonsCollection.dragons.getClass().getTypeName();
        String[] typeArray = type.split(".util.");
        type = typeArray[1];
        System.out.println("Тип коллекции: " + type + "\n" +
                "Дата инициализации: " + DragonsCollection.dateOfInitialization + "\n" +
                "Количество элементов: " + DragonsCollection.dragons.size());
    }
}