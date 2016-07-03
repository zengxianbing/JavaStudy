package com.zxb.guava3;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cengxianbing on 2015/11/23.
 */
public class ImmutableListTest {
    @Test
    public void testUnmodifiableList() {
        final List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);

        final List<Integer> wrapedList = Collections.unmodifiableList(list);
        System.out.println(wrapedList);

        list.add(3);
        System.out.println(wrapedList);
    }

    @Test
    public void testList() {
        ImmutableList<Integer> iList = ImmutableList.of(1, 2);
        System.out.println(iList);
        iList = ImmutableList.copyOf(iList);
        System.out.println(iList);

        iList = ImmutableList.copyOf(new Integer[]{1, 2, 3, 4});
        System.out.println(iList);

        iList = ImmutableList.of(6);
        System.out.println(iList);

        ImmutableList<Integer> iList1 = ImmutableList.of();
        ImmutableList<Integer> iList2 = ImmutableList.of();
        System.out.println(iList1 == iList2);

        ImmutableList.Builder<Integer> builder = ImmutableList.builder();
        builder.add(1);
        builder.add(2, 3);
        builder.addAll(iList);

        iList = builder.build();
        System.out.println(iList);
    }
}
