package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class UtilsTest {
	@Test
	public void emptyInput(){
		final Object obj = null;
		assertTrue(Utils.isAnyNull(obj));
	}
	
	@Test
	public void nonEmptyInput(){
		final Object obj = new Object();
		assertFalse(Utils.isAnyNull(obj));
	}

	@Test
	public void identicalInput(){
		final ArrayList<Integer> nonUnique = new ArrayList<Integer>(Arrays.asList(1,1,3,4,5));
		assertFalse(Utils.elementsAreUnique(nonUnique));
	}
	
	@Test
	public void nonIdenticalInput(){
		final ArrayList<Integer> unique = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		assertTrue(Utils.elementsAreUnique(unique));
	}
}