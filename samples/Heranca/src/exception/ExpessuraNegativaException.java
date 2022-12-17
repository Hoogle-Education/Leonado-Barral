package exception;

public class ExpessuraNegativaException extends RuntimeException {

    public ExpessuraNegativaException() {
        super("A espessura passada tinha tamanho negativo");
    }

    public ExpessuraNegativaException(String message) {
        super(message);
    }
}
