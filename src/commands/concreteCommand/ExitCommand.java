package commands.concreteCommand;

import commands.Command;
import commands.Invoker;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        if (Invoker.split.length == 1) {
            Invoker.programRunning = false;
        } else {
            System.out.println("Неверная команда");
        }
    }

    @Override
    public String description() {
        return "exit : завершить программу (без сохранения в файл)";
    }
}