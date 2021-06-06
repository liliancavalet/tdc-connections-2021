package com.tdc.connections.javalevelup.GenericsExamples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PhysicalExaminationTests {
    
    @Test
    void generics_method_with_wild_card(){
        Child child1 = new Child("Jhon Doe", 95);
        Child child2 = new Child("Jane Doe", 103);
        Child child3 = new Child("Richard Roe", 147);
        List<Child> children = new ArrayList<>();
        Collections.addAll(children, child1, child2, child3);

        Person tallest = PhysicalExamination.findTallest(children);
        
        assertEquals(child3, tallest);
    }
}
