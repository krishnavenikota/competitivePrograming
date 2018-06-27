import java.util.*;

class MakeChange{

public static int makeChange(int N, List<Integer> coins) {
   
    int[] answers = new int[N+1];
    for (int n = 1; n <= N; n++) {
        answers[n] = 0;
    }

    answers[0] = 1;
        
    for(int coin:coins){
        for (int i = coin; i <= N; i++) {
            int rem = i - coin;
            answers[i] += answers[rem];
        }
    }

    System.out.println(Arrays.toString(answers));
    return answers[N];
    
    } 


public static void main(String args[]){

    int amount=4;
    List<Integer> l= new ArrayList<>();
    l.add(1);
    l.add(2);
    l.add(3);

    int op=makeChange(amount,l);
    System.out.println(op);
}

}