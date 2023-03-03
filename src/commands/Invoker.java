package commands;

import allForDragons.DragonsCollection;
import commands.concreteCommand.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;

public class Invoker {

    public static boolean programRunning = true;

    public static String[] split;

    public static String file;

    public static void invoker(String[] args) throws FileNotFoundException {

        if (args.length == 1) {

            if (args[0].endsWith(".csv")) {

                file = args[0];

                if (new File(file).canRead() & new File(file).exists()) {

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

                    while (programRunning) {
                        try {
                            try {
                                split = scanner.nextLine().split(" ");
                            } catch (NoSuchElementException noSuchElementException) {
                                System.out.println("Неверный ввод, перезапустите программу");
                                programRunning = false;
                            }
                            commandHashMap.get(split[0]).execute();
                        } catch (NullPointerException nullPointerException) {
                            if (programRunning) { System.out.println("Неверная команда"); }
                        }
                    }
                } else {
                    System.out.println("Нет доступа к файлу");
                }
            } else {
                System.out.println("Неверное расширение файла");
            }
        } else {
            System.out.println("Неверно указано имя файла");
        }
    }
}