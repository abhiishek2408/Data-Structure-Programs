package Monotonocity;

import java.util.*;

public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 2 };
        // [3, 4, -1, -1]
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() < arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(st.peek());
            }

            st.push(arr[i]);
        }
        
        Collections.reverse(ans);
        System.out.println(ans);
    }
}