package com.tdc.connections.javalevelup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class CollectionsTests {

	@Test
	void tallest_child_example(){
        int childrensHeights[] = { 95, 103, 147, 110 };
        int arrayLength = 4;
        int tallest = childrensHeights[0];

        for (int i = 0; i < arrayLength; i++) {
            if (tallest < childrensHeights[i]) {
                tallest = childrensHeights[i];
            }
        }

        System.out.print(tallest); //147
		assertEquals(147, tallest);		
	}

	@Test
	void tallest_child_example_via_collections() {
        List<Integer> childrensHeights = new ArrayList<>();
        childrensHeights.add(95);
        childrensHeights.add(103);
        Collections.addAll(childrensHeights, 147, 110);
        int tallest = childrensHeights.get(0);

        for (Integer height : childrensHeights) {
            if (tallest < height) {
                tallest = height;
            }
        }

        System.out.print(tallest); // 147
		assertEquals(147, tallest);		
	}

	@Test
	void tallest_child_example_via_collections_stream() {
		List<Integer> childrensHeights = new ArrayList<>();
        childrensHeights.add(95);
        childrensHeights.add(103);
        Collections.addAll(childrensHeights, 147, 110);

        int tallest = childrensHeights.stream()
                                    .mapToInt(v -> v)
                                    .max()
                                    .orElseThrow(NoSuchElementException::new);

        System.out.print(tallest); // 147
		assertEquals(147, tallest);
	}

	@Test
	void tallest_child_example_showing_collections_unmodifiable() {
        List<Integer> childrensHeights = new ArrayList<>();
        childrensHeights.add(95);
        childrensHeights.add(103);
        Collections.addAll(childrensHeights, 147, 110);

        List<Integer> childrensHeightsUnmodifiableList = Collections.unmodifiableList(childrensHeights);
        assertThrows(UnsupportedOperationException.class, () -> childrensHeightsUnmodifiableList.add(111));

        childrensHeights.add(111);
        assertEquals(childrensHeights, Arrays.asList(95, 103, 147, 110, 111));
	}

    @Test
    void tallest_child_example_showing_collections_arrays_as_list_usage() {
        List<Integer> childrensHeightsViaArrayAsList = Arrays.asList(95, 103, 147, 110);
        assertThrows(UnsupportedOperationException.class, () -> childrensHeightsViaArrayAsList.add(111));

        List<Integer> childrensHeightsViaArrayList = new ArrayList<>(Arrays.asList(95, 103, 147, 110));
        childrensHeightsViaArrayList.add(111);
        assertEquals(childrensHeightsViaArrayList, Arrays.asList(95, 103, 147, 110, 111));
    }

	@Test
	void tallest_child_example_via_collections_without_generics() {
        List childrensHeights = new ArrayList();
        childrensHeights.add(95);
        childrensHeights.add(103);
        Collections.addAll(childrensHeights, 147, 110);
        Integer tallest = (Integer) childrensHeights.get(0);
        for(Object height : childrensHeights) {
            if (tallest < (Integer) height) {
                tallest = (Integer) height;
            }
        }
        System.out.print(tallest); // 147
		assertEquals(147, tallest);	
	}
}
