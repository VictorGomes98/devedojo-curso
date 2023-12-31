package com.youtube_devedojo.crud.dominio;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Builder
@Value
@Getter
public class Anime {
    Integer id;
    String name;
    int episodes;
    Producer producer;
}
