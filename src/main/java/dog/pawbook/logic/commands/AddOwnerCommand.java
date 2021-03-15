package dog.pawbook.logic.commands;

import static dog.pawbook.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static dog.pawbook.logic.parser.CliSyntax.PREFIX_EMAIL;
import static dog.pawbook.logic.parser.CliSyntax.PREFIX_NAME;
import static dog.pawbook.logic.parser.CliSyntax.PREFIX_PHONE;
import static dog.pawbook.logic.parser.CliSyntax.PREFIX_TAG;
import static java.util.Objects.requireNonNull;

import dog.pawbook.logic.commands.exceptions.CommandException;
import dog.pawbook.model.Model;
import dog.pawbook.model.managedentity.owner.Owner;

/**
 * Adds a owner to the address book.
 */
public class AddOwnerCommand extends AddCommand {

    public static final String ENTITY_WORD = "owner";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a owner to the address book. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_PHONE + "PHONE "
            + PREFIX_EMAIL + "EMAIL "
            + PREFIX_ADDRESS + "ADDRESS "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " " + ENTITY_WORD + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_PHONE + "98765432 "
            + PREFIX_EMAIL + "johnd@example.com "
            + PREFIX_ADDRESS + "311, Clementi Ave 2, #02-25 "
            + PREFIX_TAG + "friends "
            + PREFIX_TAG + "owesMoney";

    public static final String MESSAGE_SUCCESS = String.format(MESSAGE_SUCCESS_FORMAT, ENTITY_WORD);
    public static final String MESSAGE_DUPLICATE_OWNER = "This owner already exists in the address book";

    private final Owner toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Owner}
     */
    public AddOwnerCommand(Owner owner) {
        requireNonNull(owner);
        toAdd = owner;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddOwnerCommand // instanceof handles nulls
                && toAdd.equals(((AddOwnerCommand) other).toAdd));
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasOwner(toAdd)) {
            throw new CommandException(AddOwnerCommand.MESSAGE_DUPLICATE_OWNER);
        }

        model.addOwner(toAdd);
        return new CommandResult(AddOwnerCommand.MESSAGE_SUCCESS + toAdd);
    }
}