package commands;

import allForDragons.DragonsCollection;
import commands.concreteCommand.*;

import java.util.HashMap;
import java.util.Scanner;

public class Executor {

    public static int programRunning = 1;

    public static String[] split;

    public static String file;

    public static void executor(String[] args) {

        if (args.length == 1) {

            if (args[0].trim().split("\\.")[args[0].split("\\.").length - 1].equals("csv")) {

                file = args[0];
                DragonsCollection.putDragonsFromFile();

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
                commandHashMap.put("remove_greater", new RemoveGreaterCommand());
                commandHashMap.put("remove_lower", new RemoveLowerCommand());
                commandHashMap.put("max_by_head", new MaxByHeadCommand());
                commandHashMap.put("count_by_head", new CountByHeadCommand());
                commandHashMap.put("print_ascending", new PrintAscendingCommand());

                while (programRunning == 1) {
                    try {
                        split = scanner.nextLine().split(" ");
                        Command command = commandHashMap.get(split[0]);
                        command.execute();
                    } catch (Exception exception) {
                        System.out.println("Неверная команда");
                    }
                }
            } else {
                System.out.println("Неверно указано имя файла");
            }
        } else {
            System.out.println("Неверно указано имя файла");
        }
    }
}