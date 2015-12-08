package ua.epam.my_collections;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dennis
 *
 * on 12/8/2015.
 */
@SuppressWarnings("unchecked")
public class MyHashMapTest {

    MyHashMap<String, String> map = new MyHashMap(){{
        put("one", "one");
        put("two", "two");
        put("three", "two");
        put("four", "two");
        put("five", "two");
        put("six", "two");
        put("seven", "two");
        put("eight", "two");
        put("nine", "two");
        put("ten", "two");
        put("eleven", "two");
        put("sdsdfs", "two");
        put("fds", "two");
        put("cxvxv", "two");
        put("ersdf", "two");
        put("dfsg", "two");
        put("asdaw", "two");
        put("lfdfk", "two");
    }};

    @Test
    public void removeTest() {

        map.showNodes();

        System.out.println();
        System.out.println(map.size());

        System.out.println(map.remove("nine"));
        System.out.println(map.size());

        System.out.println();

        map.showNodes();
    }

    @Test
    public void getTest() {
        assertEquals("one", map.get("one"));
    }
}