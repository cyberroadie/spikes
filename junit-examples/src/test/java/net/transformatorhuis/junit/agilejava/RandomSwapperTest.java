package net.transformatorhuis.junit.agilejava;

import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class RandomSwapperTest {

    @Test
    public void randomSwapper() {
        List<Integer> checkList;
        List<Integer> swappedList;
        Swapper swapper = new Swapper();
        for (int i = 0; i < 10000; i++) {
            checkList = new ArrayList(swapper.getNumberList());
            swappedList = swapper.swap();
            checkSwap(swappedList, checkList);
        }
    }

    private boolean checkSwap(List swappedList, List checkList) {
        int firstPosition = -1;
        int secondPosition = -1;
        for (int i = 0; i < checkList.size(); i++) {
            if (checkList.get(i) != swappedList.get(i)) {
                if (firstPosition == -1) {
                    firstPosition = i;
                } else {
                    secondPosition = i;
                    if (swappedList.get(firstPosition) == checkList.get(secondPosition)
                            && swappedList.size() ==  checkList.size()) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        }
        return false;
    }
}

