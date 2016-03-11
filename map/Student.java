package map;

public class Student implements Comparable<Student> {

	String name;
	String id;
	double GPA;

	public Student(String name, String id, double gpa) {
		this.id = id;
		this.name = name;
		this.GPA = gpa;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Student)) {
			return false;
		}
		Student student = (Student) obj;
		return this.id.equals(student.id);
	}

	public int hashCode() {
		return id.hashCode();
	}

	public int compareTo(Student other) {
		if(this.id.equals(other.id))
		{
			return 0;
		}
		else return this.id.compareTo(other.id);

	}

	public String toString() {
		return name + ", ID: " + id + ", GPA: " + GPA;
	}

}
