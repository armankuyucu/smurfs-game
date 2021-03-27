package Game.States;

import Game.Game;
import Game.Karakterler.*;
import Game.Objeler.Altin;
import Game.Objeler.Mantar;
import Game.Tiles.Tile;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameState extends State{
    private Oyuncu oyuncu;
    private Dusman gargamel;
    private Dusman azman;
    public static Altin[] AltinListesi = new Altin[5];
    public static Mantar mantar;

    public static int[][] map;
    public static String line1, line2;
    public static String[] column1,column2,dusman1,dusman2,kapi1,kapi2;
    public static int[][] AdjacencyMatrix;

    public GameState(Game game){
        super(game);
        readFileIntoArray();
        //Polymorphism ornegi
        if(MenuState.ButtonID == 1){
            oyuncu = new GozlukluSirin(game,395,320, 5,6,1, "GozlukluSirin", "Oyuncu");
        }
        if(MenuState.ButtonID == 2){
            oyuncu = new TembelSirin(game,395,320, 5,6,2, "TembelSirin", "Oyuncu");
        }
        if(GameState.dusman1[1].equals("Gargamel")){
            if(GameState.kapi1[1].equals("A"))
                gargamel = new Gargamel(game,3*Tile.TILEWIDTH+10,5,1,10,0,"Gargamel","Dusman");
            else if(GameState.kapi1[1].equals("B"))
                gargamel = new Gargamel(game,10*Tile.TILEWIDTH+10,5,1,10,0,"Gargamel","Dusman");
            else if(GameState.kapi1[1].equals("C"))
                gargamel = new Gargamel(game,10,5*Tile.TILEWIDTH+5,1,10,0,"Gargamel","Dusman");
            else if(GameState.kapi1[1].equals("D"))
                gargamel = new Gargamel(game,3*Tile.TILEWIDTH+10,10*Tile.TILEWIDTH+5,1,10,0,"Gargamel","Dusman");
        }
        if(GameState.dusman2[1].equals("Azman")){
            if(GameState.kapi2[1].equals("A"))
                azman = new Azman(game,3*Tile.TILEWIDTH+10,0,1,10,0,"Azman","Dusman");
            else if(GameState.kapi2[1].equals("B"))
                azman = new Azman(game,10*Tile.TILEWIDTH+10,0,1,10,0,"Azman","Dusman");
            else if(GameState.kapi2[1].equals("C"))
                azman = new Azman(game,10,5*Tile.TILEWIDTH,1,10,0,"Azman","Dusman");
            else if(GameState.kapi2[1].equals("D"))
                azman = new Azman(game,3*Tile.TILEWIDTH+10,10*Tile.TILEWIDTH,1,10,0,"Azman","Dusman");
        }

        mantar = new Mantar(14,-100,-100,false);
        Mantar.RastgeleMantarOlusturma();
        ilkKezAltinOlusturma();
    }

    public void ilkKezAltinOlusturma(){
        for(int i=0;i<5;i++){
            AltinListesi[i] = new Altin(10,-100,-100,false);
        }
        Altin.RastgeleAltinOlusturma();
    }

    @Override
    public void update() {
        oyuncu.update();
        if(GameState.dusman1[1].equals("Gargamel"))
            gargamel.update();
        if(GameState.dusman2[1].equals("Azman"))
            azman.update();
    }

    @Override
    public void render(Graphics g) {
        //Haritayi Cizme
        for(int y=0;y<11;y++){
            for(int x=0;x<13;x++){
                if(map[y][x] == 1){
                    //C Kapisi
                    if(y==5 && x==0){
                        Tile.tiles[5].render(g,0,5*Tile.TILEWIDTH);
                    }
                    //A Kapisi
                    else if(x==3 && y==0){
                        Tile.tiles[3].render(g,3*Tile.TILEWIDTH,0);
                    }
                    //D Kapisi
                    else if(x==3 && y==10){
                        Tile.tiles[6].render(g,3*Tile.TILEWIDTH,10*Tile.TILEWIDTH);
                    }
                    //B Kapisi
                    else if(x==10 && y==0){
                        Tile.tiles[4].render(g,10*Tile.TILEWIDTH,0);
                    }

                    //Baslangic Noktasi
                    else if(x==6 && y==5){
                        Tile.tiles[2].render(g,6*Tile.TILEWIDTH,5*Tile.TILEWIDTH);
                    }
                    //Bosluklar
                    else{
                        Tile.tiles[1].render(g,x*Tile.TILEWIDTH,y*Tile.TILEWIDTH);
                    }
                }
                else if(map[y][x] == 0){
                    Tile.tiles[0].render(g,x*Tile.TILEWIDTH,y*Tile.TILEWIDTH);
                }
                g.setColor(Color.BLACK);
                g.drawLine(0,y*Tile.TILEWIDTH,832,y*Tile.TILEWIDTH); // x ekseni
                g.drawLine(x*Tile.TILEWIDTH,0,x*Tile.TILEWIDTH,704);  // y ekseni
            }
        }
        oyuncu.render(g);
        if(GameState.dusman1[1].equals("Gargamel"))
            gargamel.render(g);
        if(GameState.dusman2[1].equals("Azman"))
            azman.render(g);

        //Altinlar
        for(int i=0;i<5;i++)
            AltinListesi[i].render(g);

        //Mantar
        mantar.render(g);

        //Skor
        g.setColor(Color.RED);
        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,35));
        g.drawString(String.format("Skor : %d",Puan.Skor),650,680);
    }


    //Txt dosyasini okuma
    public void readFileIntoArray() {
        map = new int[11][13];
        //Read harita.txt

        /*Hatirlamak icin notlar
        dusman1[1] ilk dusman
        dusman2[1] ikinci dusman
        kapi1[1] ilk dusmanin kapisi
        kapi2[1] ikinci dusmanin kapisi
        */

        try {
            Scanner sc = new Scanner(new File("res/harita.txt"));
            line1 = sc.nextLine();
            line2 = sc.nextLine();

            //virgullere gore ayirir
            column1 = line1.split("\\s*,\\s*",0);
            column2 = line2.split("\\s*,\\s*",0);

            //':' karakterine gore ayirir
            dusman1 = column1[0].split("\\s*:\\s*",0);
            kapi1 = column1[1].split("\\s*:\\s*",0);
            dusman2 = column2[0].split("\\s*:\\s*",0);
            kapi2 = column2[1].split("\\s*:\\s*",0);
/*
            System.out.println("1.Dusman: " + dusman1[1]);
            System.out.println("1.Dusmanin kapisi: " + kapi1[1]);
            System.out.println("2.Dusman: " + dusman2[1]);
            System.out.println("2.Dusmanin kapisi: " + kapi2[1]);
            */

            for(int i=0;i<11;i++){
                for(int j=0;j<13;j++){
                    map[i][j] = sc.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

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


        //Graph_Shortest_Path g = new Graph_Shortest_Path();
        this.algo_dijkstra(GameState.AdjacencyMatrix, 10);

    }

    //Dijkstra's Shortest Path Algorithm

    //Asagidaki kod https://www.softwaretestinghelp.com/dijkstras-algorithm-in-java/#Using_Adjacency_Matrix
    //sitesinden alinmistir.

    static final int num_Vertices = 143;  //max number of vertices in graph
    // find a vertex with minimum distance
    int minDistance(int path_array[], Boolean sptSet[])   {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < num_Vertices; v++)
            if (sptSet[v] == false && path_array[v] <= min) {
                min = path_array[v];
                min_index = v;
            }

        return min_index;
    }

    // print the array of distances (path_array)
    void printMinpath(int path_array[])   {
        System.out.println("Vertex# \t Minimum Distance from Source");
        for (int i = 0; i < num_Vertices; i++)
            System.out.println(i + " \t\t\t " + path_array[i]);
    }

    // Implementation of Dijkstra's algorithm for graph (adjacency matrix)
    void algo_dijkstra(int graph[][], int src_node)  {
        int path_array[] = new int[num_Vertices]; // The output array. dist[i] will hold
        // the shortest distance from src to i

        // spt (shortest path set) contains vertices that have shortest path
        Boolean sptSet[] = new Boolean[num_Vertices];

        // Initially all the distances are INFINITE and stpSet[] is set to false
        for (int i = 0; i < num_Vertices; i++) {
            path_array[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Path between vertex and itself is always 0
        path_array[src_node] = 0;
        // now find shortest path for all vertices
        for (int count = 0; count < num_Vertices - 1; count++) {
            // call minDistance method to find the vertex with min distance
            int u = minDistance(path_array, sptSet);
            // the current vertex u is processed
            sptSet[u] = true;
            // process adjacent nodes of the current vertex
            for (int v = 0; v < num_Vertices; v++)

                // if vertex v not in sptset then update it
                if (!sptSet[v] && graph[u][v] != 0 && path_array[u] !=
                        Integer.MAX_VALUE && path_array[u]
                        + graph[u][v] < path_array[v])
                    path_array[v] = path_array[u] + graph[u][v];

            System.out.println(count + ".path array: " + path_array[count]);
        }

        // print the path array
        printMinpath(path_array);
    }




}
