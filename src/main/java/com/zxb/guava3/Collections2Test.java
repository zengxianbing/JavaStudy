package com.zxb.guava3;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2016/1/7.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class Collections2Test {
    @Test
    public void whenFilterWithIterables_thenFiltered() {
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        Iterable<String> result = Iterables.filter(names, Predicates.containsPattern("a"));
        assertThat(result, containsInAnyOrder("Jane", "Adam"));
    }

    @Test
    public void whenFilterWithCollections2_thenFiltered() {
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");

        Collection<String> result = Collections2.filter(names, Predicates.containsPattern("a"));
        assertEquals(2, result.size());
        result.add("anna");
        assertEquals(5, names.size());
    }

    @Test
    public void whenFilterCollectionWithCustomPredicate_thenFiltered() {
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.startsWith("A") || input.startsWith("J");
            }
        };
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        Collection<String> result = Collections2.filter(names, predicate);
        assertEquals(3, result.size());
        assertEquals(result, containsInAnyOrder("John", "Jane", "Adam"));


    }

    @Test
    public void whenFilterUsingMultiplePredicates_thenFiltered() {
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        Collection<String> result = Collections2.filter(names,
                Predicates.or(Predicates.containsPattern("J"),
                        Predicates.not(Predicates.containsPattern("a"))));
        assertEquals(3, result.size());
        assertThat(result, containsInAnyOrder("John", "Jane", "Tom"));
    }

    @Test
    public void whenRemoveNullFromCollection_thenRemoved() {
        List<String> names = Lists.newArrayList("John", null, "Jane", null, "Adam", "Tom");
        Collection<String> result = Collections2.filter(names, Predicates.notNull());
        assertEquals(4, result.size());
        assertThat(result, containsInAnyOrder("John", "Jane", "Adam", "Tom"));
    }

    @Test
    public void whenCheckingIfAllElementsMatchACondition_thenCorrect() {
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        Boolean result = Iterables.all(names, Predicates.containsPattern("n|m"));
        assertTrue(result);
        result = Iterables.all(names, Predicates.containsPattern("a"));
        assertFalse(result);
    }

    @Test
    public void whenTransformWithIterables_thenTransformed() {
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return input.length();
            }
        };
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        Iterable<Integer> result = Iterables.transform(names, function);
        assertThat(result, contains(4, 4, 4, 3));
    }

    @Test
    public void whenCreatingAFunctionFromAPredicate_thenCorrect() {
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        Collection<Boolean> result = Collections2.transform(names,
                Functions.forPredicate(Predicates.containsPattern("m")));
        assertEquals(4, result.size());
        assertThat(result, contains(false, false, true, true));
    }

    @Test
    public void whenTransformingUsingComposedFunction_thenTransformed() {
        Function<String, Integer> f1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return input.length();
            }
        };
        Function<Integer, Boolean> f2 = new Function<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer input) {
                return input % 2 == 0;
            }
        };
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        Collection<Boolean> result = Collections2.transform(names,
                Functions.compose(f2, f1));

        assertEquals(4, result.size());
        assertThat(result, contains(true, true, true, false));


    }

    @Test
    public void whenFilteringAndTransformingCollection_thenCorrect() {
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.startsWith("A") || input.startsWith("T");
            }
        };

        Function<String, Integer> func = new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return input.length();
            }
        };
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        Collection<Integer> result = FluentIterable.from(names)
                .filter(predicate)
                .transform(func)
                .toList();
        assertEquals(2, result.size());
        assertThat(result, containsInAnyOrder(4, 3));

    }
}
