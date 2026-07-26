package Graph;

import java.util.*;

public class _47_KeysAndRooms {

    static boolean canVisitAllRooms(
            List<List<Integer>> rooms) {

        int n = rooms.size();

        boolean[] visited =
            new boolean[n];

        Queue<Integer> queue =
            new LinkedList<>();

        // Start from room 0
        queue.add(0);

        visited[0] = true;

        while (!queue.isEmpty()) {

            int room = queue.poll();

            // Check all keys
            for (int key : rooms.get(room)) {

                if (!visited[key]) {

                    visited[key] = true;

                    queue.add(key);
                }
            }
        }

        // Check all rooms visited
        for (boolean room : visited) {

            if (!room) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        List<List<Integer>> rooms =
            new ArrayList<>();

        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Arrays.asList());

        System.out.println(
            canVisitAllRooms(rooms)
        );
    }
}
