package com.tdc.connections.javalevelup.GenericsExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConverterTests {

    @Test
    public void generics_method_single_param() {
        Integer childrensHeights[] = { 95, 103, 147, 110 };
        List<Integer> childrensHeightsAsIntegerList
        = Converter.fromArrayToList(childrensHeights);
    
        assertThat(childrensHeightsAsIntegerList, hasItems(95, 103, 147, 110));
    }

    @Test
    public void generics_method_multiple_param() {
        Integer childrensHeights[] = { 95, 103, 147, 110 };
        List<String> childrensHeightsAsStringList
        = Converter.fromArrayToList(childrensHeights, Object::toString);
    
        assertThat(childrensHeightsAsStringList, hasItems("95", "103", "147", "110"));
    }

    @Test
    public void generics_method_upper_bound_param() {
        Child child1 = new Child("Jhon Doe", 95);
        Child child2 = new Child("Jane Doe", 103);
        Child child3 = new Child("Richard Roe", 147);

        Child children[] = { child1, child2, child3 };
        List<Child> childrenAsList
        = Converter.fromArrayToList(children);
    
        assertThat(childrenAsList, hasItems(child1, child2, child3));
    }

    @Test
    public void generics_method_with_wild_card() {
        List<?> wildcards = new ArrayList<>();
        wildcards.add(null);
        System.out.println(wildcards); //[null]

        assertEquals(Collections.singletonList(null), wildcards);
    }
}
