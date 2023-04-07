package com.bike.repair.Controller.customer.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter

@Data
public class UserDataDto {

    @NotEmpty(message = "username can not be empty ")
    private String username;

    @NotEmpty(message = "min length should be of 3 and max length be 10")
    @Size(max = 10 ,min = 3)
    private String password;

    @NotEmpty(message = "brand name can not be empty")
    private String brand_name;

    @NotEmpty(message = "model name can not be empty")
    private String model_name;

    @NotEmpty(message = "manufacturing year can not be empty")
    private String manufacturing_year;

}
