package com.academia.batch.config;

import com.academia.batch.model.Instrumento;
import com.academia.batch.processor.InstrumentoProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {

    // ==================== READER ====================
    // Lee el archivo CSV linea por linea y convierte cada linea en un objeto Instrumento
    @Bean
    public FlatFileItemReader<Instrumento> leerCsv() {
        return new FlatFileItemReaderBuilder<Instrumento>()
                .name("instrumentoReader")
                .resource(new ClassPathResource("instrumentos.csv"))
                .delimited()
                .names("nombre", "categoria", "precio")
                .targetType(Instrumento.class)
                .linesToSkip(1)
                .build();
    }

    // ==================== PROCESSOR ====================
    // Transforma cada Instrumento: nombre en mayusculas y calcula el descuento
    @Bean
    public InstrumentoProcessor procesarInstrumento() {
        return new InstrumentoProcessor();
    }

    // ==================== WRITER ====================
    // Inserta cada Instrumento procesado en la tabla instrumentos_procesados de MySQL
    @Bean
    public JdbcBatchItemWriter<Instrumento> escribirEnBd(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Instrumento>()
                .sql("INSERT INTO instrumentos_procesados (nombre, categoria, precio, descuento) "
                        + "VALUES (:nombre, :categoria, :precio, :descuento)")
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }

    // ==================== STEP ====================
    // Un Step = Reader + Processor + Writer, procesando en chunks de 3
    @Bean
    public Step paso1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager,
                      FlatFileItemReader<Instrumento> leerCsv,
                      InstrumentoProcessor procesarInstrumento,
                      JdbcBatchItemWriter<Instrumento> escribirEnBd) {

        return new StepBuilder("paso1", jobRepository)
                .<Instrumento, Instrumento>chunk(3, transactionManager)
                .reader(leerCsv)
                .processor(procesarInstrumento)
                .writer(escribirEnBd)
                .build();
    }

    // ==================== JOB ====================
    // El Job completo. En este caso solo tiene un Step.
    @Bean
    public Job procesarInstrumentoJob(JobRepository jobRepository, Step paso1) {
        return new JobBuilder("procesarInstrumentosJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(paso1)
                .build();
    }
}