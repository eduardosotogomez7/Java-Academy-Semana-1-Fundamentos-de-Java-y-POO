package com.academia.batch.processor;

import com.academia.batch.model.Instrumento;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class InstrumentoProcessor implements ItemProcessor<Instrumento, Instrumento> {

    private static final Logger log = LoggerFactory.getLogger(InstrumentoProcessor.class);

    @Override
    public Instrumento process(Instrumento instrumento) {
        // Regla de negocio: nombre en mayusculas y bono del 10%
        instrumento.setNombre(instrumento.getNombre().toUpperCase());
        instrumento.setDescuento(instrumento.getPrecio() * 0.10);

        log.info("Procesando: {}", instrumento);
        return instrumento;
    }
}