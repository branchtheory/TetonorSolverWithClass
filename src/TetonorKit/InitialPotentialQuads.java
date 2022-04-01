package TetonorKit;

import java.util.Arrays;

import static TetonorKit.TetonorSolver.*;

public class InitialPotentialQuads {
    
    private int[][][] potentialQuads = new int[16][8][6];

    private int gridItem;
    private int gridItemIndex;
    private int linePair1;
    private int gridPair;
    private int linePair2;
    private double valueAtWhichLinePair1IsGreaterThanLinePair2;
    private int indexNumberToPutTheNextQuadInto = 0;
    private int mathematicalFunction;

    public int[][][] findPotentialQuads() {
        for (gridItemIndex = 0; gridItemIndex < NUMBER_OF_GRID_ITEMS; gridItemIndex++) {
            gridItem = grid16[gridItemIndex];

            searchForQuadsInWhichThisGridItemIsTheProductOfTwoLineItems();
            searchForQuadsInWhichThisGridItemIsTheSumOfTwoLineItems();

            resetValuesForTheNextGridItem();
        }
        return potentialQuads;
    }

    private void searchForQuadsInWhichThisGridItemIsTheProductOfTwoLineItems() {
        mathematicalFunction = PRODUCT_SIGNIFIER;

        valueAtWhichLinePair1IsGreaterThanLinePair2 = Math.sqrt(grid16[gridItemIndex]) + 1;

        for (linePair1 = 1; linePair1 < valueAtWhichLinePair1IsGreaterThanLinePair2; linePair1++) {
            linePair2 = gridItem / linePair1;
            gridPair = linePair1 + linePair2;

            if (linePair2IsAWholeNumber() && gridPairActuallyExistsInGrid16()) {
                addThisQuadToPotentialQuads();
                indexNumberToPutTheNextQuadInto++;
            }
        }
    }

    private void searchForQuadsInWhichThisGridItemIsTheSumOfTwoLineItems() {
        mathematicalFunction = SUM_SIGNIFIER;

        valueAtWhichLinePair1IsGreaterThanLinePair2 = (double) (gridItem / 2) + 1;

        for (linePair1 = 1; linePair1 < valueAtWhichLinePair1IsGreaterThanLinePair2; linePair1++) {

            linePair2 = gridItem - linePair1;
            gridPair = linePair1 * linePair2;

            if (gridPairActuallyExistsInGrid16()) {
                addThisQuadToPotentialQuads();
                indexNumberToPutTheNextQuadInto++;
            }
        }
    }

    private boolean linePair2IsAWholeNumber() {
        return gridItem % linePair1 == 0;
    }

    private void addThisQuadToPotentialQuads() {
        potentialQuads[gridItemIndex][indexNumberToPutTheNextQuadInto][0] = mathematicalFunction;
        potentialQuads[gridItemIndex][indexNumberToPutTheNextQuadInto][1] = Math.max(gridItem, gridPair);
        potentialQuads[gridItemIndex][indexNumberToPutTheNextQuadInto][2] = Math.min(gridItem, gridPair);
        potentialQuads[gridItemIndex][indexNumberToPutTheNextQuadInto][3] = linePair1;
        potentialQuads[gridItemIndex][indexNumberToPutTheNextQuadInto][4] = linePair2;
        potentialQuads[gridItemIndex][indexNumberToPutTheNextQuadInto][5] = UNUSED;
    }

    private boolean gridPairActuallyExistsInGrid16() {
        boolean gridPairActuallyAppearsInGrid16;
        boolean gridItemAndTheGridPairAreDifferentGridItems;

        for (int potentialGridPairIndex = 0; potentialGridPairIndex < NUMBER_OF_GRID_ITEMS; potentialGridPairIndex++) {
            gridPairActuallyAppearsInGrid16 = grid16[potentialGridPairIndex] == gridPair;
            gridItemAndTheGridPairAreDifferentGridItems = potentialGridPairIndex != gridItemIndex;

            if (gridPairActuallyAppearsInGrid16 &&
                    gridItemAndTheGridPairAreDifferentGridItems) {
                return true;
            }
        }
        return false;
    }

    private void resetValuesForTheNextGridItem() {
        indexNumberToPutTheNextQuadInto = 0;
    }
}
