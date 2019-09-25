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
     * Dijkstra���·����
     * ��ͼ��"�ڵ�vs"�����������ڵ�����·����
     * @param vs ��ʼ�ڵ�
     * @param Graph ͼ
     */
    public static void dijkstra(int vs, int[][] Graph, int vk) {
        int NUM = Graph[0].length;
        // ǰ���ڵ�����
        int[] prenode = new int[NUM];
        // ��̾�������
        int[] mindist = new int[NUM];
        // �ýڵ��Ƿ��Ѿ��ҵ����·��
        boolean[] find = new boolean[NUM];
         
        int vnear = 0;
        //��ʼ�� 
        for (int i = 0; i < mindist.length; i++) {
            prenode[i] = vs;
            mindist[i] = Graph[vs][i];
            find[i] = false;
        }
 
        find[vs] = true;

        for (int v = 1; v < Graph.length; v++) {
 
            // ÿ��ѭ����þ���vs����Ľڵ�vnear����̾���min
            int min = N;
            for (int j = 0; j < Graph.length; j++) {
                if (!find[j] && mindist[j] < min) {
                    min = mindist[j];
                    vnear = j;
                }
            }
            find[vnear] = true;

            // ����vnear����vs���������нڵ��ǰ���ڵ㼰����
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