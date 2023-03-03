package commands.concreteCommand;

import commands.Command;
import commands.Invoker;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        if (Invoker.split.length == 1) {
            Invoker.programRunning = 0;
        } else {
            System.out.println("Неверная команда");
        }
    }
}