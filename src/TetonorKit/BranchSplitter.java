package TetonorKit;

import java.util.Arrays;

import static TetonorKit.TetonorSolver.*;

public class BranchSplitter {
    int gridItemToSplit;
    int[][][] branchCopy;
    int numberOfPotentialQuadsInThisGridItem;

    public void splitBranchAtFirstUnusedGridItem(){
        gridItemToSplit = findGridItemToSplit(); //

        findTheNumberOfPotentialQuadsInThisGridItem();

        forEachQuadInTheGridItemCreateANewBranchWhereItsTheOnlyQuad();

        branchQueue.removeCurrentBranch();
    }

    private void forEachQuadInTheGridItemCreateANewBranchWhereItsTheOnlyQuad() {
        for(int quadIndex = 0; quadIndex < numberOfPotentialQuadsInThisGridItem; quadIndex++) {
            branchCopy = branchQueue.deepCopyTheCurrentBranch();

            setThisQuadToBeTheOnlyQuadInThisGridItem(quadIndex);

            branchQueue.createNewBranch(branchCopy);

            System.out.println("New branch " + branchQueue.getNewBranchKeyNumber() + " created from branch " + branchQueue.getCurrentBranchNumber());
            System.out.println(Arrays.deepToString(branchCopy) + "\n");
        }
    }

    private void setThisQuadToBeTheOnlyQuadInThisGridItem(int quadIndex) {
        System.arraycopy(branchCopy[gridItemToSplit][quadIndex], 0, branchCopy[gridItemToSplit][0], 0, NUMBER_OF_QUAD_ITEM_VALUES);

        for (int quadI = 1; quadI < NUMBER_OF_QUAD_ITEMS; quadI++)
            for (int quadValue = 0; quadValue < NUMBER_OF_QUAD_ITEM_VALUES; quadValue++)
                branchCopy[gridItemToSplit][quadI][quadValue] = 0;
    }

    private void findTheNumberOfPotentialQuadsInThisGridItem() {
        for(int quad = 0; quad < NUMBER_OF_QUAD_ITEMS; quad++) {
            if(!isAnEmptyQuad(branchQueue.currentBranch[gridItemToSplit][quad])) numberOfPotentialQuadsInThisGridItem++;
            else break;
        }
    }

    private int findGridItemToSplit() {
        for (int gridItem = 0; gridItem < NUMBER_OF_GRID_ITEMS; gridItem++) {
            if (branchQueue.currentBranch[gridItem][0][5] == UNUSED) {
                return gridItem;
            }
        }
        return NOT_FOUND;
    }

    public boolean isAnEmptyQuad(int[] quad) {
        return quad[0] == 0;
    }
}
