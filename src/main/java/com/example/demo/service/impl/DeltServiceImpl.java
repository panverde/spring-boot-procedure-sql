package com.example.demo.service.impl;

import com.example.demo.model.DeltRequest;
import com.example.demo.model.DeltResponse;
import com.example.demo.model.Mesagge;
import com.example.demo.model.LotDetail;
import com.example.demo.service.DeltService;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
@Slf4j
public class DeltServiceImpl implements DeltService {

    private String blankSpace = " ";
    private String url = "jdbc:sqlserver://DESKTOP-4P32M5K:1433;databaseName=testdatabase";
    private String user="conexo";
    private String pass = "Joaquin06";



    @Override
    public Observable<DeltResponse> setLotInDelt(/*Connection conn,*/ DeltRequest request) throws SQLException {

        DeltResponse deltResponse = new DeltResponse();
        Mesagge msj = new Mesagge();


        Connection conn= DriverManager.getConnection(/*"${spring.datasource.url}"*/url,/*"{spring.datasource.username}"*/user
                ,/*"{spring.datasource.password}"*/pass);
        CallableStatement cstmt = conn.prepareCall("{call Procedureuno(?,?)}");
        CallableStatement cstmt2 = conn.prepareCall("{call Proceduredos(?,?)}");

        try/* (CallableStatement cstmt = conn.prepareCall(*//*"{begin Procedureuno(?,?); Proceduredos(?,?); end;}"*//*"{call Procedureuno(?,?)}");)*/ {
            cstmt.setString(/*"FPE_CAI_IFPE"*/1, request.getLot().getLere());
            cstmt.setString(/*"FPE_MSC_STAT"*/2, request.getLot().getStatusLere());

            for (LotDetail lotDetail : request.getLotDetail()) {
                try /*(CallableStatement cstmt2 = conn.prepareCall("{call Proceduredos(?,?)}"))*/{
                    cstmt2.setString(/*"lere"*/1, lotDetail.getLere());
                    cstmt2.setString(/*"status"*/2, lotDetail.getStatus());
                    cstmt2.executeUpdate();
                }catch (Exception e){

                }
            }
            cstmt.executeUpdate();

            msj.setCode("MSG01");
            msj.setDescription("EXITO");



        } catch (SQLException e) {
            log.error("error1"+e);
           /* e.printStackTrace();*/
           /* log.info("ERROR : problemas al ejecutar procedure");
            throw AtlasException.builder().cause(e).description("ERROR").build();*/
           msj.setCode("MSG02");
           msj.setDescription("ERROR");
        } finally {
            try {
                conn.close();
                cstmt.close();
                cstmt2.close();
            } catch (SQLException e) {
                log.info("error2");
                e.printStackTrace();
            }
        }
        deltResponse.setMesagge(msj);

        return Observable.just(deltResponse);
    }
}
