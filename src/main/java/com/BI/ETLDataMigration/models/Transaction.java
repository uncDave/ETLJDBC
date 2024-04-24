package com.BI.ETLDataMigration.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public class Transaction {

        private Long id;
        private Long merchantId;
        private String description;
        private Long amount;
        private Long fee;
        private Long feeInclusive;
        private Long currency;
        private Date initiated;
        private String status;
        private String processorRef;
        private String completed;
        private String returnUrl;
        private String pan;
        private String cardHolder;
        private String routeId;
        private String approvalCode;
        private String tripleDesIV;
        private String parameter;
        private String orderType;
        private String terminalId;
        private String retailerId;
        private String scheme;
        private String respCode;
        private String switchId;
        private String vendorId;
        private String customerEmail;
        private String customerName;
        private String clientIP;
        private String referenceID;
        private String mpiStatus;
        private String orderExpirationPeriod;
        private String frequency;
        private String endRecur;
        private String isRecurr;
        private String additionalFee;
        private String sessionId;
        private String subMerchantId;
        private String subMerchantName;
        private String subMerchantCity;
        private String subMerchantCountryCode;
        private String subMerchantPostalCode;
        private String subMerchantStreetAddress;
        private String refundRef;
        private String amountRefunded;
        private Date refundDate;
        private String payattitudeOnFileRef;
        private String cardOnFileRef;
        private String cardOnFileId;
        private String cardId;
        private String statusDescription;
        private String merchantRefData;
    }
