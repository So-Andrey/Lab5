package exceptions;

public class RecursionException extends Exception {
    public RecursionException() {
        super("Вы попали в бесконечную рекурсию!");
    }
}