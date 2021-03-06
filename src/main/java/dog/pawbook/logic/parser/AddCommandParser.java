package dog.pawbook.logic.parser;

/**
 * Simple wrapper for process method.
 */
public class AddCommandParser {
    public AddOwnerCommandParser process(String entityType){
        if (entityType.equals("owner")) {
            return new AddOwnerCommandParser();
        } else { // to implement dogs / programs eventually
            return null;
        }
    }
}
