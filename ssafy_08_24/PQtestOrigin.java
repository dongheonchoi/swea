package ssafy_08_24;

import java.util.PriorityQueue;

public class PQtestOrigin {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		
		pq.offer(100);
		pq.add(2);
		pq.add(3);
		pq.add(4);
		
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
		
		//얘는 최대힙으로  만들고 싶어졌어!
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		
		
		pq.offer(-100);
		pq.add(-2);
		pq.add(-3);
		pq.add(-4);
		
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

}
