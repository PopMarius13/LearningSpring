package com.learning.spring.learningspring.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Name {

    private String firstName;
    private String lastName;

}
