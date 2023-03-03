package commands.concreteCommand;

import allForDragons.DragonsCollection;
import commands.Command;
import commands.Invoker;

public class InfoCommand implements Command {
    @Override
    public void execute() {

        if (Invoker.split.length == 1) {
            String type = DragonsCollection.getDragons().getClass().getTypeName();
            String[] typeArray = type.split(".util.");
            type = typeArray[1];
            System.out.println("Тип коллекции: " + type + "\n" +
                    "Дата инициализации: " + DragonsCollection.getDateOfInitialization() + "\n" +
                    "Количество элементов: " + DragonsCollection.getDragons().size() + "\n");
        } else {
            System.out.println("Неверная команда");
        }
    }

    @Override
    public String description() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}