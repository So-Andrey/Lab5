package commands.concreteCommand;

import commands.Command;
import commands.Executor;

public class RemoveByIdCommand implements Command {
    @Override
    public void execute() {

        if (Executor.split.length == 2) {

            long id = Long.parseLong(Executor.split[1]);

            System.out.println(id);

        } else {
            System.out.println("Неверная команда");
        }
    }
}