package com.zxb.java8;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2016/3/13.
 *
 * @author <a href=mailto:zengxianbing163@163.com>ÔøÏÜ±ø</a>
 */
public class StreamTest {

    @Test
    public void testStream() {
        List<String> l = new ArrayList<>(Arrays.asList("one", "two"));
        Stream<String> s1 = l.stream();
        l.add("three");
        s1.forEach(System.out::println);


        List<String> l2 = Stream.of("a", "b", "c", "b")
                .distinct()
                .collect(Collectors.toList());
        System.out.println(l2);


        List<Integer> l3 = IntStream.range(1, 10)
                .filter(i -> i % 2 == 2)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(l3);


        List<Integer> l4 = Stream.of('a', 'b', 'c')
                .map(c -> c.hashCode())
                .collect(Collectors.toList());
        System.out.println(l4);

        String poetry = "Where, before me, are the ages that have gone?\n" +
                "And where, behind me, are the coming generations?\n" +
                "I think of heaven and earth, without limit, without end,\n" +
                "And I am all alone and my tears fall down.";
        Stream<String> lines = Arrays.stream(poetry.split("\n"));
        Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(" ")));
        List<String> l5 = words.map(w -> {
            if (w.endsWith(",") || w.endsWith(".") || w.endsWith("?")) {
                return w.substring(0, w.length() - 1).trim().toLowerCase();
            } else {
                return w.trim().toLowerCase();
            }

        }).distinct().sorted().collect(Collectors.toList());
        System.out.println(l5);


        System.out.println(Stream.of(1,2,3,4,5).allMatch(i->i>0));
        System.out.println(Stream.of(1,2,3,4,5).anyMatch(i -> i > 0));
        System.out.println(Stream.of(1,2,3,4,5).noneMatch(i -> i > 0));
        System.out.println(Stream.<Integer>empty().allMatch(i->i>0));
        System.out.println(Stream.<Integer>empty().anyMatch(i->i>0));
        System.out.println(Stream.<Integer>empty().noneMatch(i->i>0));





























    }
}
