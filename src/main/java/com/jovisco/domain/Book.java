package com.jovisco.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Book {

    public int id;
    public String title;
    public String author;
    public int yearOfPublication;
    public String genre;
}
