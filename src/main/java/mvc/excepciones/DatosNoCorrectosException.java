package mvc.excepciones;

public class DatosNoCorrectosException extends RuntimeException {
    public DatosNoCorrectosException(String message) {
        super(message);
    }
}
