package ssafy_08_24;


//직접 비교기준을 작성을 해보자.
public class Person implements Comparable<Person> {
	public String name;
	public int age;
	
	public Person() {
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public int compareTo(Person o) {
		// 음수일때 : ? 
		// 아닐때    : ?
//		return  o.age - this.age;
//		return Integer.compare(this.age, o.age);
		return this.name.compareTo(o.name);
	}
	

}
