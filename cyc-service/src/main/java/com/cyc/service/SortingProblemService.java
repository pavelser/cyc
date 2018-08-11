package com.cyc.service;

import com.cyc.dto.BaseRequestDto;
import com.cyc.dto.BaseResponseDto;
import com.cyc.mapper.SortingMapper;
import com.cyc.utils.SortUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * A service class that provides sorting service
 *
 * @author pavser.
 */
public class SortingProblemService
{
    private SortUtil sortUtil = new SortUtil();
    private SortingMapper sortingMapper = new SortingMapper();

    /**
     * Method to provide k largest numbers.
     *
     * @param dto The request dto
     * @return An object representing {@link BaseResponseDto}
     */
    public BaseResponseDto findKLargestNumbers(BaseRequestDto dto)
    {
        List<Integer> numberList = dto.getNumberList();
        //if the list is empty, return as it is
        if (numberList.isEmpty())
        {
            return sortingMapper.toBaseResponse(numberList);
        }

        // non-empty list, sort it
        int count = dto.getCount();
        //sortTheList(numberList, dto.isAscending());
        sortUtil.ascendingSortUsingCollections(numberList);

        // if the list is empty or size of the request is less than requested size
        if (numberList.size() <= count)
        {
            return mapToResponse(numberList, dto.isAscending());
        }

        return getKNumbers(numberList, numberList.size() - count, numberList.size(), dto.isAscending());
    }

    /**
     * This method provides a k smallest numbers.
     * @param dto The request dto
     * @return An object representing {@link BaseResponseDto}
     */
    public BaseResponseDto findKSmallestNumbers(BaseRequestDto dto)
    {
        List<Integer> numberList = dto.getNumberList();
        //if the list is empty, return as it is
        if (numberList.isEmpty())
        {
            return sortingMapper.toBaseResponse(numberList);
        }

        // non-empty list, sort it
        int count = dto.getCount();
        sortUtil.ascendingSortUsingCollections(numberList);

        // if the list is empty or size of the request is less than requested size
        if (numberList.size() <= count)
        {
            return mapToResponse(numberList, dto.isAscending());
        }

        return getKNumbers(numberList, 0, count, dto.isAscending());
    }

    /**
     * This method provides a k largest or smallest numbers.
     * @param dto The request dto
     * @return An object representing {@link BaseResponseDto}
     */
    public BaseResponseDto getKLargestOrSmallestNumbers(BaseRequestDto dto)
    {
        List<Integer> numberList = dto.getNumberList();
        //if the list is empty, return as it is
        if (numberList.isEmpty())
        {
            return sortingMapper.toBaseResponse(numberList);
        }

        // non-empty list, sort it
        int count = dto.getCount();
        //sortTheList(numberList, dto.isAscending());
        sortUtil.ascendingSortUsingCollections(numberList);

        // if the list is empty or size of the request is less than requested size
        if (numberList.size() <= count)
        {
            return mapToResponse(numberList, dto.isAscending());
        }

        int startIndex = 0;
        int endIndex = count;

        if(dto.isLargest())
        {
            startIndex = numberList.size() - count;
            endIndex = numberList.size();
        }
        return getKNumbers(numberList, startIndex, endIndex, dto.isAscending());
    }

    private BaseResponseDto getKNumbers(List<Integer> numberList, int start, int end, boolean ascending)
    {
        List<Integer> largestKList = new ArrayList<>();
        for (int i = start ; i < end; i++)
        {
            largestKList.add(numberList.get(i));
        }
        return mapToResponse(largestKList, ascending);
    }

    private BaseResponseDto mapToResponse(List<Integer> list, boolean ascending)
    {
        orderList(list, ascending);
        return sortingMapper.toBaseResponse(list);
    }

    private void orderList(List<Integer> list, boolean ascending)
    {
        if (!ascending)
        {
            sortUtil.reverseUsingCollections(list);
        }
    }
}
