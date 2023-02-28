package commands.concreteCommand;

import allForDragons.Dragon;
import allForDragons.DragonsCollection;
import commands.Command;
import commands.Executor;

public class RemoveByIdCommand implements Command {
    @Override
    public void execute() {

        if (Executor.split.length == 2) {

            long id = Long.parseLong(Executor.split[1]);
            boolean dragonExist = false;

            if (!DragonsCollection.getDragons().isEmpty()) {
                for (Dragon dragon : DragonsCollection.getDragons()) {
                    if (dragon.getId() == id) {
                        DragonsCollection.getDragons().remove(dragon);
                        System.out.println("Дракон успешно удалён");
                        dragonExist = true;
                    }
                }
                if (!dragonExist) {
                    System.out.println("Такого дракона не существует");
                }
            } else {
                System.out.println("Коллекция пуста, такого дракона не существует");
            }
        } else {
            System.out.println("Неверная команда");
        }
    }
}