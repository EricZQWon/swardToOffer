package Cracking_Coding_Interview;

public class Box {


	public int getHeight(int[] w, int[] l, int[] h, int n) {
		// write code here
		if (n <= 0) {
			return 0;
		}
		//sort
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (w[i] < w[j]) {
					swap(w, i, j);
					swap(l, i, j);
					swap(h, i, j);
				}
			}
		}
		//get height
		int[] max = new int[n];
		max[0] = h[0];
		int result = max[0];    //极端情况，即第一种高度已经大于剩下可用情况之和
		for (int index = 1; index < n; index++) {
			max[index] = h[index];
			//局部最优解
			int tempMax = 0;
			for (int j = index - 1; j >= 0; j--) {
				//前面的w条件也可以是w[index]>w[j] 主要是用于排除=的情况，本题相等也不满足条件
				//要求必须是大于
				if (w[j] != w[index] && l[j] > l[index]) {
					tempMax = Math.max(tempMax, max[j]);
				}

			}
			max[index] += tempMax;
			result = (result > max[index]) ? result : max[index];
		}
		return result;
	}

	public void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

	public static void main(String[] args) {
		//20722
		int[] w = {
				2768, 542, 832, 844, 2920, 587, 72, 1724, 447, 809
				, 672, 2393, 1235, 2775, 273, 1165, 1809,
				111, 1263, 2751, 1068, 2507, 453, 65, 2338, 1103, 1093, 2327, 1995, 1125, 2340, 1133, 2123, 1692, 2215, 140, 1822, 2144, 2240, 2916, 1860, 2226, 698, 846, 2177, 295};
		int[] l = {
				821, 2593, 1581, 2891, 2853, 1662, 2747, 2856, 2178, 865, 383, 523, 809, 998, 312, 237, 1871, 2730, 823, 676, 568, 1839, 2063, 1651, 2704, 2113, 1316, 2892, 1874, 270, 1112, 869, 1099, 1876, 371, 2298, 2070, 1514, 2916, 165, 1043, 1355, 2852, 1319, 1979, 1961};
		int[] h = {
				771, 2963, 1599, 1910, 2317, 2884, 872, 2463, 949, 341, 2718, 1500, 1071, 539, 2463, 1355, 104, 2989, 1240, 240, 981, 0, 2172, 3011, 621, 681, 1178, 2518, 2766, 615, 460, 2399, 2443, 2894, 799, 1726, 2454, 2099, 2279, 2911, 2018, 426, 2896, 224, 2663, 351};
		Box box = new Box();
		System.out.println(box.getHeight(w, l, h, 46));

	}

}
