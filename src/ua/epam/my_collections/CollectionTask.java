package ua.epam.my_collections;

import java.util.*;

/**
 * Created by Flower on 12/9/2015.
 */
public class CollectionTask {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 3, 4, 5, 6, 4, 5, 2, 3, 4};
        Map<Integer, Integer> repCount = new HashMap<>();

        for (int a : array) {
            Integer value = repCount.get(a);

            if (value == null) {
                repCount.put(a, 1);
            } else {
                repCount.put(a, value + 1);
            }
        }

        System.out.println(repCount);

        Map<Integer, List<Integer>> mapByRepeat = new TreeMap<>();

        for (Map.Entry<Integer, Integer> entry : repCount.entrySet()) {
            int repeats = entry.getValue();
            int value = entry.getKey();

            List<Integer> values = mapByRepeat.get(repeats);
            if (values != null) {
                values.add(value);
            } else {
                mapByRepeat.put(repeats, new LinkedList<Integer>() {
                    //TODO
                    //add(value);
                });
            }
        }

        int index = 0;

        for (int repeats: mapByRepeat.keySet()) {
            for (int value: mapByRepeat.get(repeats)) {
                for (int i = 0; i < repeats; i++) {
                    array[index++] = value;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
