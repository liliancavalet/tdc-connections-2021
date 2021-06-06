package com.tdc.connections.javalevelup.GenericsExamples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Converter {

    public static <T> List<T> fromArrayToList(T[] a) {   
        return Arrays.stream(a).collect(Collectors.toList());
    }

    public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
        return Arrays.stream(a)
          .map(mapperFunction)
          .collect(Collectors.toList());
    }

    public static <T extends Person> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }
}
