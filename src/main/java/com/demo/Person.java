package com.demo;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
@Builder
public class Person<T>{
    private Integer age ;
    private String name ;
    private T location ;
}
