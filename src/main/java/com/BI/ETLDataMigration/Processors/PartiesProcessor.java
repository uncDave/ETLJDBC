package com.BI.ETLDataMigration.Processors;


import com.BI.ETLDataMigration.models.Parties;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PartiesProcessor implements ItemProcessor<Parties,Parties> {


    @Override
    public Parties process(Parties item) throws Exception {
        return item;
    }
}
