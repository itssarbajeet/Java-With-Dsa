import java.util.*;
public class palindrome{
public static int antCollision(String s) {
    int n = s.length();
    int[] pos = new int[n]; // initial positions of ants
    int[] direction = new int[n]; // direction of ants
    boolean[] alive = new boolean[n]; // whether ants are alive or dead
    int count = 0; // number of collisions

    // initialize ants
    for (int i = 0; i < n; i++) {
        pos[i] = i;
        if (s.charAt(i) == 'R') {
            direction[i] = 1;
        } else {
            direction[i] = -1;
        }
        alive[i] = true;
    }

    // simulate movement
    while (true) {
        boolean moved = false;
        for (int i = 0; i < n; i++) {
            if (!alive[i]) continue; // skip dead ants
            int newPos = pos[i] + direction[i];
            if (newPos < 0 || newPos >= n) {
                alive[i] = false; // ant falls off the edge and dies
            } else if (!alive[newPos]) {
                alive[i] = false; // ant collides with a dead ant and dies
            } else {
                pos[i] = newPos;
                moved = true;
            }
        }
        if (!moved) break; // all ants have stopped moving
    }

    // count collisions
    for (int i = 0; i < n; i++) {
        if (!alive[i]) continue; // skip dead ants
        for (int j = i + 1; j < n; j++) {
            if (!alive[j]) continue; // skip dead ants
            if (pos[i] == pos[j] && direction[i] == -direction[j]) {
                count += 1; // ant collision
            }
        }
    }

    return count;
}
}