

//Name - Mohamed Safan
// UoW no - W1792949
import java.lang.*;
import java.util.*;
import java.util.LinkedList;

public class MaximumFlow {

    static  int V ;
    static boolean bfs(int rGraph[][], int s, int t, int parent[])
    {

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; ++i)
            visited[i] = false;


        LinkedList<Integer> queue
                = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        //  BFS Loop
        while (queue.size() != 0) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                if (visited[v] == false
                        && rGraph[u][v] > 0) {

                    if (v == t) {
                        parent[v] = u;
                        return true;
                    }
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return false;
    }

    static int fordFulkerson(int graph[][], int s, int t)
    {
        int u, v;

        int rGraph[][] = new int[V][V];

        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];


        int parent[] = new int[V];

        int max_flow = 0;


        while (bfs(rGraph, s, t, parent)) {

            int path_flow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow
                        = Math.min(path_flow, rGraph[u][v]);
            }

            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }


            max_flow += path_flow;
        }


        return max_flow;
    }
    public static void main(String[] args) throws java.lang.Exception{



        Scanner input = new Scanner(System.in);

        int method = 0;
        while (true) {


            //OPTIONS TABLE


            System.out.println("⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀WELCOME⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀ ");
            System.out.println("⨀                                       ⨀");
            System.out.println("⨀⨀⨀⨀⨀        ALGORITHM          ⨀⨀⨀⨀⨀");
            System.out.println("⨀                 2021                  ⨀");
            System.out.println("⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀⨀");
            System.out.println("");
            System.out.println("   ⭕         Please choose any Option :   ");

            System.out.println("⨁ Bridge_1------------------------------>  1");
            System.out.println("⨁ Bridge_2 ----------------------------->  2");
            System.out.println("⨁ Bridge_3------------------------------>  3");
            System.out.println("⨁ Bridge_4------------------------------>  4");
            System.out.println("⨁ Bridge_5------------------------------>  5");
            System.out.println("⨁ Bridge_6------------------------------>  6");
            System.out.println("⨁ Bridge_7------------------------------>  7");
            System.out.println("⨁ Bridge_8------------------------------>  8");
            System.out.println("⨁ Bridge_9------------------------------>  9");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("⨁ Ladder_1------------------------------>  11");
            System.out.println("⨁ Ladder_2 ----------------------------->  12");
            System.out.println("⨁ Ladder_3------------------------------>  13");
            System.out.println("⨁ Ladder_4------------------------------>  14");
            System.out.println("⨁ Ladder_5------------------------------>  15");
            System.out.println("⨁ Ladder_6------------------------------>  16");
            System.out.println("⨁ Ladder_7------------------------------>  17");
            System.out.println("⨁ Ladder_8------------------------------>  18");
            System.out.println("⨁ Ladder_9------------------------------>  19");
            System.out.println(" ");

            System.out.println("   ⭕       Please enter your choice  : ");


            method = Integer.parseInt(input.next());
            switch (method) {

                case 1:
                    Bridge_1();
                    break;

                case 2:
                    Bridge_2();
                    break;

                case 3:
                    Bridge_3();
                    break;

                case 4:
                    Bridge_4();
                    break;

                case 5:
                    Bridge_5();
                    break;

                case 6:
                    Bridge_6();
                    break;

                case 7:
                    Bridge_7();
                    break;

                case 8:
                    Bridge_8();
                    break;

                case 9:
                    Bridge_9();
                    break;

                case 11:
                    ladder_1();
                    break;

                case 12:
                    ladder_2();
                    break;

                case 13:
                    ladder_3();
                    break;

                case 14:
                    ladder_4();
                    break;

                case 15:
                    ladder_5();
                    break;

                case 16:
                   ladder_6();
                    break;

                case 17:
                   ladder_7();
                    break;

                case 18:
                    ladder_8();
                    break;

                case 19:
                    ladder_9();
                    break;


                default:
                    System.out.println("Invalid Option");
                    break;
            }
            if (method == 0) {
                input.close();
                System.exit(0);
            }
        }
    }


    private static void Bridge_1(){

        long start = System.currentTimeMillis();
   int numberOfNodes = 0;
        In in = new In("Bridge_1.txt");
        int i,j ,k;

        int[] a = in.readAllInts();
        numberOfNodes=a[0] ;
        V=a[0];

        int size  = a.length;
        int s= 0,v = 0,c = 0;
        System.out.println("Nodes " +numberOfNodes);
        int[][] graph=new int[numberOfNodes][numberOfNodes];


        for (i = 1; i < size; i = i + 3) {
            s = a[i];
            v =a[i+1];
            c = a[i +2];
            System.out.println("Edge from node " + s + " to node " + v + " with capacity " + c);
            System.out.println("");
            System.out.println("");

            graph[s][v]=c;


        }
        for (int[] innerArray : graph)
        {
            System.out.println(Arrays.toString(innerArray));
        }

        MaximumFlow m = new MaximumFlow();
        System.out.println("");
        System.out.println("");
        System.out.println("");


        System.out.println("The maximum possible flow is "
                + m.fordFulkerson(graph, 0, numberOfNodes-1));
        System.out.println("");


        long now = System.currentTimeMillis();
        double elapsed = (now - start)/1000.0;

        System.out.println("Elapsed time = " + elapsed + "seconds");
    }



    private static void Bridge_2(){

        long start = System.currentTimeMillis();


        int numberOfNodes = 0;

        In in = new In("Bridge_2.txt");
        int i,j ,k;

        int[] a = in.readAllInts();
        numberOfNodes=a[0] ;
        V=a[0];
        int size  = a.length;

        int s= 0,v = 0,c = 0;
        System.out.println("Nodes " +numberOfNodes);
        int[][] graph=new int[numberOfNodes][numberOfNodes];


        for (i = 1; i < size; i = i + 3) {
            s = a[i];
            v =a[i+1];
            c = a[i +2];
            System.out.println("Edge from node " + s + " to node " + v + " with capacity " + c);
            System.out.println("");
            System.out.println("");
            graph[s][v]=c;


        }
        for (int[] innerArray : graph)
        {
            System.out.println(Arrays.toString(innerArray));
        }

        MaximumFlow m = new MaximumFlow();

        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("The maximum possible flow is "
                + m.fordFulkerson(graph, 0, numberOfNodes-1));
        System.out.println("");

        long now = System.currentTimeMillis();
        double elapsed = (now - start)/1000.0;

        System.out.println("Elapsed time = " + elapsed + "seconds");
    }



    private static void Bridge_3(){
        long start = System.currentTimeMillis();

        int numberOfNodes = 0;

        In in = new In("lBridge_3txt");
        int i,j ,k;

        int[] a = in.readAllInts();
        numberOfNodes=a[0] ;
        V=a[0];
        int size  = a.length;
        int s= 0,v = 0,c = 0;
        System.out.println("Nodes " +numberOfNodes);
        int[][] graph=new int[numberOfNodes][numberOfNodes];


        for (i = 1; i < size; i = i + 3) {
            s = a[i];
            v =a[i+1];
            c = a[i +2];
            System.out.println("Edge from node " + s + " to node " + v + " with capacity " + c);
            System.out.println("");
            System.out.println("");
            graph[s][v]=c;


        }
        for (int[] innerArray : graph)
        {
            System.out.println(Arrays.toString(innerArray));
        }

        MaximumFlow m = new MaximumFlow();

        System.out.println("");
        System.out.println("");
        System.out.println("");


        System.out.println("The maximum possible flow is "
                + m.fordFulkerson(graph, 0, numberOfNodes-1));
        System.out.println("");


        long now = System.currentTimeMillis();
        double elapsed = (now - start)/1000.0;

        System.out.println("Elapsed time = " + elapsed + "seconds");
    }



    private static void Bridge_4(){
        long start = System.currentTimeMillis();

        int numberOfNodes = 0;

        In in = new In("Bridge_4.txt");
        int i,j ,k;

        int[] a = in.readAllInts();
        numberOfNodes=a[0] ;
        V=a[0];
        int size  = a.length;
        int s= 0,v = 0,c = 0;
        System.out.println("Nodes " +numberOfNodes);
        int[][] graph=new int[numberOfNodes][numberOfNodes];


        for (i = 1; i < size; i = i + 3) {
            s = a[i];
            v =a[i+1];
            c = a[i +2];
            System.out.println("Edge from node " + s + " to node " + v + " with capacity " + c);
            System.out.println("");
            System.out.println("");
            graph[s][v]=c;


        }
        for (int[] innerArray : graph)
        {
            System.out.println(Arrays.toString(innerArray));
        }

        MaximumFlow m = new MaximumFlow();

        System.out.println("");
        System.out.println("");
        System.out.println("");


        System.out.println("The maximum possible flow is "
                + m.fordFulkerson(graph, 0, numberOfNodes-1));
        System.out.println("");

        long now = System.currentTimeMillis();
        double elapsed = (now - start)/1000.0;

        System.out.println("Elapsed time = " + elapsed + "seconds");
    }



    private static void Bridge_5(){

        long start = System.currentTimeMillis();
        int numberOfNodes = 0;
        In in = new In("Bridge_5.txt");
        int i,j ,k;

        int[] a = in.readAllInts();
        numberOfNodes=a[0] ;
        V=a[0];
        int size  = a.length;

        int s= 0,v = 0,c = 0;
        System.out.println("Nodes " +numberOfNodes);
        int[][] graph=new int[numberOfNodes][numberOfNodes];


        for (i = 1; i < size; i = i + 3) {
            s = a[i];
            v =a[i+1];
            c = a[i +2];
            System.out.println("Edge from node " + s + " to node " + v + " with capacity " + c);
            System.out.println("");
            System.out.println("");
            graph[s][v]=c;


        }
        for (int[] innerArray : graph)
        {
            System.out.println(Arrays.toString(innerArray));
        }

        MaximumFlow m = new MaximumFlow();

        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("The maximum possible flow is "
                + m.fordFulkerson(graph, 0, numberOfNodes-1));
        System.out.println("");

        long now = System.currentTimeMillis();
        double elapsed = (now - start)/1000.0;

        System.out.println("Elapsed time = " + elapsed + "seconds");
    }



    private static void Bridge_6(){
        long start = System.currentTimeMillis();

        int numberOfNodes = 0;
        int source;
        int sink;
        int maxFlow;
        In in = new In("bridge_6.txt");
        int i,j ,k;

        int[] a = in.readAllInts();
        numberOfNodes=a[0] ;
        V=a[0];
        int size  = a.length;
        int repeat = ((a.length-1)/3);
        int s= 0,v = 0,c = 0;
        System.out.println("Nodes " +numberOfNodes);
        int[][] graph=new int[numberOfNodes][numberOfNodes];


        for (i = 1; i < size; i = i + 3) {
            s = a[i];
            v =a[i+1];
            c = a[i +2];
            System.out.println("Edge from node " + s + " to node " + v + " with capacity " + c);
            System.out.println("");
            System.out.println("");
            graph[s][v]=c;


        }
        for (int[] innerArray : graph)
        {
            System.out.println(Arrays.toString(innerArray));
        }

        MaximumFlow m = new MaximumFlow();
        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("The maximum possible flow is "
                + m.fordFulkerson(graph, 0, numberOfNodes-1));
        System.out.println("");

        long now = System.currentTimeMillis();
        double elapsed = (now - start)/1000.0;

        System.out.println("Elapsed time = " + elapsed + "seconds");
    }



    private static void Bridge_7(){

        long start = System.currentTimeMillis();
        int numberOfNodes = 0;
        int source;
        int sink;
        int maxFlow;
        In in = new In("bridge_7.txt");
        int i,j ,k;

        int[] a = in.readAllInts();
        numberOfNodes=a[0] ;
        V=a[0];
        int size  = a.length;
        int repeat = ((a.length-1)/3);
        int s= 0,v = 0,c = 0;
        System.out.println("Nodes " +numberOfNodes);
        int[][] graph=new int[numberOfNodes][numberOfNodes];


        for (i = 1; i < size; i = i + 3) {
            s = a[i];
            v =a[i+1];
            c = a[i +2];
            System.out.println("Edge from node " + s + " to node " + v + " with capacity " + c);
            System.out.println("");
            System.out.println("");
            graph[s][v]=c;


        }
        for (int[] innerArray : graph)
        {
            System.out.println(Arrays.toString(innerArray));
        }

        MaximumFlow m = new MaximumFlow();

        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("The maximum possible flow is "
                + m.fordFulkerson(graph, 0, numberOfNodes-1));
        System.out.println("");

        long now = System.currentTimeMillis();
        double elapsed = (now - start)/1000.0;

        System.out.println("Elapsed time = " + elapsed + "seconds");
    }



    private static void Bridge_8(){

        long start = System.currentTimeMillis();
        int numberOfNodes = 0;
        int source;
        int sink;
        int maxFlow;
        In in = new In("Bridge_8.txt");
        int i,j ,k;

        int[] a = in.readAllInts();
        numberOfNodes=a[0] ;
        V=a[0];
        int size  = a.length;
        int repeat = ((a.length-1)/3);
        int s= 0,v = 0,c = 0;
        System.out.println("Nodes " +numberOfNodes);
        int[][] graph=new int[numberOfNodes][numberOfNodes];


        for (i = 1; i < size; i = i + 3) {
            s = a[i];
            v =a[i+1];
            c = a[i +2];
            System.out.println("Edge from node " + s + " to node " + v + " with capacity " + c);
            System.out.println("");
            System.out.println("");
            graph[s][v]=c;


        }
        for (int[] innerArray : graph)
        {
            System.out.println(Arrays.toString(innerArray));
        }

        MaximumFlow m = new MaximumFlow();

        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("The maximum possible flow is "
                + m.fordFulkerson(graph, 0, numberOfNodes-1));
        System.out.println("");

        long now = System.currentTimeMillis();
        double elapsed = (now - start)/1000.0;

        System.out.println("Elapsed time = " + elapsed + "seconds");
    }


    private static void Bridge_9(){

        long start = System.currentTimeMillis();
        int numberOfNodes = 0;
        int source;
        int sink;
        int maxFlow;
        In in = new In("Bridge_9.txt");
        int i,j ,k;

        int[] a = in.readAllInts();
        numberOfNodes=a[0] ;
        V=a[0];
        int size  = a.length;
        int repeat = ((a.length-1)/3);
        int s= 0,v = 0,c = 0;
        System.out.println("Nodes " +numberOfNodes);
        int[][] graph=new int[numberOfNodes][numberOfNodes];


        for (i = 1; i < size; i = i + 3) {
            s = a[i];
            v =a[i+1];
            c = a[i +2];
            System.out.println("Edge from node " + s + " to node " + v + " with capacity " + c);
            System.out.println("");
            System.out.println("");
            graph[s][v]=c;

        }

        for (int[] innerArray : graph)
        {
            System.out.println(Arrays.toString(innerArray));
        }

        MaximumFlow m = new MaximumFlow();

        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("The maximum possible flow is "
                + m.fordFulkerson(graph, 0, numberOfNodes-1));
        System.out.println("");

        long now = System.currentTimeMillis();
        double elapsed = (now - start)/1000.0;

        System.out.println("Elapsed time = " + elapsed + "seconds");
    }



    private static void ladder_1(){

        long start = System.currentTimeMillis();

        int numberOfNodes = 0;
        int source;
        int sink;
        int maxFlow;
        In in = new In("ladder_1.txt");
        int i,j ,k;

        int[] a = in.readAllInts();
        numberOfNodes=a[0] ;
        V=a[0];
        int size  = a.length;
        int repeat = ((a.length-1)/3);
        int s= 0,v = 0,c = 0;
        System.out.println("Nodes " +numberOfNodes);
        int[][] graph=new int[numberOfNodes][numberOfNodes];


        for (i = 1; i < size; i = i + 3) {
            s = a[i];
            v =a[i+1];
            c = a[i +2];
            System.out.println("Edge from node " + s + " to node " + v + " with capacity " + c);
            System.out.println("");
            System.out.println("");
            graph[s][v]=c;


        }
        for (int[] innerArray : graph)
        {
            System.out.println(Arrays.toString(innerArray));
        }

        MaximumFlow m = new MaximumFlow();
        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("The maximum possible flow is "
                + m.fordFulkerson(graph, 0, numberOfNodes-1));
            System.out.println("");

            long now = System.currentTimeMillis();
            double elapsed = (now - start)/1000.0;

            System.out.println("Elapsed time = " + elapsed + "seconds");

    }



    private static void ladder_2(){
        long start = System.currentTimeMillis();

        int numberOfNodes = 0;

        In in = new In("ladder_2.txt");
        int i,j ,k;

        int[] a = in.readAllInts();
        numberOfNodes=a[0] ;
        V=a[0];
        int size  = a.length;
        int s= 0,v = 0,c = 0;
        System.out.println("Nodes " +numberOfNodes);
        int[][] graph=new int[numberOfNodes][numberOfNodes];


        for (i = 1; i < size; i = i + 3) {
        s = a[i];
        v =a[i+1];
        c = a[i +2];
        System.out.println("Edge from node " + s + " to node " + v + " with capacity " + c);
            System.out.println("");
            System.out.println("");
        graph[s][v]=c;


        }
        for (int[] innerArray : graph)
        {
        System.out.println(Arrays.toString(innerArray));
        }

        MaximumFlow m = new MaximumFlow();
        System.out.println("");
        System.out.println("");
        System.out.println("");


        System.out.println("The maximum possible flow is "
        + m.fordFulkerson(graph, 0, numberOfNodes-1));
    System.out.println("");


        long now = System.currentTimeMillis();
        double elapsed = (now - start)/1000.0;

        System.out.println("Elapsed time = " + elapsed + "seconds");
    }



    private static void ladder_3(){

        long start = System.currentTimeMillis();
        int numberOfNodes = 0;
        In in = new In("ladder_3.txt");
        int i,j ,k;

        int[] a = in.readAllInts();
        numberOfNodes=a[0] ;
        V=a[0];
        int size  = a.length;

        int s= 0,v = 0,c = 0;
        System.out.println("Nodes " +numberOfNodes);
        int[][] graph=new int[numberOfNodes][numberOfNodes];


        for (i = 1; i < size; i = i + 3) {
        s = a[i];
        v =a[i+1];
        c = a[i +2];
        System.out.println("Edge from node " + s + " to node " + v + " with capacity " + c);
            System.out.println("");
            System.out.println("");
        graph[s][v]=c;


        }
        for (int[] innerArray : graph)
        {
        System.out.println(Arrays.toString(innerArray));
        }

        MaximumFlow m = new MaximumFlow();

        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("The maximum possible flow is "
        + m.fordFulkerson(graph, 0, numberOfNodes-1));
    System.out.println("");


        long now = System.currentTimeMillis();
        double elapsed = (now - start)/1000.0;

        System.out.println("Elapsed time = " + elapsed + "seconds");
    }



    private static void ladder_4(){

        long start = System.currentTimeMillis();
        int numberOfNodes = 0;

        In in = new In("ladder_4.txt");
        int i,j ,k;

        int[] a = in.readAllInts();
        numberOfNodes=a[0] ;
        V=a[0];
        int size  = a.length;
        int s= 0,v = 0,c = 0;
        System.out.println("Nodes " +numberOfNodes);
        int[][] graph=new int[numberOfNodes][numberOfNodes];


        for (i = 1; i < size; i = i + 3) {
        s = a[i];
        v =a[i+1];
        c = a[i +2];
        System.out.println("Edge from node " + s + " to node " + v + " with capacity " + c);
            System.out.println("");
            System.out.println("");
        graph[s][v]=c;


        }
        for (int[] innerArray : graph)
        {
        System.out.println(Arrays.toString(innerArray));
        }

        MaximumFlow m = new MaximumFlow();
        System.out.println("");
        System.out.println("");
        System.out.println("");


        System.out.println("The maximum possible flow is "
        + m.fordFulkerson(graph, 0, numberOfNodes-1));
    System.out.println("");

        long now = System.currentTimeMillis();
        double elapsed = (now - start)/1000.0;

        System.out.println("Elapsed time = " + elapsed + "seconds");

    }



    private static void ladder_5(){

        long start = System.currentTimeMillis();
        int numberOfNodes = 0;

        In in = new In("ladder_5.txt");
        int i,j ,k;

        int[] a = in.readAllInts();
        numberOfNodes=a[0] ;
        V=a[0];
        int size  = a.length;

        int s= 0,v = 0,c = 0;
        System.out.println("Nodes " +numberOfNodes);
        int[][] graph=new int[numberOfNodes][numberOfNodes];


        for (i = 1; i < size; i = i + 3) {
        s = a[i];
        v =a[i+1];
        c = a[i +2];
        System.out.println("Edge from node " + s + " to node " + v + " with capacity " + c);
            System.out.println("");
            System.out.println("");
        graph[s][v]=c;


        }
        for (int[] innerArray : graph)
        {
        System.out.println(Arrays.toString(innerArray));
        }

        MaximumFlow m = new MaximumFlow();
        System.out.println("");
        System.out.println("");
        System.out.println("");


        System.out.println("The maximum possible flow is "
        + m.fordFulkerson(graph, 0, numberOfNodes-1));
    System.out.println("");

        long now = System.currentTimeMillis();
        double elapsed = (now - start)/1000.0;

        System.out.println("Elapsed time = " + elapsed + "seconds");
        }


    private static void ladder_6(){
        long start = System.currentTimeMillis();

        int numberOfNodes = 0;

        In in = new In("ladder_6.txt");
        int i,j ,k;

        int[] a = in.readAllInts();
        numberOfNodes=a[0] ;
        V=a[0];
        int size  = a.length;

        int s= 0,v = 0,c = 0;
        System.out.println("Nodes " +numberOfNodes);
        int[][] graph=new int[numberOfNodes][numberOfNodes];


        for (i = 1; i < size; i = i + 3) {
            s = a[i];
            v =a[i+1];
            c = a[i +2];
            System.out.println("Edge from node " + s + " to node " + v + " with capacity " + c);
            System.out.println("");
            System.out.println("");
            graph[s][v]=c;


        }
        for (int[] innerArray : graph)
        {
            System.out.println(Arrays.toString(innerArray));
        }

        MaximumFlow m = new MaximumFlow();

        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("The maximum possible flow is "
                + m.fordFulkerson(graph, 0, numberOfNodes-1));
        System.out.println("");

        long now = System.currentTimeMillis();
        double elapsed = (now - start)/1000.0;

        System.out.println("Elapsed time = " + elapsed + "seconds");
    }


    private static void ladder_7(){
        long start = System.currentTimeMillis();

        int numberOfNodes = 0;

        In in = new In("ladder_7.txt");
        int i,j ,k;

        int[] a = in.readAllInts();
        numberOfNodes=a[0] ;
        V=a[0];
        int size  = a.length;

        int s= 0,v = 0,c = 0;
        System.out.println("Nodes " +numberOfNodes);
        int[][] graph=new int[numberOfNodes][numberOfNodes];


        for (i = 1; i < size; i = i + 3) {
            s = a[i];
            v =a[i+1];
            c = a[i +2];
            System.out.println("Edge from node " + s + " to node " + v + " with capacity " + c);
            System.out.println("");
            System.out.println("");
            graph[s][v]=c;


        }
        for (int[] innerArray : graph)
        {
            System.out.println(Arrays.toString(innerArray));
        }

        MaximumFlow m = new MaximumFlow();

        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("The maximum possible flow is "
                + m.fordFulkerson(graph, 0, numberOfNodes-1));
        System.out.println("");

        long now = System.currentTimeMillis();
        double elapsed = (now - start)/1000.0;

        System.out.println("Elapsed time = " + elapsed + "seconds");
    }


    private static void ladder_8(){
        long start = System.currentTimeMillis();

        int numberOfNodes = 0;
        In in = new In("ladder_8.txt");
        int i,j ,k;

        int[] a = in.readAllInts();
        numberOfNodes=a[0] ;
        V=a[0];
        int size  = a.length;

        int s= 0,v = 0,c = 0;
        System.out.println("Nodes " +numberOfNodes);
        int[][] graph=new int[numberOfNodes][numberOfNodes];


        for (i = 1; i < size; i = i + 3) {
            s = a[i];
            v =a[i+1];
            c = a[i +2];
            System.out.println("Edge from node " + s + " to node " + v + " with capacity " + c);
            System.out.println("");
            System.out.println("");
            graph[s][v]=c;


        }
        for (int[] innerArray : graph)
        {
            System.out.println(Arrays.toString(innerArray));
        }

        MaximumFlow m = new MaximumFlow();

        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("The maximum possible flow is "
                + m.fordFulkerson(graph, 0, numberOfNodes-1));

        System.out.println("");

        long now = System.currentTimeMillis();
        double elapsed = (now - start)/1000.0;

        System.out.println("Elapsed time = " + elapsed + "seconds");
    }


    private static void ladder_9(){

        long start = System.currentTimeMillis();
        int numberOfNodes = 0;
        In in = new In("ladder_9.txt");
        int i,j ,k;

        int[] a = in.readAllInts();
        numberOfNodes=a[0] ;
        V=a[0];
        int size  = a.length;

        int s= 0,v = 0,c = 0;
        System.out.println("Nodes " +numberOfNodes);
        int[][] graph=new int[numberOfNodes][numberOfNodes];


        for (i = 1; i < size; i = i + 3) {
            s = a[i];
            v =a[i+1];
            c = a[i +2];
            System.out.println("Edge from node " + s + " to node " + v + " with capacity " + c);
            System.out.println("");
            System.out.println("");
            graph[s][v]=c;


        }
        for (int[] innerArray : graph)
        {
            System.out.println(Arrays.toString(innerArray));
        }

        MaximumFlow m = new MaximumFlow();
        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("The maximum possible flow is "
                + m.fordFulkerson(graph, 0, numberOfNodes-1));
        System.out.println("");


        long now = System.currentTimeMillis();
        double elapsed = (now - start)/1000.0;

        System.out.println("Elapsed time = " + elapsed + "seconds");
    }

}


//References -
//            <https://www.google.com/amp/s/www.geeksforgeeks.org/ford-fulkerson-algorithm-for-maximum-flow-problem/amp/>
//            https://www.softwaretestinghelp.com/java-graph-tutorial/