package commands.concreteCommand;

import allForDragons.*;
import commands.Command;
import commands.Invoker;
import java.util.ArrayList;
import java.util.Collections;

public class AddIfMinCommand implements Command {

    private String ifMinDragonAdder() {
        ArrayList<Dragon> dragons = new ArrayList<>(DragonsCollection.getDragons());
        Dragon dragon = new AddCommand().dragonAdder();
        if (dragons.size() == 0) {
            DragonsCollection.getDragons().add(dragon);
            return "Новый элемент коллекции добавлен";
        } else {
            Collections.sort(dragons);
            if (dragon.getAge() < dragons.get(0).getAge()) {
                DragonsCollection.getDragons().add(dragon);
                return "Новый элемент коллекции добавлен";
            } else {
                return "Новый элемент не добавлен, так как возраст заданного дракона слишком большой";
            }
        }
    }
    @Override
    public void execute() {
        if (Invoker.getSplit().length == 1) {
            System.out.println(ifMinDragonAdder());
        } else {
            System.out.println("Неверная команда");
        }
    }
    @Override
    public String description() {
        return "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }
}
