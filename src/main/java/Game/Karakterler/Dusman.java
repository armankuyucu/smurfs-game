package Game.Karakterler;

import Game.Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Dusman extends Karakter{
    protected int ID;
    protected String Ad;
    protected String Tur;
    protected float x,y;
    protected Game game;
    public static int AdjacencyMatrix[][];
    public ArrayList<Integer> path = new ArrayList<>();

    public static boolean pressed = false;

    public static int hareketSayaci = 0;
    private static final int V = 143 ;
    public static int parent[] = new int[V];

    public Dusman(Game game,float x, float y, int ID, String Ad, String Tur) {
        super(Karakter.DEFAULT_CHARACTER_WIDTH,Karakter.DEFAULT_CHARACTER_HEIGHT,ID, Ad, Tur);
        this.game = game;
        this.x = x;
        this.y = y;
        readAdjacencyMatrix();
    }

    public Dusman(){

    }

    public void update(){

    }

    public void render(){

    }

    public void EnKisaYol(){
    }

    public void readAdjacencyMatrix(){
        //Read AdjacencyMatrix.txt

        AdjacencyMatrix = new int[143][143];
        try{
            Scanner scanner = new Scanner(new File("res/KomsulukMatrisi.txt"));
            for(int i=0;i<143;i++){
                for(int j=0;j<143;j++){
                    AdjacencyMatrix[i][j] = scanner.nextInt();
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }


    //Dijkstra's Shortest Path Algorithm

    //Asagidaki kod https://www.geeksforgeeks.org/printing-paths-dijkstras-shortest-path-algorithm/
    //adresinden alinmistir.

    public int minDistance(int dist[], boolean sptSet[])
    {

        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false &&
                    dist[v] <= min){
                min = dist[v]; min_index = v;
            }

        return min_index;
    }

    int sayac = 0;
    public static int [] birSonraki = new int[1];
    // Function to print shortest
    // path from source to j
    // using parent array
    public void printPath(int parent[], int j,int src)
    {

        // Base Case : If j is source
        if (parent[j] ==  -1) {
            return;
        }
        printPath(parent, parent[j],src);
        path.add(j);

        if(sayac == path.size()-1){
            birSonraki[0] = j;
            sayac = 0;
        }

        sayac++;

    }

    // A utility function to print
    // the constructed distance
    // array
    public void printSolution(int dist[], int n, int parent[],int src,int destination)
    {

        //System.out.println("Vertex\t Distance\tPath");
        path = new ArrayList<>();
        for (int i = 0; i < V; i++)
        {
            if(i != src && i == destination){
                System.out.println(String.format("\n%d -> %d \t\t %d\t\t%d ", src, i, dist[i], src));
                printPath(parent, i,src);
            }
        }
    }

    // Funtion that implements Dijkstra's
// single source shortest path
// algorithm for a graph represented
// using adjacency matrix representation
    public void dijkstra(int [][]graph, int src,int destination)
    {

        // The output array. dist[i]
        // will hold the shortest
        // distance from src to i
        int dist[] = new int[V];

        // sptSet[i] will true if vertex
        // i is included / in shortest
        // path tree or shortest distance
        // from src to i is finalized
        boolean sptSet[] =new boolean[V];

        // Parent array to store
        // shortest path tree
        // Initialize all distances as
        // INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++)
        {
            parent[0] = -1;
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex
        // from itself is always 0
        dist[src] = 0;

        //path.clear();
        // Find shortest path
        // for all vertices
        for (int count = 0; count < V - 1; count++)
        {
            // Pick the minimum distance
            // vertex from the set of
            // vertices not yet processed.
            // u is always equal to src
            // in first iteration.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex
            // as processed
            sptSet[u] = true;

            // Update dist value of the
            // adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++)

                // Update dist[v] only if is
                // not in sptSet, there is
                // an edge from u to v, and
                // total weight of path from
                // src to v through u is smaller
                // than current value of
                // dist[v]
                if ((!sptSet[v]) && (graph[u][v] == 1) && ((dist[u] + graph[u][v]) < dist[v]))
                {
                    parent[v] = u;
                    dist[v] = dist[u] + graph[u][v];
                }
        }

        // print the constructed
        // distance array
        printSolution(dist, V, parent,src, destination);
    }


}
