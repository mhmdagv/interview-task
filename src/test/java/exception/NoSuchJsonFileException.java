package exception;

public class NoSuchJsonFileException extends RuntimeException{
    public NoSuchJsonFileException(String s){
        super(s);
    }
}
