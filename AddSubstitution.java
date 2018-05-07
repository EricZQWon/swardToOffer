package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/4/3.
 */
public class AddSubstitution {
	public static final int MULTI = 1;
	public static final int DIVIDE = 0;
	public static final int Reduction = -1;

	public int calc(int a, int b, int type) {
		// write code here
		int result = 0;
		switch (type) {
			case MULTI: {
				int x = 0;
				while (x < b) {
					x++;
					result += a;
				}
			}
			break;
			case DIVIDE: {
				for (int i = 1; i < a; i++) {
					if (dividNum(i, a, b)) {
						result = i;
					} else
						return result;
				}
			}
			break;
			case Reduction: {
				result = a + (~b) + 1;
				return result;
			}
		}
		return result;
	}

	public boolean dividNum(int x, int a, int b) {
		int result = 0;
		while (b > 0) {
			result += x;
			b--;
		}
		return result < a;
	}

	public static void main(String[] args) {
		System.out.println(new AddSubstitution().calc(9082, 2801, 0));
	}
}
