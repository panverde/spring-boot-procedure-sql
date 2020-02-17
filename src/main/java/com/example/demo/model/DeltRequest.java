package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
public class DeltRequest {
    private Lot lot;
    private ArrayList<LotDetail> lotDetail;
}
