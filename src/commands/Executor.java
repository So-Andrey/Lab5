package commands;

import commands.concreteCommand.*;

import java.util.HashMap;
import java.util.Scanner;

public class Executor {

    public static int programRunning = 1;

    public static void executor() {

        System.out.println("help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n" +
                "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный\n" +
                "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                "filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки\n" +
                "print_ascending : вывести элементы коллекции в порядке возрастания\n" +
                "print_descending : вывести элементы коллекции в порядке убывания");

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

                Command command = commandHashMap.get(scanner.nextLine());
                command.execute();

            } catch (Exception exception) {

                System.out.println("Неверная команда");

            }
        }
    }
}