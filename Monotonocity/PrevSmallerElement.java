package Monotonocity;
import java.util.*;

public class PrevSmallerElement {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 2 };
        // [-1, 1, 3, 1]
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
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

        System.out.println(ans);
    }
}