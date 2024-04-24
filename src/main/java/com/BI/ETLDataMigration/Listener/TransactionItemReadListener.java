package com.BI.ETLDataMigration.Listener;


import com.BI.ETLDataMigration.models.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TransactionItemReadListener implements ItemReadListener<Transaction> {

    @Override
    public void beforeRead() {
        log.info("Reading a new transaction Record");
    }

    @Override
    public void afterRead(Transaction input) {
        log.info("New transaction record read : " + input);
    }

    @Override
    public void onReadError(Exception e) {
        log.error("Error in reading the transaction record : " + e);
    }


}
