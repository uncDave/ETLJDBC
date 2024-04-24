package com.BI.ETLDataMigration.mappers;

import com.BI.ETLDataMigration.models.Parties;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class PartiesRowmapper implements RowMapper<Parties> {
    @Override
    public Parties mapRow(ResultSet rs, int rowNum) throws SQLException {
        Parties parties = new Parties();

        parties.setId(rs.getLong("id"));
        parties.setCode(rs.getString("code"));
        parties.setName(rs.getString("name"));
        parties.setBank(rs.getString("bank"));
        parties.setAccount(rs.getLong("account"));
        parties.setEmail(rs.getString("email"));
        parties.setIsEnabled(rs.getLong("isEnabled"));
        parties.setIsMerchant(rs.getLong("isMerchant"));
        parties.setUrl(rs.getString("url"));
        parties.setProfileId(rs.getString("profileId"));
        parties.setFeeIncluded(rs.getLong("feeIncluded"));
        parties.setSecretKey(rs.getString("SecretKey"));
        parties.setIPAddresses(rs.getString("IPAddresses"));
        parties.setMerchantId(rs.getString("MerchantId"));
        parties.setMerId(rs.getString("MerId"));
        parties.setProfileName(rs.getString("ProfileName"));
        parties.setTerminalId(rs.getString("TerminalId"));
        parties.setDiscriminator(rs.getLong("Discriminator"));
        parties.setMigrated(rs.getLong("Migrated"));
        parties.setRetailerId(rs.getLong("RetailerId"));
        parties.setAmexId(rs.getLong("AmexId"));
        parties.setLogo(rs.getString("Logo"));
        parties.setDescription(rs.getString("Description"));
        parties.setPhoneNo(rs.getString("PhoneNo"));
        parties.setAddress(rs.getString("Address"));
        parties.setWebsite(rs.getString("Website"));
        parties.setSupportEmail(rs.getString("SupportEmail"));
        parties.setChargebackEmail(rs.getString("ChargebackEmail"));
        parties.setPartyMode(rs.getString("PartyMode"));
        parties.setStaffStrength(rs.getString("StaffStrength"));
        parties.setBVN(rs.getString("BVN"));
        parties.setDOBonBVN(rs.getString("DOBonBVN"));
        parties.setFacebook(rs.getString("Facebook"));
        parties.setTwitter(rs.getString("Twitter"));
        parties.setLinkedIn(rs.getString("LinkedIn"));
        parties.setInstagram(rs.getString("Instagram"));
        parties.setUserID(rs.getLong("UserID"));
        parties.setPartyCategoryID(rs.getString("PartyCategoryID"));
        parties.setPartyTypeID(rs.getString("PartyTypeID"));
        parties.setRegistrationTypeID(rs.getString("RegistrationTypeID"));
        parties.setRegistrationTypeNumber(rs.getString("RegistrationTypeNumber"));
        parties.setCurrencyID(rs.getLong("CurrencyID"));
        parties.setWorkflowActivationID(rs.getString("WorkflowActivationID"));
        parties.setCreatedDate(rs.getDate("CreatedDate"));
        parties.setModifiedDate(rs.getDate("ModifiedDate"));
        parties.setIsApproved(rs.getString("IsApproved"));
        parties.setYoutube(rs.getString("Youtube"));
        parties.setSecuredSecretKey(rs.getString("SecuredSecretKey"));
        parties.setEncryptionIV(rs.getString("EncryptionIV"));
        parties.setEncryptionKey(rs.getLong("EncryptionKey"));
        parties.setIPAddress(rs.getLong("IPAddress"));
        parties.setIsCardEnabled(rs.getLong("IsCardEnabled"));
        parties.setIsRecurring(rs.getLong("isRecurring"));
        parties.setPayattitudeFee(rs.getLong("PayattitudeFee"));
        parties.setCardFee(rs.getLong("CardFee"));
        parties.setMaxFee(rs.getLong("MaxFee"));
        parties.setVAT(rs.getLong("VAT"));
        parties.setAddVAT(rs.getLong("AddVAT"));
        parties.setReversalEnabled(rs.getBoolean("ReversalEnabled"));
        parties.setEnableCardOnFile(rs.getString("EnableCardOnFile"));
        parties.setOrderTimeOut(rs.getString("OrderTimeOut"));
        parties.setDisablePayattitude(rs.getString("DisablePayattitude"));

        return parties;
    }
}
