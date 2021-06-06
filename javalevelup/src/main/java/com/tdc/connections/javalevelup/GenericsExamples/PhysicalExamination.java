package com.tdc.connections.javalevelup.GenericsExamples;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class PhysicalExamination {
    
    public static Person findTallest(final List<? extends Person> people){
        return people.stream().max(Comparator.comparingInt(Person::getHeight))
                                    .orElseThrow(NoSuchElementException::new);
    }
}
