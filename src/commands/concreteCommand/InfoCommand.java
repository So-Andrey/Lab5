package commands.concreteCommand;

import allForDragons.DragonsCollection;
import commands.Command;
import commands.Invoker;

public class InfoCommand implements Command {
    @Override
    public void execute() {
        if (Invoker.getSplit().length == 1) {
            DragonsCollection.getInfo();
        } else {
            System.out.println("Неверная команда");
        }
    }

    @Override
    public String description() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}