package TetonorKit;

import java.util.Arrays;
import java.util.HashMap;

import static TetonorKit.TetonorSolver.*;

public class BranchQueue {
    private HashMap<Integer, int[][][]> branchesQueue = new HashMap<>();
    private int newBranchKeyNumber = 1;
    private int currentBranchNumber = 1;
    public int[][][] currentBranch = new int[16][8][6];

    /*public BranchQueue(int[][][] startingBranch) {
        createNewBranch(startingBranch);
    }*/

    public void removeCurrentBranch() {
        branchesQueue.remove(currentBranchNumber);
    }

    public String getCurrentBranchAsString() {
        return Arrays.deepToString(branchQueue.currentBranch);
    }

    public void printCurrentBranch() {
        System.out.println(Arrays.deepToString(branchesQueue.get(currentBranchNumber)));
    }

    public int getCurrentBranchNumber() {
        return currentBranchNumber;
    }

    public int getNewBranchKeyNumber() { return newBranchKeyNumber;}

    public void createNewBranch(int[][][] newBranch) {
        branchesQueue.put(newBranchKeyNumber, newBranch);
        newBranchKeyNumber++;
    }

    public void moveOnToTheNextBranch() {
        currentBranchNumber++;
        currentBranch = branchesQueue.get(currentBranchNumber);
    }

    public int[][][] deepCopyTheCurrentBranch() {
        int[][][] branchCopy = new int[16][8][6];
        for (int gridItem = 0; gridItem < NUMBER_OF_GRID_ITEMS; gridItem++) {
            for (int quadI = 0; quadI < NUMBER_OF_QUAD_ITEMS; quadI++) {
                System.arraycopy(branchQueue.currentBranch[gridItem][quadI], 0, branchCopy[gridItem][quadI], 0, NUMBER_OF_QUAD_ITEM_VALUES);
            }
        }
        return branchCopy;
    }
}
