package com.api.rest.springdata.bootcamp.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerTypeResponseDto {
    private List<CustomerTypeDto> contentPage;
    private int pageNumber;
    private int pageSize;
    private Long allElements;
    private int allPages;
    private boolean lastPage;
}
