package commands;

import commands.concreteCommand.*;

import java.util.HashMap;
import java.util.Scanner;

public class Executor {

    public static int programRunning = 1;

    public static String[] split;

    public static void executor() {

        System.out.println("Введите команду (help : вывести справку по доступным командам)");

        Scanner scanner = new Scanner(System.in);
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
        commandHashMap.put("remove_greater", new RemoveGreater());
        commandHashMap.put("remove_lower", new RemoveLower());
        commandHashMap.put("filter_starts_with_name", new FilterStartsWithNameCommand());
        commandHashMap.put("print_ascending", new PrintAscendingCommand());
        commandHashMap.put("print_descending", new PrintDescendingCommand());

        while (programRunning == 1) {

            try {

                split = scanner.nextLine().split(" ");
                Command command = commandHashMap.get(split[0]);
                command.execute();

            } catch (Exception exception) {

                System.out.println("Неверная команда");

            }
        }
    }
}