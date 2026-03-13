package com.academia.ejerciciossemana5.service;

import com.academia.ejerciciossemana5.entity.Order;
import com.academia.ejerciciossemana5.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Bug 1: Can you spot the problem?
    /* Aquí el problema es que se está utilizando un tipo de dato double, esto nos provoca problemas de precisión
    Y al estar trabajando con dinero esto es un problema, lo ideal sería utilizar BigDecimal para evitar estos problemas de precisión.
     */
    //codigo corregido
    public Order createOrder(Order order) {

        BigDecimal total = order.getItems().stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        order.setTotal(total);

        return orderRepository.save(order);
    }

    // Bug 2: What happens with null?
    /*
    Aqui tenemos el probelma de que el metodo findById devuelve un Optional,
    y si el id no existe, el Optional estará vacío, lo que provocará una excepción al intentar llamar a get() en un Optional vacío.
    Para corregir esto, deberíamos manejar el caso en el que el Optional esté vacío, por ejemplo, lanzando una excepción personalizada
     o devolviendo null.
     */
    //Codigo corregido
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }


    // Bug 3: Security issue
    /*
    Aquí el problema es que se está construyendo una consulta SQL concatenando directamente el nombre del cliente, lo que puede llevar a una vulnerabilidad de inyección SQL.
    Para corregir esto, deberíamos utilizar consultas parametrizadas o métodos proporcionados por el repositorio que eviten este tipo de vulnerabilidades.
     */
    //Codigo corregido
    public List<Order> findOrdersByCustomer(String customerName) {
        return orderRepository.findByCustomer(customerName);
    }

    // Bug 4: Performance issue
    /*
    Aqui el problema es que estamos obteniendo todas las órdenes de la base de datos y luego sumando los totales en memoria, lo que puede ser muy ineficiente si hay muchas órdenes.
    Para corregir esto, deberíamos utilizar una consulta que calcule la suma directamente en la base de datos, con un metodo llamado getTotalRevenue() que se define en el repositorio.
     */
    //Codigo corregido
    public Double getTotalRevenue() {
        return orderRepository.getTotalRevenue();
    }

    // Bug 5: Architecture issue
    /*
    Aqui el problema es que el metodo intenta eliminar una orden sin verificar si existe, lo que puede provocar una excepción si se intenta eliminar una orden que no existe.
    Para corregir esto, deberíamos verificar si la orden existe antes de intentar eliminarla, y manejar el caso en el que la orden no exista, por ejemplo, lanzando una excepción personalizada
     */
    //Codigo corregido
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found with id " + id);
        }
        orderRepository.deleteById(id);
    }
}
