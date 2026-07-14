package pja.edu.pl.s30855.tpo_test_02.service;

import org.springframework.stereotype.Service;
import pja.edu.pl.s30855.tpo_test_02.model.Payment;
import pja.edu.pl.s30855.tpo_test_02.repository.PaymentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository repository;

    public PaymentService(PaymentRepository repository){
        this.repository = repository;
    }

    public Optional<Payment> getPaymentById(Long id){
        return repository.findById(id);
    }

    public Optional<Payment> getPaymentByOrderId(Long orderId){
        return repository.findByOrderId(orderId);
    }

    public Payment addPayment(Payment payment){
        return repository.save(payment);
    }

    public List<Payment> getAllPayments(){
        List<Payment> payments = repository.findAllByOrderByAmountDesc();
        return payments;
    }

    public Payment updatePayment(Payment payment, Long id){
         Payment foundPayment  = repository.getById(id);

         foundPayment.setOrderId(payment.getOrderId());
         foundPayment.setAmount(payment.getAmount());
         foundPayment.setPaymentDate(payment.getPaymentDate());

         return repository.save(foundPayment);
    }
}
