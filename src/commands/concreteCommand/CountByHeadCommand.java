package commands.concreteCommand;

import allForDragons.Dragon;
import allForDragons.DragonsCollection;
import commands.Command;
import commands.Invoker;

public class CountByHeadCommand implements Command {

    @Override
    public void execute() {

        if (Invoker.split.length == 2) {
            double eyesCount = Double.parseDouble(Invoker.split[1]);
            int countByHead = 0;
            for (Dragon dragon : DragonsCollection.getDragons()) {
                if (dragon.getHead().getEyesCount() == eyesCount) {
                    countByHead += 1;
                }
            }
            System.out.println("Количество драконов с заданным количеством глаз: " + countByHead);

        } else {
            System.out.println("Неверная команда");
        }
    }

    @Override
    public String description() {
        return "count_by_head head : вывести количество элементов, значение поля head которых равно заданному";
    }
}