package com.BI.ETLDataMigration.Processors;


import com.BI.ETLDataMigration.models.Transaction;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionProcessor implements ItemProcessor<Transaction,Transaction> {
    @Override
    public Transaction process(Transaction item) throws Exception {
        System.out.println("This is the item" + item);
        return item;
    }
}
