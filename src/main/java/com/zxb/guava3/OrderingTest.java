package com.zxb.guava3;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.List;

/**
 * Created by cengxianbing on 2015/11/25.
 */
public class OrderingTest {

    @Test
    public void testStaticOrding() {
        List<String> list = Lists.newArrayList();
       list.add("peida");
        list.add("jerry");
        list.add("harry");
        list.add("jhon");
        list.add("neron");
        System.out.println("list:" + list);

        Ordering<String> naturalOrdering = Ordering.natural();
        Ordering<Object> usingToStringOrdering = Ordering.usingToString();
        Ordering<Object> arbitraryOrdering = Ordering.arbitrary();


        System.out.println("naturalOrdering:" + naturalOrdering.sortedCopy(list));
        System.out.println("usingToStringOrdering:" + usingToStringOrdering.sortedCopy(list));
        System.out.println("arbitaryOrdering:" + arbitraryOrdering.sortedCopy(list));

    }

}
