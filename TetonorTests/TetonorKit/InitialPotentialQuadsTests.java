package TetonorKit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class InitialPotentialQuadsTests {

    @Test
    public void endToEndTest() {
        SolveTetonor solver = new SolveTetonor(new int[]{50, 40, 135, 32, 49, 208, 19, 252,
                256, 32, 264, 48, 34, 175, 48, 134}, new int[]{1, 2, 3, 0, 0, 8, 0, 0, 0, 16, 0, 26, 0, 0, 49, 0});
        InitialPotentialQuads initialQuads = new InitialPotentialQuads();
        int[][][] result = initialQuads.findPotentialQuads();
        assertEquals("[[[5, 34, 19, 2, 17, 0], [5, 48, 19, 3, 16, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[5, 135, 32, 5, 27, 0], [5, 175, 32, 7, 25, 0], [5, 252, 32, 14, 18, 0], [5, 256, 32, 16, 16, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[5, 135, 32, 5, 27, 0], [5, 175, 32, 7, 25, 0], [5, 252, 32, 14, 18, 0], [5, 256, 32, 16, 16, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 34, 19, 2, 17, 0], [5, 208, 34, 8, 26, 0], [5, 264, 34, 12, 22, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[5, 175, 40, 5, 35, 0], [5, 256, 40, 8, 32, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 49, 48, 1, 48, 0], [111, 48, 19, 3, 16, 0], [5, 135, 48, 3, 45, 0], [5, 252, 48, 6, 42, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 49, 48, 1, 48, 0], [111, 48, 19, 3, 16, 0], [5, 135, 48, 3, 45, 0], [5, 252, 48, 6, 42, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 50, 49, 1, 49, 0], [5, 49, 48, 1, 48, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[5, 50, 49, 1, 49, 0], [5, 264, 50, 6, 44, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 135, 134, 1, 134, 0], [5, 264, 134, 2, 132, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 135, 48, 3, 45, 0], [111, 135, 32, 5, 27, 0], [5, 135, 134, 1, 134, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 175, 40, 5, 35, 0], [111, 175, 32, 7, 25, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 208, 34, 8, 26, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 252, 48, 6, 42, 0], [111, 252, 32, 14, 18, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 256, 40, 8, 32, 0], [111, 256, 32, 16, 16, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 264, 134, 2, 132, 0], [111, 264, 50, 6, 44, 0], [111, 264, 34, 12, 22, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]]]", Arrays.deepToString(result));

        SolveTetonor solver2 = new SolveTetonor(new int[]{10, 12, 25, 99, 45, 20, 16, 28, 64, 20, 15, 14, 8, 36, 11, 16},
                new int[]{0, 2, 0, 3, 5, 5, 5, 5, 0, 8, 9, 0, 11, 11, 14, 18});
        InitialPotentialQuads initialQuads2 = new InitialPotentialQuads();
        int[][][] result2 = initialQuads2.findPotentialQuads();
        assertEquals("[[[5, 12, 8, 2, 6, 0], [5, 15, 8, 3, 5, 0], [5, 16, 8, 4, 4, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 11, 10, 1, 10, 0], [5, 16, 10, 2, 8, 0], [5, 25, 10, 5, 5, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 12, 11, 1, 11, 0], [5, 11, 10, 1, 10, 0], [5, 28, 11, 4, 7, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 12, 8, 2, 6, 0], [5, 12, 11, 1, 11, 0], [5, 20, 12, 2, 10, 0], [5, 36, 12, 6, 6, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 15, 14, 1, 14, 0], [5, 45, 14, 5, 9, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 16, 15, 1, 15, 0], [111, 15, 8, 3, 5, 0], [5, 15, 14, 1, 14, 0], [5, 36, 15, 3, 12, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 16, 10, 2, 8, 0], [111, 16, 8, 4, 4, 0], [5, 16, 15, 1, 15, 0], [5, 28, 16, 2, 14, 0], [5, 64, 16, 8, 8, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 16, 10, 2, 8, 0], [111, 16, 8, 4, 4, 0], [5, 16, 15, 1, 15, 0], [5, 28, 16, 2, 14, 0], [5, 64, 16, 8, 8, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 20, 12, 2, 10, 0], [5, 36, 20, 2, 18, 0], [5, 64, 20, 4, 16, 0], [5, 99, 20, 9, 11, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 20, 12, 2, 10, 0], [5, 36, 20, 2, 18, 0], [5, 64, 20, 4, 16, 0], [5, 99, 20, 9, 11, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 25, 10, 5, 5, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 28, 16, 2, 14, 0], [111, 28, 11, 4, 7, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 36, 20, 2, 18, 0], [111, 36, 15, 3, 12, 0], [111, 36, 12, 6, 6, 0], [5, 99, 36, 3, 33, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 45, 14, 5, 9, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 64, 20, 4, 16, 0], [111, 64, 16, 8, 8, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]], [[111, 99, 36, 3, 33, 0], [111, 99, 20, 9, 11, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]]]", Arrays.deepToString(result2));
    }
}