package com.learning.spring.learningspring.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

//@JsonIgnoreProperties(value={"field1"})
@JsonFilter("SomeBeanFilter")
@Data
@AllArgsConstructor
@ToString
public class SomeBean {
    private String field1;
    private String field2;

//    @JsonIgnore
    private String field3;

}
