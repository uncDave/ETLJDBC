package com.BI.ETLDataMigration.Listener;


import com.BI.ETLDataMigration.models.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.item.Chunk;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TransactionItemWriteListener implements ItemWriteListener<Transaction> {
    @Override
    public void beforeWrite(Chunk<? extends Transaction> items) {
        log.info("Writing started transaction list : " + items);
    }

    @Override
    public void afterWrite(Chunk<? extends Transaction> items) {
        log.info("Writing completed transaction list : " + items);
    }

    @Override
    public void onWriteError(Exception e, Chunk<? extends Transaction> items) {
        log.error("Error in reading the transaction records " + items);
        log.error("Error in reading the transaction records " + e);
    }
}
