import java.util.*;
import java.io.*;

public class Main {
   public static void caramel(char t){
      char x = t;
      boolean isCapital= Character.isUpperCase(x);
      System.out.println("The character is "+isCapital+" to be capital");
      String car="Porsche";
      if(car. startsWith("Por")){
         System.out.println("The word starts with Por");
      }
      else{
         System.out.println("The string does not start with Por");
      }
   }
    public static void main(String[] args) throws Exception {
       Graph graph = new Graph(9);
    //Edges for A
       graph.addEdge(0,1);
       graph.addEdge(0,3);
       graph.addEdge(0, 4);
    //Edge for B
       graph.addEdge(1,4);
    //Edge for C
       graph.addEdge(2, 1);
    //Edge for D
       graph.addEdge(3, 6);
    //Edge for E
       graph.addEdge(4, 5);
       graph.addEdge(4, 7);
    //Edge for F
       graph.addEdge(5, 7);
    //Edge for G   
       graph.addEdge(6, 7);
    //Edge for H
       graph.addEdge(7, 8);
    //Edge for I
        graph.addEdge(8, 5);

    graph.display(graph.neighbor(0), 0);
    graph.display(graph.neighbor(1), 1);
    graph.display(graph.neighbor(2), 2);
    graph.display(graph.neighbor(3), 3);
    graph.display(graph.neighbor(4), 4);
    graph.display(graph.neighbor(5), 5);
    graph.display(graph.neighbor(6), 6);
    graph.display(graph.neighbor(7), 7);
    graph.display(graph.neighbor(8), 8);
    
    caramel('P');
    }
}
