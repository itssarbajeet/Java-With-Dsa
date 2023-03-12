public class ant_problem {
    public static int antCollisions(String directions) {
        int n = directions.length();
        int collisions = 0;
    
        // initialize an array to store ant positions
        int[] positions = new int[n];
    
        // initialize array to store ant directions
        int[] dirs = new int[n];
    
        // populate positions and dirs arrays
        for (int i = 0; i < n; i++) {
            char c = directions.charAt(i);
            if (c == 'R') {
                dirs[i] = 1;
            } else if (c == 'L') {
                dirs[i] = -1;
            }
            positions[i] = i;
        }
    
        // iterate until all ants have collided
        while (true) {
            boolean allCollided = true;
    
            // iterate over ants
            for (int i = 0; i < n; i++) {
                int newPos = positions[i] + dirs[i];
    
                // check if ant will collide with another ant or with the end of the line
                if (newPos == -1 || newPos == n || (i < n - 1 && newPos == positions[i + 1])) {
                    if (dirs[i] == 1) {
                        dirs[i] = -1;
                    } else if (dirs[i] == -1) {
                        dirs[i] = 1;
                    }
                    if (newPos == -1) {
                        collisions++;
                    }
                    if (i < n - 1 && dirs[i] != dirs[i + 1]) {
                        dirs[i] = 0;
                        dirs[i + 1] = 0;
                        collisions += 2;
                        i++;
                    }
                } else {
                    allCollided = false;
                    positions[i] = newPos;
                }
            }
    
            // check if all ants have collided
            if (allCollided) {
                break;
            }
        }
        return collisions;
    }
     
    
    
    
    public static void main(String[] args) {
        String directions = "RLRDLL";
        int collisions = antCollisions(directions);
        System.out.println(collisions);
    }
    }