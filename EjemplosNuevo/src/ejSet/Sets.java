package ejSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Sets {
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		Set<Integer> setFinal = new HashSet<Integer>();

		for (int i = 0; i < 5; i++) {

			set1.add(i);
		}
		for (int i = 3; i < 8; i++) {

			set2.add(i);
		}
		for (Integer integer : set1) {
			for (Integer integer2 : set2) {
				if (setFinal.contains(integer2)) {
					setFinal.remove(integer2);
				} else {
					setFinal.add(integer2);
				}
			}
			if (setFinal.contains(integer)) {
				setFinal.remove(integer);
			} else {
				setFinal.add(integer);
			}
		}
		System.out.println(setFinal);
	}
}
