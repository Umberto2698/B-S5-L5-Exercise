package exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(long id) {
        super("Il record con l'id " + id + " non è stato trovato!");
    }
}
