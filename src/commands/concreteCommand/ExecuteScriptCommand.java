package commands.concreteCommand;

import commands.Command;
import commands.Invoker;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExecuteScriptCommand implements Command {

    private void executorFromFile(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));
        while (scanner.hasNext()) {
            Invoker.setSplit(scanner.nextLine().split(" "));
            try {
                if (!(Invoker.getSplit().length == 2 & Invoker.getSplit()[0].equals("execute_script"))) {
                    Invoker.getCommandHashMap().get(Invoker.getSplit()[0]).execute();
                } else {
                    if (!(new File(file).getAbsolutePath().equals(new File(Invoker.getSplit()[1]).getAbsolutePath()))) {
                        Invoker.getCommandHashMap().get(Invoker.getSplit()[0]).execute();
                    } else {
                        System.out.println("Неверная команда");
                    }
                }
            } catch (NullPointerException ignored) {}
        }
        scanner.close();
    }
    @Override
    public void execute() {
        if (Invoker.getSplit().length == 2) {
            String file = Invoker.getSplit()[1];
            try {
                if (new File(file).exists() & new File(file).canRead()) {
                    executorFromFile(file);
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
    @Override
    public String description() {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит";
    }
}