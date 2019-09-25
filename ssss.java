package sss;

public class ssss {
 
    private static int N = 1000;
    private static int[][] Graph = {
            { 0, 1, N, 5 },
            { 1, 0, 1, 3 },
            { N, 1, 0, 1 },
            { 5, 3, 1, 0 } };
 
    public static void main(String[] args) {
        dijkstra(0, Graph, 3);
    }
 
    /**
     * Dijkstra最短路径。
     * 即图中"节点vs"到其它各个节点的最短路径。
     * @param vs 起始节点
     * @param Graph 图
     */
    public static void dijkstra(int vs, int[][] Graph, int vk) {
        int NUM = Graph[0].length;
        // 前驱节点数组
        int[] prenode = new int[NUM];
        // 最短距离数组
        int[] mindist = new int[NUM];
        // 该节点是否已经找到最短路径
        boolean[] find = new boolean[NUM];
         
        int vnear = 0;
        //初始化 
        for (int i = 0; i < mindist.length; i++) {
            prenode[i] = vs;
            mindist[i] = Graph[vs][i];
            find[i] = false;
        }
 
        find[vs] = true;

        for (int v = 1; v < Graph.length; v++) {
 
            // 每次循环求得距离vs最近的节点vnear和最短距离min
            int min = N;
            for (int j = 0; j < Graph.length; j++) {
                if (!find[j] && mindist[j] < min) {
                    min = mindist[j];
                    vnear = j;
                }
            }
            find[vnear] = true;

            // 根据vnear修正vs到其他所有节点的前驱节点及距离
            for (int k = 0; k < Graph.length; k++) {
                if (!find[k] && (min + Graph[vnear][k]) < mindist[k]) {
                    prenode[k] = vnear;
                    mindist[k] = min + Graph[vnear][k];
                }
            }

        }
         
        int t = vk;
        while(t != vs) {
        	System.out.println(t);
        	t = prenode[t];
        }
        System.out.println(prenode[t]);
//        for(int m=0;m<prenode.length;m++)
//        	System.out.println(prenode[m]);
    }
}