package commands.concreteCommand;

import allForDragons.*;
import commands.Command;
import commands.Executor;

import java.util.ConcurrentModificationException;

public class RemoveLowerCommand implements Command {
    @Override
    public void execute() {

        if (Executor.split.length == 2) {

            long id = Long.parseLong(Executor.split[1]);
            int countOfDragons = 0;
            boolean dragonExist = false;

            if (!DragonsCollection.getDragons().isEmpty()) {
                long age = 0;
                for (Dragon dragon : DragonsCollection.getDragons()) {
                    if (dragon.getId() == id) {
                        dragonExist = true;
                        age = dragon.getAge();
                    }
                }
                if (dragonExist) {
                    try {
                        for (Dragon dragon : DragonsCollection.getDragons()) {
                            if (dragon.getAge() < age) {
                                DragonsCollection.getDragons().remove(dragon);
                                ++countOfDragons;
                            }
                        }
                    } catch (ConcurrentModificationException ignored) {} //TODO исключение + удаляет на один меньше чем надо решил - компаратор
                } else {
                    System.out.println("Заданного дракона не существует");
                }
                if (countOfDragons != 0) {
                    System.out.println("Количество удалённых драконов " + countOfDragons);
                } else {
                    System.out.println("Драконов младше заданного не существует");
                }
            } else {
                System.out.println("Коллекция пуста, заданного дракона не существует");
            }
        } else {
            System.out.println("Неверная команда");
        }
    }
}
