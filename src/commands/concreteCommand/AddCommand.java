package commands.concreteCommand;

import commands.Command;
import allForDragons.*;
import commands.Invoker;
import java.util.InputMismatchException;

public class AddCommand implements Command {

    @Override
    public void execute() throws InputMismatchException {
        if (Invoker.getSplit().length == 1) {
            DragonsCollection.getDragons().add(DragonAdder.dragonAdder());
            System.out.println("Новый элемент коллекции добавлен");
        } else {
            System.out.println("Неверная команда");
        }
    }
    @Override
    public String description() {
        return "add {element} : добавить новый элемент в коллекцию";
    }
}
