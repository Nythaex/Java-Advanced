package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private Person[] ELEMENTS;
    Person FIRST_PERSON = new Person(791, "Nikola");
    Person SECOND_PERSON = new Person(123, "Ivan");
    private Database DATABASE;


    @Before
    public void setup()  {
        this.ELEMENTS = new Person[]{FIRST_PERSON, SECOND_PERSON};
        try {
            DATABASE = new Database(ELEMENTS);
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void when_MakeAnInstance() {
        Database database = null;
        try {
            database = new Database(FIRST_PERSON, SECOND_PERSON);
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
        assertArrayEquals(ELEMENTS, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_MakeAnInstanceFails() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test
    public void when_AddingAPerson() throws OperationNotSupportedException {
        Person newPerson = new Person(111, "Kiro");
        this.DATABASE.add(newPerson);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_AddingAPersonFailsBcOfProvidedNegativeOrNullID() throws OperationNotSupportedException {
        Person newPerson = null;
        this.DATABASE.add(newPerson);

    }

    @Test
    public void when_RemovingPerson() throws OperationNotSupportedException {
        int index = DATABASE.getElements().length - 1;
        this.DATABASE.remove();
        assertEquals(index - 1, DATABASE.getElements().length - 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_RemovingPersonFails() throws OperationNotSupportedException {
        this.DATABASE = new Database(FIRST_PERSON);
        this.DATABASE.remove();
        this.DATABASE.remove();
    }

    @Test
    public void when_FindByUsername() throws OperationNotSupportedException {
        this.DATABASE = new Database(FIRST_PERSON, SECOND_PERSON);
        Person found = DATABASE.findByUsername("Nikola");
        assertEquals(found, FIRST_PERSON);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_FindByUsernameFailBcOfNoPersonWithSameUsername() throws OperationNotSupportedException {
        this.DATABASE = new Database(FIRST_PERSON, SECOND_PERSON);
        Person found = DATABASE.findByUsername("NoUsername");

    }
    @Test(expected = OperationNotSupportedException.class)
    public void when_FindByUsernameFailBcOfNullProvidedUsername() throws OperationNotSupportedException {
        this.DATABASE = new Database(FIRST_PERSON, SECOND_PERSON);
        Person found = DATABASE.findByUsername(null);

    }
    @Test(expected = OperationNotSupportedException.class)
    public void when_FindByIDFailBcOfNoPersonWithSameID() throws OperationNotSupportedException {
        this.DATABASE = new Database(FIRST_PERSON, SECOND_PERSON);
        Person found = DATABASE.findById(00000);

    } @Test
    public void when_FindByID() throws OperationNotSupportedException {
        this.DATABASE = new Database(FIRST_PERSON, SECOND_PERSON);
        Person found = DATABASE.findById(123);
        assertEquals(found.getId(),123);

    }
}
