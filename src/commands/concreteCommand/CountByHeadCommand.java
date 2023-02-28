package commands.concreteCommand;

import allForDragons.Dragon;
import allForDragons.DragonsCollection;
import commands.Command;
import commands.Executor;

public class CountByHeadCommand implements Command {

    @Override
    public void execute() {

        if (Executor.split.length == 2) {
            double eyesCount = Double.parseDouble(Executor.split[1]);
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
}