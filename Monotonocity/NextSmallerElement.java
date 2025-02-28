package Monotonocity;


import java.util.*;

public class NextSmallerElement {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 2 };
        // [3, 4, -1, -1]   //[-1, 3, 4, -1]
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() > arr[i]) {
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