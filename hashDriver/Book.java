package hashDriver;

public class Book {
	String title;
	String author;
	int pageCount;
	
	public Book(String title, String author, int pageCount)
	{
		this.title = title;
		this.author = author;
		this.pageCount = pageCount;
	}

	public int hashCode()
	{
		int hash = 1;
		hash = hash * 7 + title.hashCode();
		hash = hash * 11 +  author.hashCode();
		
		return hash;
	}
	
	public boolean equals(Object obj)
	{
		Book book;
		if(!(obj instanceof Book))
		{
			return false;
		}
		book = (Book) obj;
		if(book.author.equals(this.author) && book.title.equals(this.title))
		{
			return true;
		}
		else return false;
	}
	
	public String toString()
	{
		return "Author: " + author + ", Title: " + title + ", Pages: " + pageCount;
	}
}
