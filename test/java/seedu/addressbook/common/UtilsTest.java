package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {
    @Test
    public void isAnyNull() {
        // empty list
        assertFalse(Utils.isAnyNull());

        // Any non-empty list
        assertFalse(Utils.isAnyNull(new Object(), new Object()));
        assertFalse(Utils.isAnyNull("test"));
        assertFalse(Utils.isAnyNull(""));

        // non empty list with just one null at the beginning
        assertTrue(Utils.isAnyNull((Object) null));
        assertTrue(Utils.isAnyNull(null, "", new Object()));
        assertTrue(Utils.isAnyNull(null, new Object(), new Object()));

        // non empty list with nulls in the middle
        assertTrue(Utils.isAnyNull(new Object(), null, null, "test"));
        assertTrue(Utils.isAnyNull("", null, new Object()));

        // non empty list with one null as the last element
        assertTrue(Utils.isAnyNull("", new Object(), null));
        assertTrue(Utils.isAnyNull(new Object(), new Object(), null));

        assertListNotNull();
    }

    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);
        assertAreUnique("123", "456");
        assertAreUnique("abc", "ABC");

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);

        assertListUnique();

    }

    /**
     * Confirms that strings inside list are not considered for uniqueness
     *
     */
    private void assertListUnique() {
        // confirms that objects inside lists are not counted as unique
        List<Object> uniqueList = Arrays.asList("abc", "abc");
        assertAreUnique(Utils.elementsAreUnique(uniqueList));
    }

    /**
     * Confirms that null inside list is not considered
     *
     */
    private void assertListNotNull() {
        // confirms nulls inside the list are not considered
        List<Object> nullList = Arrays.asList((Object) null);
        assertFalse(Utils.isAnyNull(nullList));
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

}
