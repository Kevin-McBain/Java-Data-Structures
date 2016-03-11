package sort;
import list.*;

public class BinarySearch<E extends Comparable> {
	List<E> list;
	
	public BinarySearch(List<E> list) {
		this.list = list;
		}

	public int BinarySearch(List<E> list, E target)
	{
		this.list = list;
		return binSrch(0, list.size()-1, target);
	}
	
	private int binSrch(int start, int end, E target)
	{
		if (start > end)
		{
			return -1;
		}
		
		int mid = (start + end)/2;
		int cmp = target.compareTo(list.get(mid));
		if(cmp == 0)
		{
			return mid;
		}
		if(cmp < 0)
		{
			return binSrch(start, mid-1, target);
		}
		return binSrch(mid +1, end, target);
	}

	public int search(E target) {
		return binSrch(0, list.size()-1, target);
	}
}
