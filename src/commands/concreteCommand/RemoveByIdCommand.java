package commands.concreteCommand;

import allForDragons.Dragon;
import allForDragons.DragonsCollection;
import commands.Command;
import commands.Invoker;

public class RemoveByIdCommand implements Command {

    private void removerById(long id) {
        boolean dragonExist = false;
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
    }
    @Override
    public void execute() {
        if (Invoker.getSplit().length == 2) {
            long id = Long.parseLong(Invoker.getSplit()[1]);
            if (!DragonsCollection.getDragons().isEmpty()) {
                removerById(id);
            } else {
                System.out.println("Коллекция пуста, такого дракона не существует");
            }
        } else {
            System.out.println("Неверная команда");
        }
    }
    @Override
    public String description() {
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }
}