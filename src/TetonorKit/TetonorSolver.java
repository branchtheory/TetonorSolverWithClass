package TetonorKit;

import java.util.Arrays;

public class TetonorSolver {

    private final int[] GRID16 = {50, 40, 135, 32, 49, 208, 19, 252, 256, 32, 264, 48, 34, 175, 48, 134};
    private final int[] LINE16 = {1, 2, 3, 0, 0, 8, 0, 0, 0, 16, 0, 26, 0, 0, 49, 0};

    public static int[] grid16 = {50, 40, 135, 32, 49, 208, 19, 252, 256, 32, 264, 48, 34, 175, 48, 134};
    public static int[] line16 = {1, 2, 3, 0, 0, 8, 0, 0, 0, 16, 0, 26, 0, 0, 49, 0};

    final static int PRODUCT_SIGNIFIER = 111;
    final static int SUM_SIGNIFIER = 5;
    final static int UNUSED = 0;
    final static int DONE = 1;
    final static int NUMBER_OF_QUAD_ITEM_VALUES = 6;
    final static int NUMBER_OF_QUAD_ITEMS = 8;
    final static int NUMBER_OF_GRID_ITEMS = 16;
    final static int[] emptyQuad = {0,0,0,0,0,0};
    final static int[][][] BROKEN_BRANCH = new int[16][8][6];
    final static int NOT_FOUND = -1;

    public static InitialPotentialQuads initialPotentialQuads = new InitialPotentialQuads();
    public static BranchQueue branchQueue = new BranchQueue();
    public static BranchSplitter branchSplitter = new BranchSplitter();
    public static LogicalDeductions logicalDeductions = new LogicalDeductions();

/*    public TetonorSolver (int[] grid, int[] line) {
        Arrays.sort(grid);
        GRID16 = grid;
        LINE16 = line;
        grid16 = grid;
        line16 = line;

        System.out.println("Initial data");
        System.out.println("Grid 16: " + Arrays.toString(GRID16));
        System.out.println("Line 16: " + Arrays.toString(LINE16) + "\n");
    }*/

    public static void main(String args[]) {
        Arrays.sort(grid16);

        System.out.println("Initial data");
        System.out.println("Grid 16: " + Arrays.toString(grid16));
        System.out.println("Line 16: " + Arrays.toString(line16) + "\n");

        branchQueue.currentBranch = initialPotentialQuads.findPotentialQuads();

        System.out.println("PREP\n");
        System.out.println("potentialQuads");
        System.out.println(Arrays.deepToString(branchQueue.currentBranch)+"\n");

        //singles next

        while (logicalDeductions.thereMayBeFurtherLogicalDeductionsToMake()) {
            logicalDeductions.deduceFromGridItemsWithOnlyOneQuad();
            if(logicalDeductions.thereMayBeFurtherLogicalDeductionsToMake()) {
                System.out.println("potentialQuads after singles");
                System.out.println(Arrays.deepToString(branchQueue.currentBranch) + "\n");
            }
        }
    }

    public static boolean isAnEmptyQuad(int[] quad) {
        return quad[0] == 0;
    }
}
