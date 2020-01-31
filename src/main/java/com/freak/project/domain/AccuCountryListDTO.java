package com.freak.project.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AccuCountryListDTO {
    private String ID;
    private String LocalizedName;
    private String EnglishName;
}
