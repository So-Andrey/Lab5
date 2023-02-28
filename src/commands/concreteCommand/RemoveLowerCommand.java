package commands.concreteCommand;

import allForDragons.*;
import commands.Command;
import commands.Executor;

public class RemoveLowerCommand implements Command {
    @Override
    public void execute() {

        if (Executor.split.length == 2) {

            long id = Long.parseLong(Executor.split[1]);
            int countOfDragons = 0;

            if (DragonsCollection.dragons.size() != 0) {
                for (Dragon dragon : DragonsCollection.dragons) {
                    if (dragon.getId() == id) {
                        for (Dragon dragon1 : DragonsCollection.dragons) {
                            if (dragon1.getAge() < dragon.getAge()) {
                                DragonsCollection.dragons.remove(dragon1);
                                ++countOfDragons;
                            } else {
                                if (countOfDragons != 0) {
                                    System.out.println("Успешно удалено " + countOfDragons + " драконов");
                                } else {
                                    System.out.println("Таких драконов не существует");
                                }
                            }
                        }
                    } else {
                        System.out.println("Заданного дракона не существует");
                    }
                }
            } else {
                System.out.println("Неверная команда");
            }
        }
    }
}
