package com.cyc.mapper;

import com.cyc.dto.BaseResponseDto;
import java.util.List;

/**
 * A mapper class
 *
 * @author pavser.
 */
public class SortingMapper
{
    public BaseResponseDto toBaseResponse(List<Integer> list)
    {
        BaseResponseDto dto = new BaseResponseDto();
        dto.setNumberList(list);
        return dto;
    }
}
