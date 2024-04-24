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
public class Parties {
    private Long id;
    private String code;
    private String name;
    private String bank;
    private Long account;
    private String email;
    private Long isEnabled;
    private Long isMerchant;
    private String url;
    private String profileId;
    private Long feeIncluded;
    private String SecretKey;
    private String IPAddresses;
    private String MerchantId;
    private String MerId;
    private String ProfileName;
    private String TerminalId;
    private Long Discriminator;
    private Long Migrated;
    private Long RetailerId;
    private Long AmexId;
    private String Logo;
    private String Description;
    private String PhoneNo;
    private String Address;
    private String Website;
    private String SupportEmail;
    private String ChargebackEmail;
    private String PartyMode;
    private String StaffStrength;
    private String BVN;
    private String DOBonBVN;
    private String Facebook;
    private String Twitter;
    private String LinkedIn;
    private String Instagram;
    private Long UserID;
    private String PartyCategoryID;
    private String PartyTypeID;
    private String RegistrationTypeID;
    private String RegistrationTypeNumber;
    private Long CurrencyID;
    private String WorkflowActivationID;
    private Date CreatedDate;
    private Date ModifiedDate;
    private String IsApproved;
    private String Youtube;
    private String SecuredSecretKey;
    private String EncryptionIV;
    private Long EncryptionKey;
    private Long IPAddress;
    private Long IsCardEnabled;
    private Long isRecurring;
    private Long PayattitudeFee;
    private Long CardFee;
    private Long MaxFee;
    private Long VAT;
    private Long AddVAT;
    private boolean ReversalEnabled;
    private String EnableCardOnFile;
    private String OrderTimeOut;
    private String DisablePayattitude;
}

