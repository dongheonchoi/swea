package ssafy_08_24;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQtest {

	public static void main(String[] args) {
//		PriorityQueue<Person> pq = new PriorityQueue<>(new NameComparator());

		//익명 클래스 : 객체를 한번만 생성해서 사용할 때 주로 사용
		PriorityQueue<Person> pq = new PriorityQueue<>(new Comparator<Person>() {
		
			@Override
			public int compare(Person o1, Person o2) {
				if (o1.age == o2.age) {
					return o1.name.compareTo(o2.name);
				}
				
				return o1.age - o2.age;
			}
		});
		
		
		
		
		pq.offer(new Person("아아" , 20));
		pq.offer(new Person("라라" , 10));
		pq.offer(new Person("나나" , 25));
		pq.offer(new Person("가가" , 34));
		pq.offer(new Person("가나" , 16));
		pq.offer(new Person("다라" , 9));
		
		while(!pq.isEmpty()) {
		System.out.println(pq.poll());
		}
	}

}
