package project1;

import java.util.*;

public interface ReversibleIterator<T> extends Iterator<T> {
	
	public boolean hasPrevious(); // return true if a previous element can be returned

	public T previous(); // return the previous element

}
