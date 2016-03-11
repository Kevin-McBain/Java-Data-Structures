package recursion;

import java.util.*;

/**
 * Maintain email addresses, with aliases.
 * 
 * @author (sdb)
 * @author (Kevin McBain)
 */
public class EmailAddresses {
	private Map<String, Set<String>> book;

	public EmailAddresses() {
		book = new HashMap<String, Set<String>>();
	}

	/** Associate the given alias with the given people */
	public void add(String alias, Set<String> people)
	// Add this entry to the map
	{
		book.put(alias, people);
	}

	/**
	 * @return All the email addresses corresponding to the given alias, in a
	 *         Set.
	 */
	public Set<String> expandAlias(String alias) {

		Set<String> result = new HashSet<String>(); // instantiate empty HashSet

		if (book.containsKey(alias)) {
			Iterator<String> itty = book.get(alias).iterator();
			while (itty.hasNext()) {
				String temp = (String) itty.next();
				if (book.containsKey(temp)) {
					result.addAll(expandAlias(temp));
				} else {
					result.add(temp);
				}
			}
		} else {
			result.add(alias);
		}
		return result;

	}
}