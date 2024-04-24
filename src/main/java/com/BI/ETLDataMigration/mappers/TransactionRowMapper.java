package com.BI.ETLDataMigration.mappers;


import com.BI.ETLDataMigration.models.Transaction;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class TransactionRowMapper implements RowMapper<Transaction> {
    @Override
    public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        Transaction transaction = new Transaction();
        // Extract values from rs and set them to transaction object fields
        transaction.setId(rs.getLong("id"));
        transaction.setMerchantId(rs.getLong("merchant_Id"));
        System.out.println("Merchant Id data " + rs.getLong("merchant_Id"));
        transaction.setDescription(rs.getString("description"));
        transaction.setAmount(rs.getLong("amount"));
        transaction.setFee(rs.getLong("fee"));
        transaction.setFeeInclusive(rs.getLong("fee_inclusive"));
        transaction.setCurrency(rs.getLong("currency"));
        transaction.setInitiated(rs.getDate("initiated"));
        transaction.setStatus(rs.getString("status"));
        transaction.setProcessorRef(rs.getString("processor_ref"));
        transaction.setCompleted(rs.getString("completed"));
        transaction.setReturnUrl(rs.getString("return_url"));
        transaction.setPan(rs.getString("pan"));
        transaction.setCardHolder(rs.getString("card_holder"));
        transaction.setRouteId(rs.getString("route_id"));
        transaction.setApprovalCode(rs.getString("approval_code"));
        transaction.setTripleDesIV(rs.getString("triple_desiv"));
        transaction.setParameter(rs.getString("parameter"));
        transaction.setOrderType(rs.getString("order_type"));
        transaction.setTerminalId(rs.getString("terminal_id"));
        transaction.setRetailerId(rs.getString("retailer_id"));
        transaction.setScheme(rs.getString("scheme"));
        transaction.setRespCode(rs.getString("resp_code"));
        transaction.setSwitchId(rs.getString("switch_id"));
        transaction.setVendorId(rs.getString("vendor_id"));
        transaction.setCustomerEmail(rs.getString("customer_email"));
        transaction.setCustomerName(rs.getString("customer_name"));
        transaction.setClientIP(rs.getString("clientiP"));
        transaction.setReferenceID(rs.getString("referenceID"));
        transaction.setMpiStatus(rs.getString("mpi_status"));
        transaction.setOrderExpirationPeriod(rs.getString("order_expiration_period"));
        transaction.setFrequency(rs.getString("frequency"));
        transaction.setEndRecur(rs.getString("end_recur"));
        transaction.setIsRecurr(rs.getString("is_recurr"));
        transaction.setAdditionalFee(rs.getString("additional_fee"));
        transaction.setSessionId(rs.getString("session_id"));
        transaction.setSubMerchantId(rs.getString("sub_merchant_id"));
        transaction.setSubMerchantName(rs.getString("sub_merchant_name"));
        transaction.setSubMerchantCity(rs.getString("sub_merchant_city"));
        transaction.setSubMerchantCountryCode(rs.getString("sub_merchant_country_code"));
        transaction.setSubMerchantPostalCode(rs.getString("sub_merchant_postal_code"));
        transaction.setSubMerchantStreetAddress(rs.getString("sub_merchant_street_address"));
        transaction.setRefundRef(rs.getString("refund_ref"));
        transaction.setAmountRefunded(rs.getString("amount_refunded")); // Might need to be converted to Long depending on storage format
        transaction.setRefundDate(rs.getDate("refund_date"));
        transaction.setPayattitudeOnFileRef(rs.getString("payattitude_on_file_ref"));
        transaction.setCardOnFileRef(rs.getString("card_on_file_ref"));
        transaction.setCardOnFileId(rs.getString("card_on_file_id"));
        transaction.setCardId(rs.getString("card_id"));
        transaction.setStatusDescription(rs.getString("status_description"));
        transaction.setMerchantRefData(rs.getString("merchant_ref_data"));

        return transaction;
    }
}
