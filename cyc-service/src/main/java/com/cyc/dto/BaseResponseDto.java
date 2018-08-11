package com.cyc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author pavser.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseDto
{
    private List<Integer> numberList;
}
