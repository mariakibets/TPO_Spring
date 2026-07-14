package pja.edu.pl.s30855.tpo_test_02.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import pja.edu.pl.s30855.tpo_test_02.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

    Optional<Payment> findById(Long id);
    Optional<Payment> findByOrderId(Long orderId);

    List<Payment> findAllByOrderByAmountDesc();

    Payment getById(Long id);
}
