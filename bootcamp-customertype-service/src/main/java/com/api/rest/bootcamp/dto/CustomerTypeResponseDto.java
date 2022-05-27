package com.api.rest.bootcamp.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerTypeResponseDto {
    /**
     * list customer type dto.
     */
    private List<CustomerTypeDto> contentPage;
    /**
     * page number.
     */
    private int pageNumber;
    /**
     * page size.
     */
    private int pageSize;
    /**
     * all elements.
     */
    private Long allElements;
    /**
     * all pages.
     */
    private int allPages;
    /**
     * boolean true or false last page.
     */
    private boolean lastPage;
}
