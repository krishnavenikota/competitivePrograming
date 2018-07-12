import java.util.*;
public class Solution3{
public static int distance(int[][] grid) {
    int m=grid.length;
    int n=grid[0].length;
 
    ArrayList<Integer> cols = new ArrayList<Integer>();
    ArrayList<Integer> rows = new ArrayList<Integer>();
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
           if(grid[i][j]==1){
               cols.add(j);
               rows.add(i);
           }
        }
    }
 
    int sum=0;
 
    for(Integer i: rows){
        sum += Math.abs(i - rows.get(rows.size()/2));    
    }
 
    Collections.sort(cols);
 
    for(Integer i: cols){
        sum+= Math.abs(i-cols.get(cols.size()/2));
    }
 
    return sum;
}

public static void main(String[] args) {
   int[][] grid= {{1, 0, 0, 0, 1}, 
                   {0, 0, 0, 0, 0},
                   {0, 0, 1, 0, 0}};

    int result =distance(grid);
    System.out.println(result);

   int[][] grid1 = {{1, 0, 1, 0, 1},
                     {0, 1, 0, 0, 0}, 
                     {0, 1, 1, 0, 0}};

     int result1 =distance(grid1);
    System.out.println(result1);

    int[][] grid2 = {{1, 1},
                     {1,1}};
     int result2 =distance(grid2);
    System.out.println(result2);

    int[][] grid3 = {{0, 0},
                     {0, 0}};
     int result3 =distance(grid3);
    System.out.println(result3);

    int[][] grid4 = {{1, 0},
                     {0, 0}};
     int result4 =distance(grid4);
    System.out.println(result4);
 

}
}