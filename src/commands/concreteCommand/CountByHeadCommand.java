package commands.concreteCommand;

import allForDragons.Dragon;
import allForDragons.DragonsCollection;
import commands.Command;
import commands.Invoker;

public class CountByHeadCommand implements Command {

    private int getCountOfDragons() {
        double eyesCount = Double.parseDouble(Invoker.getSplit()[1]);
        int countByHead = 0;
        for (Dragon dragon : DragonsCollection.getDragons()) {
            if (dragon.getHead().getEyesCount() == eyesCount) {
                countByHead += 1;
            }
        }
        return countByHead;
    }
    @Override
    public void execute() {
        if (Invoker.getSplit().length == 2) {
            System.out.println("Количество драконов с заданным количеством глаз: " + getCountOfDragons());
        } else {
            System.out.println("Неверная команда");
        }
    }
    @Override
    public String description() {
        return "count_by_head head : вывести количество элементов, значение поля head которых равно заданному";
    }
}