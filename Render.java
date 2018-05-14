package Cracking_Coding_Interview;

import java.util.Arrays;

public class Render {
	public static void main(String[] args) {
		int[] screen = {58, 211, 111, 90, 248, 124, 27, 226, 39, 43, 124, 183, 182, 141, 133, 12, 233, 227, 27, 103, 216, 14, 187, 200, 22, 115, 28, 50, 132, 174, 173, 105, 203, 231, 134, 21, 129, 46, 108, 241, 196};
		Render render = new Render();
		int[] res = render.renderPixel(screen, 194, 313);
		Arrays.stream(res).forEach(System.out::println);
	}

	public int[] renderPixel(int[] screen, int x, int y) {
		for (int i = x; i <= y; i++) {
			int k = i % 8;
			int t = i / 8;
			screen[t] = screen[t] | (1 << k);
		}

		return screen;
	}
}
