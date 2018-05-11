package Cracking_Coding_Interview;

/**
 * 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，
 * 能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串重点空格。
 * 给定一个string stringA和一个string stringB，请返回一个bool，
 * 代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
 */
public class Same {
	// AC
	public boolean checkSam(String stringA, String stringB) {
		//键索引计数法
		char[] keyIndex = new char[256];
		if (stringA.length() != stringB.length())
			return false;

		for (int i = 0; i < stringA.length(); i++) {
			keyIndex[stringA.charAt(i)]++;
			keyIndex[stringB.charAt(i)]--;
		}

		//如果相当，则索引数组每个的值都应当是0
		int count = 0;
		for (int i = 0; i < keyIndex.length; i++) {
			count += keyIndex[i];
		}
		return count == 0;
	}

	public static void main(String[] args) {
		String a = "Here you are";
		String b = "Are you here";
		Same same = new Same();
		System.out.println(same.checkSam(a, b));
	}
}
