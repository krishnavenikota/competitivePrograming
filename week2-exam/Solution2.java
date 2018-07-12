import java.util.*;
public class Solution2 {
public static int[][] reconstructQueue(int[][] people) {
        if( people == null || people.length < 2 || people[0].length < 2) return people;
        
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });
        
        ArrayList<int[]> temp = new ArrayList<>();
        int len = people.length;
        for(int i = 0; i < len; i++) {
            temp.add(people[i][1], new int[] {people[i][0], people[i][1]});
        } 
        
        int[][] res = new int[len][2];
        for(int i = 0; i < len; i++){
            res[i][0] = temp.get(i)[0];
            res[i][1] = temp.get(i)[1];
        }
        return res;
    }


    public static void main(String[] args) {
      
    int[][] array={{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
   
   

    int[][] res=reconstructQueue(array);
    for(int i=0;i<res.length;i++){
        for(int j=0;j<2;j++){
            System.out.print(res[i][j]+" ");
        }
        System.out.println();
         }

    int[][] array1={{12,0},{6,3},{3,4},{9,2}, {11,1},{1,5}};
   
    int[][] res1=reconstructQueue(array1);
    for(int i=0;i<res1.length;i++){
        for(int j=0;j<2;j++){
            System.out.print(res1[i][j]+" ");
        }
        System.out.println();
    }
    

   int[][] array3={{2,4}, {5,1}, {3,3}, {1,5}, {4,2}, {6,0}};
   
   

    int[][] res3=reconstructQueue(array3);
    for(int i=0;i<res3.length;i++){
        for(int j=0;j<2;j++){
            System.out.print(res3[i][j]+" ");
        }
        System.out.println();
  }
}
  
}