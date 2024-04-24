package com.BI.ETLDataMigration.BatchConfig;

import com.BI.ETLDataMigration.Listener.TransactionItemReadListener;
import com.BI.ETLDataMigration.Listener.TransactionItemWriteListener;
import com.BI.ETLDataMigration.Listener.TransactionProcessListener;
import com.BI.ETLDataMigration.Processors.TransactionProcessor;
import com.BI.ETLDataMigration.mappers.TransactionRowMapper;
import com.BI.ETLDataMigration.models.Transaction;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.support.SqlServerPagingQueryProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
//@AllArgsConstructor
@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfig {

    private final PropertiesConfiguration configuration;
    private final PlatformTransactionManager platformTransactionManager;
    private final JobRepository jobRepository;

    @Bean
    public JdbcPagingItemReader<Transaction> transactionJdbcPagingItemReader() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(configuration.getString("datasource_url"));
        dataSource.setUsername(configuration.getString("datasource_username"));
        dataSource.setPassword(configuration.getString("datasource_password"));
        dataSource.setDriverClassName(configuration.getString("datasource_driver"));
        JdbcPagingItemReader<Transaction> transactionJdbcPagingItemReader = new JdbcPagingItemReader<>();
        transactionJdbcPagingItemReader.setDataSource(dataSource);
        transactionJdbcPagingItemReader.setQueryProvider(Objects.requireNonNull(queryProviderFactoryBean()));
        transactionJdbcPagingItemReader.setRowMapper(new TransactionRowMapper());
        return transactionJdbcPagingItemReader;

    }

    @Bean
    public SqlServerPagingQueryProvider queryProviderFactoryBean(){
        Map<String, Order> sort = new HashMap<>();
        sort.put("id",Order.ASCENDING);
        SqlServerPagingQueryProvider provider= new SqlServerPagingQueryProvider();
        provider.setSelectClause("Select *");
        provider.setFromClause("from transactions");
        provider.setSortKeys(sort);
        System.out.println(provider);
        return provider;
    }

    @Bean
    public DataSource postgresdataSource() throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(configuration.getString("postgres.datasource.driver-class-name"));
        dataSource.setUrl(configuration.getString("postgres.datasource.url"));
        dataSource.setUsername(configuration.getString("postgres.datasource.username"));
        dataSource.setPassword(configuration.getString("postgres.datasource.password"));
        return dataSource;
    }

    @Bean
    public JdbcBatchItemWriter<Transaction> writer() throws SQLException {
        return new JdbcBatchItemWriterBuilder<Transaction>()
                .dataSource(postgresdataSource())
                .sql("INSERT INTO transaction (column1,column2) VALUES (?, ?)")
                .itemSqlParameterSourceProvider(item -> new BeanPropertySqlParameterSource(item))
                .build();
    }

    @Bean
    public TaskExecutor taskExecutor(){
        try{
            int No_of_threads  = configuration.getInt("number_of_execution_threads");
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(No_of_threads);
        return asyncTaskExecutor;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Bean
    public Step importStep() throws Exception {
    int No_of_chunks  = configuration.getInt("transaction_chunk_size");

        return new StepBuilder("transactionMigration", jobRepository)
                .<Transaction, Transaction>chunk(No_of_chunks, platformTransactionManager)
                .reader(transactionJdbcPagingItemReader())
                .processor(new TransactionProcessor())
                .writer(writer())
                .faultTolerant()
                .taskExecutor(taskExecutor())
                .listener(new TransactionItemReadListener())
                .listener(new TransactionItemWriteListener())
                .listener(new TransactionProcessListener())
                .build();
    }

    @Bean(name = "MigrationJob")
    public Job runJob() throws Exception {
        return new JobBuilder("importTransaction", jobRepository)
                .start(importStep())
                .build();
    }


}
