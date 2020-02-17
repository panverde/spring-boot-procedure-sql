package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LotDetail {


    private String lere;
    private String status;
/*    private String acceptorAgency;
    private String acceptorCorrelativeNumber;
    private Double invoiceAmount;
    private String expirationDate;
    private String protest;
    private String invoiceNumber;
    private String protestDeadline;
    private String productType;
    private String lereNumber;
    private String documentNumber;
    private String actionType;
    private String acceptorCenter;
    private String directionNumber;
    private String numberBank;
    private String rejection;
    private String latePayment;
    private String rate;
    private String payrollDate;
    private String paymentType;
    private String conciliation;*/

    public LotDetail() {

    }

    /**
     * values LotDetail.
     *
     */

    public LotDetail(String lere, String status/*, String acceptorAgency,
                     String acceptorCorrelativeNumber, Double invoiceAmount, String expirationDate, String protest,
                     String invoiceNumber, String protestDeadline, String productType*/) {
        this.lere = lere;
        this.status = status;
/*        this.acceptorAgency = acceptorAgency;
        this.acceptorCorrelativeNumber = acceptorCorrelativeNumber;
        this.invoiceAmount = invoiceAmount;
        this.expirationDate = expirationDate;
        this.protest = protest;
        this.invoiceNumber = invoiceNumber;
        this.protestDeadline = protestDeadline;
        this.productType = productType;*/
    }


}
