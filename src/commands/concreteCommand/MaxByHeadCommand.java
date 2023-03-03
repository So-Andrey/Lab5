package commands.concreteCommand;

import allForDragons.Dragon;
import allForDragons.DragonsCollection;
import allForDragons.HeadComparator;
import commands.Command;
import commands.Invoker;

import java.util.ArrayList;
import java.util.Collections;

public class MaxByHeadCommand implements Command {

    @Override
    public void execute() {
        if (Invoker.getSplit().length == 1) {
            ArrayList<Dragon> dragons = new ArrayList<>(DragonsCollection.getDragons());
            HeadComparator headComparator = new HeadComparator();
            Dragon dragon = Collections.max(dragons, headComparator);
            System.out.println(dragon);
        } else {
            System.out.println("Неверная команда");
        }
    }

    @Override
    public String description() {
        return "max_by_head : вывести любой объект из коллекции, значение поля head которого является максимальным";
    }
}