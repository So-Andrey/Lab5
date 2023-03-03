package commands.concreteCommand;

import commands.Command;
import commands.Executor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ExecuteScriptCommand implements Command {

    @Override
    public void execute() {

        if (Executor.split.length == 2) {
            String file = Executor.split[1];
            try {
                if (new File(file).exists() & new File(file).canRead()) {

                    HashMap<String, Command> commandHashMap = new HashMap<>();
                    commandHashMap.put("help", new HelpCommand());
                    commandHashMap.put("info", new InfoCommand());
                    commandHashMap.put("show", new ShowCommand());
                    commandHashMap.put("add", new AddCommand());
                    commandHashMap.put("update", new UpdateCommand());
                    commandHashMap.put("remove_by_id", new RemoveByIdCommand());
                    commandHashMap.put("clear", new ClearCommand());
                    commandHashMap.put("save", new SaveCommand());
                    commandHashMap.put("execute_script", new ExecuteScriptCommand());
                    commandHashMap.put("exit", new ExitCommand());
                    commandHashMap.put("add_if_min", new AddIfMinCommand());
                    commandHashMap.put("remove_greater", new RemoveGreaterCommand());
                    commandHashMap.put("remove_lower", new RemoveLowerCommand());
                    commandHashMap.put("max_by_head", new MaxByHeadCommand());
                    commandHashMap.put("count_by_head", new CountByHeadCommand());
                    commandHashMap.put("print_ascending", new PrintAscendingCommand());

                    Scanner scanner = new Scanner(new File(file));
                    while (scanner.hasNext()) {
                        Executor.split = scanner.nextLine().split(" ");
                        try {
                            if (!(Executor.split.length == 2 & Executor.split[0].equals("execute_script"))) {
                                commandHashMap.get(Executor.split[0]).execute();
                            } else {
                                if (!(new File(file).getAbsolutePath().equals(new File(Executor.split[1]).getAbsolutePath()))) {
                                    commandHashMap.get(Executor.split[0]).execute();
                                } else {
                                    System.out.println("Неверная команда");
                                }
                            }
                        } catch (NullPointerException ignored) {}
                    }
                } else {
                    System.out.println("Нет доступа к файлу");
                }
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("Файл не найден");
            }
        } else {
            System.out.println("Неверная команда");
        }
    }
}