package commands.concreteCommand;

import commands.Command;
import commands.Invoker;

public class HelpCommand implements Command {

    @Override
    public void execute() {
        if (Invoker.getSplit().length == 1) {
            for (Command command : Invoker.getCommandHashMap().values()) {
                System.out.println(command.description());
            }
        } else {
            System.out.println("Неверная команда");
        }
    }

    @Override
    public String description() {
        return "help : вывести справку по доступным командам";
    }
}