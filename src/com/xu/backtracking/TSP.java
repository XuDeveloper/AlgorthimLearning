package com.xu.backtracking;

/**
 * 旅行商问题（TSP，DP）
 * <p>
 * 旅行推销员问题,是指一名推销员要拜访多个地点,如何找到再拜访每个地点一次后再回到起点的最短路径.
 * <p>
 * 现在有n个城市，部分城市间有路相连，请找出从第一个城市出发，访问且只访问每个城市一次，并回到第一个城市的最短路径长度
 * <p>
 * Sample Input
 * 4
 * 0 30 6 4
 * 30 0 5 10
 * 6 5 0 20
 * 4 10 20 0
 * <p>
 * Sample Output
 * 25
 */
public class TSP {

    private int cl;
    private int fl;
    private int n = 4;

    private int weight[][] = {
            {0, 30, 6, 4},
            {30, 0, 5, 10},
            {6, 5, 0, 20},
            {4, 10, 20, 0}
    };

    private int x[] = new int[n];
    private int bestX[] = new int[n];

    /**
     * 判断第k个数是否不同与前k-1个数
     * @param k
     * @return bool
     */
    private boolean nextValue(int k){
        int i = 0;
        while(i < k){
            if(x[k] == x[i]){
                return false;
            }
            i += 1;
        }
        return true;
    }

    public void backtrack(int k) {
        if (k == n - 1) {
            for (int j = 1; j <= n; j++) {
                x[k] = Math.floorMod(x[k] + 1, n);
                if (nextValue(k) && cl + weight[x[k - 1]][x[k]] + weight[x[k]][0] < fl) {//如果最短路径,更新最优解
                    fl = cl + weight[x[k - 1]][x[k]] + weight[x[k]][0];
                    for (int i = 0; i < n; i++) {
                        bestX[i] = x[i];
                    }
                }
            }
        } else {
            for (int j = 1; j <= n; j++) {
                x[k] = Math.floorMod(x[k] + 1, n);
                if (nextValue(k) && cl + weight[x[k - 1]][x[k]] <= fl) {
                    //此路可行
                    cl += weight[x[k - 1]][x[k]];
                    backtrack(k + 1);
                    cl -= weight[x[k - 1]][x[k]];
                }
            }

        }
    }

    public void solve() {
        int k = 1; //第0个顶点是固定的,从第一个顶点开始选择
        cl = 0;
        fl = Integer.MAX_VALUE;
        backtrack(k);
        System.out.print(fl);
    }

    public static void main(String[] args) {
        TSP tsp = new TSP();
        tsp.solve();
    }

}
