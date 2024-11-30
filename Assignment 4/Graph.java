import java.io.*;
import java.util.*;

public class Graph {
    int a[][];
    int numVertices;

    public Graph(){
        numVertices=5;
        a = new int [numVertices][numVertices];
    }
    
    public Graph(int numVertices){
        this.numVertices = numVertices;
        a = new int[numVertices][numVertices];
    }
    
    public void addEdge(int i, int j){

        a[i][j]=1;

    }

    //method to return neighbors of a vertex
    public int[] neighbor(int vertex){
        int count = 0;
        int[] neighbors;
        for (int i=0; i<numVertices; i++){
            if(a[vertex][i]==1){
                count++;
            }
        }
            neighbors = new int[count];
        for(int j= 0; j<neighbors.length; j++){
            if(a[vertex][j]==1){
                neighbors[j] = 'A'+j;
            }
        }
        return neighbors; 
    }
    public void display(int[] neighbors,int vertex){
        int size= neighbors.length;
        System.out.println("Neighbors of "+ Character.toString('A'+vertex));
        for(int i =0; i<size; i++){
        System.out.println(Character.toString(neighbors[i]) + " ");
        }
        System.out.println();
    }
}
