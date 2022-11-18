package tests.collections.set;

import main_package.config.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class SetTests extends BaseTest {
    @Test
    void setStreamTest() {
        Set<Integer> intSet = new HashSet<>();
        List<Integer> listInteger = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,11,12,13,14);
        for (Integer item:listInteger
        ) {
            intSet.add(item);
        }
        intSet.stream().forEach(
                System.out::println
        );
    }

    @Test
    void setStreamTest2() {
        List<Integer> listInteger = Arrays.asList(1,2,3,111,5,159751, 6,7,8,9,10,11,11,12,13,14,4,2,9,1,3,2);
        Set<Integer> setInt = listInteger.stream().collect(Collectors.toSet());
        TreeSet<Integer> treeInt = new TreeSet<Integer>();
        setInt.stream().forEach(u-> treeInt.add(u));
        treeInt.stream().forEach(System.out::println);
    }
}
