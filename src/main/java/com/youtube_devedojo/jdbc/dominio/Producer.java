package com.youtube_devedojo.jdbc.dominio;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Builder
@Value
@Getter
public class Producer {
    Integer id;
    String name;


}
