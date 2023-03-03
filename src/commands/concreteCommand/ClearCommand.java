package commands.concreteCommand;

import allForDragons.DragonsCollection;
import commands.Command;
import commands.Invoker;

public class ClearCommand implements Command {
    @Override
    public void execute() {
        if (Invoker.getSplit().length == 1) {
            DragonsCollection.getDragons().clear();
            System.out.println("Коллекция очищена");
        } else {
            System.out.println("Неверная команда");
        }
    }
    @Override
    public String description() {
        return "clear : очистить коллекцию";
    }
}
