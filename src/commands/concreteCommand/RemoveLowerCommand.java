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

            if (DragonsCollection.getDragons().size() != 0) {
                for (Dragon dragon : DragonsCollection.getDragons()) {
                    if (dragon.getId() == id) {
                        for (Dragon dragon1 : DragonsCollection.getDragons()) {
                            if (dragon1.getAge() < dragon.getAge()) {
                                DragonsCollection.getDragons().remove(dragon1);
                                ++countOfDragons;
                            }
                        }
                    } else {
                        System.out.println("Заданного дракона не существует");
                    }
                    if (countOfDragons != 0) {
                        System.out.println("Успешно удалено " + countOfDragons + " драконов");
                    } else {
                        System.out.println("Драконов младше заданного не существует");
                    }
                }
            } else {
                System.out.println("Коллекция пуста, заданного дракона не существует");
            }
        } else {
            System.out.println("Неверная команда"); //TODO troubles
        }
    }
}
