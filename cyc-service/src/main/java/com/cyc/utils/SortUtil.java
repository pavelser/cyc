package com.cyc.utils;

import java.util.Collections;
import java.util.List;

/**
 * A utility class for different types of sorting
 *
 * @author pavser.
 */
public class SortUtil
{
    /**
     * Method to sort a given list of Integers in ascending order
     *
     * @param inputList List of integers to be sorted
     */
    public void ascendingSortUsingCollections(List<Integer> inputList)
    {
        Collections.sort(inputList);
    }

    /**
     * Method to sort a given list of Integers in descending order
     * @param inputList
     */
    public void descendingSortUsingCollections(List<Integer> inputList)
    {
        Collections.sort(inputList);
        Collections.reverse(inputList);
    }

    public void reverseUsingCollections(List<Integer> list)
    {
        Collections.reverse(list);
    }
}
