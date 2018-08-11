package com.cyc.dto;

import lombok.Data;

import java.util.List;

/**
 * @author pavser.
 */
@Data
public class BaseRequestDto
{
    private List<Integer> numberList;
    private int count;
    private boolean ascending;
    private boolean largest;
}
