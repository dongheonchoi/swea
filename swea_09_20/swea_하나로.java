package swea_09_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class weight {
	int n1;
	int n2;
	Double dist;

	public weight(int n1, int n2, Double dist) {
		this.n1 = n1;
		this.n2 = n2;
		this.dist = dist;
	}
}

public class swea_하나로 {
	static int[] nod;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {
			int N = Integer.parseInt(br.readLine());

			nod = new int[N];

			for (int i = 0; i < N; i++) {
				nod[i] = i;
			}

			int[][] arr1 = new int[2][N];

			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr1[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Double E = Double.parseDouble(br.readLine());

			weight[] wei = new weight[N * (N - 1) / 2];
			int idx = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					weight w = new weight(i, j,
							Math.pow((arr1[0][i] - arr1[0][j]), 2) + Math.pow((arr1[1][i] - arr1[1][j]), 2));
					wei[idx] = w;
					idx++;
				}
			}
			Arrays.sort(wei, (w1, w2) -> w1.dist.compareTo(w2.dist));

			int cnt = 0;
			Double sum = 0.0;
			for (int i = 0; i < N * (N - 1) / 2; i++) {
				weight w = wei[i];
				if (find(w.n1) != find(w.n2)) {
					union(w.n1, w.n2);
					sum += w.dist;
					cnt++;
				}
				if (cnt == N - 1) {
					break;
				}
			}

			sb.append("#" + tc + " " + Math.round(sum * E) + "\n");

		}
		System.out.println(sb);
	}

	static int find(int a) {
		if (nod[a] == a) {
			return a;
		} else {
			return find(nod[a]);
		}

	}

	static void union(int a, int b) {
		int aa = find(a);
		int bb = find(b);

		if (aa > bb) {
			nod[aa] = bb;
		} else {
			nod[bb] = aa;
		}

	}

}
