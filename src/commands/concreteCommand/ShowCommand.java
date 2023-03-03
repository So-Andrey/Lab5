package commands.concreteCommand;

import commands.Command;
import allForDragons.*;
import commands.Invoker;

public class ShowCommand implements Command {

    @Override
    public void execute() {
        if (Invoker.getSplit().length == 1) {
            if (DragonsCollection.getDragons().isEmpty()) {
                System.out.println("Коллекция пуста");
            } else {
                for (Dragon dragon : DragonsCollection.getDragons()) {
                    System.out.println(dragon);
                }
            }
        } else { System.out.println("Неверная команда"); }
    }

    @Override
    public String description() {
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
