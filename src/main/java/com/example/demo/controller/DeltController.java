package com.example.demo.controller;

import com.example.demo.model.DeltRequest;
import com.example.demo.model.DeltResponse;
import com.example.demo.service.DeltService;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequestMapping("/fnel/delt/lot/v1")
@Slf4j
public class DeltController {


    DeltService deltService;

    public DeltController(DeltService deltService) {
        this.deltService = deltService;
    }


    @PostMapping(value = "/delt", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Observable<DeltResponse> setLotDelt(@RequestBody DeltRequest deltRequest) throws SQLException {
        /*Connection conn = null;*/
        return deltService.setLotInDelt(/*conn,*/ deltRequest);
    }

}
