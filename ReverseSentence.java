package SwardToOffer;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dell on 2018/1/9.
 */
public class ReverseSentence {
	//19ms 8.9K AC
	public String ReverseSentence(String str) {
		LinkedList<StringBuilder> queue=new LinkedList<>();
		StringBuilder stringBuilder=new StringBuilder();
		for(int index=0;index<str.length();index++){
			if(str.charAt(index)!=' '){
				stringBuilder.append(str.charAt(index));
			}else {

				queue.add(stringBuilder);
				stringBuilder=new StringBuilder();
			}
		}
		queue.add(stringBuilder);
		Iterator<StringBuilder> iterator=queue.descendingIterator();
		stringBuilder=new StringBuilder();
		while (iterator.hasNext()){
			stringBuilder.append(iterator.next()+" ");
		}
		stringBuilder.deleteCharAt(stringBuilder.length()-1);
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		String s="I am a Student";
		ReverseSentence reverseSentence=new ReverseSentence();
		System.out.println(reverseSentence.ReverseSentence(s));
	}
}
