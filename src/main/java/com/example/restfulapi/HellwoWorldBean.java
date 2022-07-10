package com.example.restfulapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor //default생성자 같이 만들어짐
public class HellwoWorldBean {
    private String message;

}
