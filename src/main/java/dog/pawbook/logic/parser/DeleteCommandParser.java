package dog.pawbook.logic.parser;

/**
 * Simple wrapper for process method.
 */
public class DeleteCommandParser {
    public DeleteOwnerCommandParser process(String entityType){
        if (entityType.equals("owner")) {
            return new DeleteOwnerCommandParser();
        } else { // to implement dogs / programs eventually
            return null;
        }
    }
}
