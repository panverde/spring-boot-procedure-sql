package com.example.demo.service;

import com.example.demo.model.DeltRequest;
import com.example.demo.model.DeltResponse;
import io.reactivex.Observable;

import java.sql.Connection;
import java.sql.SQLException;

public interface DeltService {

    Observable<DeltResponse> setLotInDelt(/*Connection conn,*/ DeltRequest request) throws SQLException;

}
