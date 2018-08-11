package com.cyc.resource;

import com.cyc.dto.BaseRequestDto;
import com.cyc.dto.BaseResponseDto;
import com.cyc.service.SortingProblemService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Resource class for sorting
 *
 * @author pavser.
 */
@Path("/sorting")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SortingProblemResource
{
    private SortingProblemService sortingProblemService = new SortingProblemService();

    /**
     * Method to get k largest numbers in ascending or descending order.
     * Sample json input:
     * {
     *      "numberList": [1,5,4,3,7,2]
     *      "count": 3
     *      "ascending": true
     * }
     * Sample response json:
     * {
     *     "numberList": [4,5,7]
     * }
     * @param requestDto The request dto
     * @return An object containing sorted list
     */
    @POST
    @Path("k-largest")
    public BaseResponseDto getKLargestNumbers(BaseRequestDto requestDto)
    {
        return sortingProblemService.findKLargestNumbers(requestDto);
    }

    /**
     * Method to get k smallest numbers in ascending or descending order.
     * Sample json input:
     * {
     *      "numberList": [1,5,4,3,7,2]
     *      "count": 3
     *      "ascending": true
     * }
     * Sample response json:
     * {
     *     "numberList": [1,2,3]
     * }
     * @param requestDto The request dto
     * @return An object containing sorted list
     */
    @POST
    @Path("k-smallest")
    public BaseResponseDto getKSmallestNumbers(BaseRequestDto requestDto)
    {
        return sortingProblemService.findKSmallestNumbers(requestDto);
    }

    /**
     * Method to get k largest or smallest numbers in ascending or descending order based on the request.
     * Sample json input:
     * {
     *      "numberList": [1,5,4,3,7,2]
     *      "count": 3
     *      "ascending": true,
     *      "largest": false
     * }
     * Sample response json:
     * {
     *     "numberList": [1,2,3]
     * }
     * @param requestDto The request dto
     * @return An object containing sorted list
     */
    @POST
    @Path("k-largest-smallest")
    public BaseResponseDto getKLargestOrSmallestNumbers(BaseRequestDto requestDto)
    {
        return sortingProblemService.getKLargestOrSmallestNumbers(requestDto);
    }

}
