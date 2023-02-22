package commands.concreteCommand;

import commands.Command;
import commands.Executor;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        Executor.programRunning = 0;
    }
}