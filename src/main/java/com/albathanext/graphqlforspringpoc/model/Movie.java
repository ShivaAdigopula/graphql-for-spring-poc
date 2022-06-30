package com.albathanext.graphqlforspringpoc.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private Integer id;
    public String title;
    public String poster_path;
}
