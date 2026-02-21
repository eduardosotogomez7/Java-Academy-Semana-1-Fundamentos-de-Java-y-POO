package com.eduardo.ejerciciosSemanaDos.Ejercicio4;

import java.util.*;
import java.util.function.*;

class ProductPipeline {
    private Predicate<Product> filter = p -> true;
    private Function<Product, String> transform = Product::toDisplayString;

    public ProductPipeline where(Predicate<Product> predicate) {
        this.filter = this.filter.and(predicate);
        return this;
    }

    public ProductPipeline transform(Function<Product, String> fn) {
        this.transform = fn;
        return this;
    }

    public void forEach(List<Product> products, Consumer<String> action) {
        for (Product p : products) {
            if (filter.test(p)) {
                action.accept(transform.apply(p));
            }
        }
    }

    public long count(List<Product> products) {
        long total = 0;
        for (Product p : products) {
            if (filter.test(p)) total++;
        }
        return total;
    }
}
