package com.gerry.asset.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AssertDTO {
    @NotNull
    Double initAssert;

    @NotNull
    Integer years;

    @NotNull
    Double rate;
}
