/**
 * CS3100 - Fall 2023 - Programming Assignment 4
 *********************************
 * Collaboration Policy: You may discuss the problem and the overall
 * strategy with up to 4 other students, but you MUST list those people
 * in your submission under collaborators.  You may NOT share code,
 * look at others' code, or help others debug their code.  Please read
 * the syllabus carefully around coding.  Do not seek published or online
 * solutions for any assignments. If you use any published or online resources
 * (which may not include solutions) when completing this assignment, be sure to
 * cite them. Do not submit a solution that you are unable to explain orally to a
 * member of the course staff.
 *********************************
 * Your Computing ID: fhw9hh
 * Collaborators: 
 * Sources: Introduction to Algorithms, Cormen
 **************************************/

public class SeamCarving {

    /**
     * This method is the one you should implement.  It will be called to perform
     * the seam carving.  You may create any additional data structures as fields
     * in this class or write any additional methods you need.
     *
     */
    private int[] res;
    private int rows = 0;
    private int cols = 0;
    private double[][] energy;
    private double[][] dp;
    private int[][] backtrack;


    public double compute(int[][][] image) {
        // Initialization
        rows = image.length;
        cols = image[0].length;
        res = new int[rows];
        energy = new double[rows][cols];
        dp = new double[rows][cols];
        backtrack = new int[rows][cols];

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                energy[y][x] = calculateEnergy(image, x, y);
            }
        }

        if (cols >= 0) System.arraycopy(energy[0], 0, dp[0], 0, cols);
        for (int y = 1; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                double min = Double.MAX_VALUE;
                int[] temp = new int[] {-1, 0, 1};

                for (int n : temp) {
                    int prevX = x + n;
                    if (prevX >= 0 && prevX < cols) {
                        if (dp[y - 1][prevX] < min) {
                            min = dp[y - 1][prevX];
                            backtrack[y][x] = prevX;
                        }
                    }
                }

                dp[y][x] = energy[y][x] + min;
            }
        }

        return findMin();
    }

    /**
     * Get the seam, in order from top to bottom, where the top-left corner of the
     * image is denoted (0,0).
     *
     * Since the y-coordinate (row) is determined by the order, only return the x-coordinate
     *
     * @return the ordered list of x-coordinates (column number) of each pixel in the seam
     */
    public int[] getSeam() {
        return res;
    }


    private double distance(int[] p1, int[] p2) {
        double sum = 0.0;
        for (int i = 0; i < 3; i++) {
            sum += Math.pow(p1[i] - p2[i], 2);
        }
        return Math.sqrt(sum);
    }

    private double calculateEnergy(int[][][] image, int x, int y) {
        double sum = 0.0;
        int count = 0;
        int[][] choices = {{-1,-1}, {0, -1}, {1, -1}, {-1, 0}, {1,0}, {0, 1}, {-1, 1}, {1, 1}};


        for (int[] choice : choices) {
            int nextX = x + choice[0];
            int nextY = y + choice[1];

            if (nextX >= 0 && nextX < cols && nextY >= 0 && nextY < rows) {
                sum += distance(image[y][x], image[nextY][nextX]);
                count++;
            }
        }

        return sum / count;
    }

    private double findMin() {
        double min = Double.MAX_VALUE;
        int idx = 0;

        for (int x = 0; x < cols; x++) {
            if (dp[rows - 1][x] < min) {
                min = dp[rows - 1][x];
                idx = x;
            }
        }

        // Backtracking
        for (int y = rows - 1; y >= 0; y--) {
            res[y] = idx;
            idx = backtrack[y][idx];
        }

        return min;
    }
}
