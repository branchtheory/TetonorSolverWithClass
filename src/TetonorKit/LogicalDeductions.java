package TetonorKit;

import java.util.Arrays;

import static TetonorKit.TetonorSolver.*;

public class LogicalDeductions {
    private boolean thereMayBeFurtherLogicalDeductionsToMake = true;
    private int singleQuadItemGrid16Value;
    private int singleQuadItemGrid16Index;
    private int correspondingItemGrid16Value;
    private int correspondingItemGrid16Index;

    public int deduceFromGridItemsWithOnlyOneQuad() {
        singleQuadItemGrid16Index = getTheIndexOfTheGridItemContainingTheSingleQuad();

        if (singleQuadItemGrid16Index == NOT_FOUND) {
            thereMayBeFurtherLogicalDeductionsToMake = false;
            return -1;
        } else {
            thereMayBeFurtherLogicalDeductionsToMake = true;
        }

        singleQuadItemGrid16Value = getTheValueOfTheGridItemContainingTheSingleQuad();

        correspondingItemGrid16Value = getCorrespondingItemGridItemValue();
        correspondingItemGrid16Index = getCorrespondingGridItemIndex();

        if (correspondingItemGrid16Index == NOT_FOUND) {
            branchQueue.currentBranch = BROKEN_BRANCH;
            thereMayBeFurtherLogicalDeductionsToMake = false;
            return -1;
        }

        removeAllQuadsInTheCorrespondingGridItemExceptTheOneThatLinksWithTheSingle();
        removeAllLinksToAGridItem(correspondingItemGrid16Index, correspondingItemGrid16Value);
        return 1;
    }

    public int deduceImmediatelyAfterASplit() {
        singleQuadItemGrid16Index = getTheIndexOfTheGridItemContainingTheSingleQuad();
        singleQuadItemGrid16Value = getTheValueOfTheGridItemContainingTheSingleQuad();

        correspondingItemGrid16Value = getCorrespondingItemGridItemValue();
        correspondingItemGrid16Index = getCorrespondingGridItemIndex();

        if (correspondingItemGrid16Index == NOT_FOUND) {
            branchQueue.currentBranch = BROKEN_BRANCH;
            return -1;
        }

        removeAllQuadsInTheCorrespondingGridItemExceptTheOneThatLinksWithTheSingle();
        removeAllLinksToAGridItem(correspondingItemGrid16Index, correspondingItemGrid16Value);
        removeAllLinksToAGridItem(singleQuadItemGrid16Index, singleQuadItemGrid16Value);

        return 1;
    }

    private int getTheIndexOfTheGridItemContainingTheSingleQuad() {
        for (int gridItem = 0; gridItem < grid16.length; gridItem++) {
            if (branchQueue.currentBranch[gridItem][0][5] == UNUSED && isAnEmptyQuad(branchQueue.currentBranch[gridItem][1])) {
                System.out.println("Single found at " + gridItem + ": " + Arrays.deepToString(branchQueue.currentBranch[gridItem]) + "\n");
                return gridItem;
            }
        }
        return NOT_FOUND;
    }

    public boolean thereMayBeFurtherLogicalDeductionsToMake() {
        return thereMayBeFurtherLogicalDeductionsToMake;
    }

    private int getTheValueOfTheGridItemContainingTheSingleQuad() {
        return grid16[singleQuadItemGrid16Index];
    }

    private int getCorrespondingGridItemIndex() {
        for (int gridItem = 0; gridItem < grid16.length; gridItem++) {
            if (grid16[gridItem] == correspondingItemGrid16Value && branchQueue.currentBranch[gridItem][0][5] == UNUSED) {
                return gridItem;
            }
        }
        return NOT_FOUND;
    }

    private int getCorrespondingItemGridItemValue() {
        return singleQuadItemGrid16Value ==
                branchQueue.currentBranch[singleQuadItemGrid16Index][0][1] ? branchQueue.currentBranch[singleQuadItemGrid16Index][0][2] : branchQueue.currentBranch[singleQuadItemGrid16Index][0][1];
    }

    private void removeAllQuadsInTheCorrespondingGridItemExceptTheOneThatLinksWithTheSingle() {
        branchQueue.currentBranch[singleQuadItemGrid16Index][0][5] = DONE;
        System.arraycopy(branchQueue.currentBranch[singleQuadItemGrid16Index][0], 0, branchQueue.currentBranch[correspondingItemGrid16Index][0], 0, NUMBER_OF_QUAD_ITEM_VALUES);
        branchQueue.currentBranch[correspondingItemGrid16Index][0][0] = branchQueue.currentBranch[singleQuadItemGrid16Index][0][0] == SUM_SIGNIFIER ? PRODUCT_SIGNIFIER : SUM_SIGNIFIER;
        for (int quad = 1; quad < NUMBER_OF_QUAD_ITEMS; quad++) {
            branchQueue.currentBranch[correspondingItemGrid16Index][quad] = emptyQuad;
        }
    }

    private void removeAllLinksToAGridItem(int itemIndex, int grid16Value) {
        if (itemIndex == 15 || grid16Value != grid16[itemIndex +1]) {
            for (int gridItem = 0; gridItem < grid16.length; gridItem++) {
                for (int quad = 0; quad < NUMBER_OF_QUAD_ITEMS; quad++) {
                    if (branchQueue.currentBranch[gridItem][quad][5] == UNUSED && !isAnEmptyQuad(branchQueue.currentBranch[gridItem][quad])) {
                        if (branchQueue.currentBranch[gridItem][quad][1] == grid16Value
                                || branchQueue.currentBranch[gridItem][quad][2] == grid16Value) {
                            branchQueue.currentBranch[gridItem][quad] = emptyQuad;
                            quadSorter(gridItem);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private void quadSorter (int gridItem) {
        int quad;
        boolean currentQuadIsEmpty;
        boolean nextQuadIsLive;
        boolean nextQuadIsEmpty;
        boolean nextNextQuadIsLive;
        int[] theNextLiveQuad;
        int[] theNextNextLiveQuad;

        for (quad = 0; quad < 5; quad++) {
            currentQuadIsEmpty = branchQueue.currentBranch[gridItem][quad][0] == 0;
            nextQuadIsLive = branchQueue.currentBranch[gridItem][quad + 1][0] != 0;
            nextQuadIsEmpty = branchQueue.currentBranch[gridItem][quad + 1][0] == 0;
            nextNextQuadIsLive = branchQueue.currentBranch[gridItem][quad + 2][0] != 0;
            theNextLiveQuad = branchQueue.currentBranch[gridItem][quad + 1];
            theNextNextLiveQuad = branchQueue.currentBranch[gridItem][quad + 2];

            if (currentQuadIsEmpty
                    && nextQuadIsLive) {
                branchQueue.currentBranch[gridItem][quad] = theNextLiveQuad;
                branchQueue.currentBranch[gridItem][quad + 1] = emptyQuad;
            } else if (quad < 4 &&
                    currentQuadIsEmpty
                    && nextQuadIsEmpty
                    && nextNextQuadIsLive) {
                branchQueue.currentBranch[gridItem][quad] = theNextNextLiveQuad;
                branchQueue.currentBranch[gridItem][quad + 2] = emptyQuad;
            }
        }
    }
}
