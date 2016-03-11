package hash;
import list.*;

public class TableIterator<K> implements Iterator<K>{

	HashTable<K> table;
	Iterator<K> itty;
	int index = 0;
	
	TableIterator(HashTable<K> table)
	{
		this.table = table;
		setItty(0);
	}
	private void setItty(int index) {
		itty = table.table.get(index).iterator();
	}

	public boolean hasNext() {
		if(itty.hasNext())
		{
			return true;
		}
		for(index++; index < table.table.size(); index++)
		{
			if(!(table.table.get(index).isEmpty()))
			{
				setItty(index);
				return true;
			}
		}
		return false;
	}

	public K next() {
		hasNext();
		return itty.next();
	}

	public void remove() {
		itty.remove();
		table.keyCount--;
		
	}

}
