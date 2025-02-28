package Recursion;

public class TowerofHanoi {
    
    static void solve(int n, char a, char b, char c) {
        if (n == 0) {
            return;
        }
        solve(n - 1, a, c, b);                 
        System.out.println("Move disk " + n + " from rod " + a + " to rod " + b);
        solve(n - 1, c, b, a);
    }

    public static void main(String args[]) {
        int n = 3;
        solve(n, 'A', 'B', 'C');
    }
}

//First calls solve(n-1, a, c, b), which moves the top n-1 disks from rod a to rod c using rod b as an auxiliary.
//Then, it prints the move of the nth disk from rod a to rod b.
//Finally, it calls solve(n-1, c, b, a), which moves the n-1 disks from rod c to rod b using rod a as an auxiliary.

/*For n disks, we make 2 recursive calls to solve the subproblems of size n-1. This gives us a recurrence relation:
T(n) = 2 * T(n-1) + 1
The total number of recursive calls is 2^n - 1
This means for each level of recursion, you solve two smaller subproblems and make one move. */