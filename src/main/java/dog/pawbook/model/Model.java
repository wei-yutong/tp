package dog.pawbook.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import dog.pawbook.commons.core.GuiSettings;
import dog.pawbook.model.managedentity.Entity;
import javafx.collections.ObservableList;
import javafx.util.Pair;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Pair<Integer, Entity>> PREDICATE_SHOW_ALL_ENTITIES = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /**
     * Returns the AddressBook
     */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a owner with the same identity as {@code owner} exists in the address book.
     */
    boolean hasEntity(Entity entity);
    boolean hasEntity(int id);

    /**
     * Deletes the given owner.
     * The owner must exist in the address book.
     */
    void deleteEntity(int targetId);

    /**
     * Adds the given owner.
     * {@code owner} must not already exist in the address book.
     */
    void addEntity(Entity entity);

    /**
     * Replaces the given owner {@code targetId} with {@code editedOwner}.
     * {@code targetId} must exist in the address book.
     * The owner identity of {@code editedOwner} must not be the same as another existing owner in the address book.
     */
    void setEntity(int targetId, Entity editedEntity);

    /**
     * Returns an unmodifiable view of the filtered owner list
     */
    ObservableList<Pair<Integer, Entity>> getFilteredEntityList();

    /**
     * Updates the filter of the filtered owner list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredEntityList(Predicate<Pair<Integer, Entity>> predicate);
}
