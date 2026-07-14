package pja.edu.pl.s30855.tpo_test_02.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    @Positive(message = "Amount must be greater than 0")
    private Double amount;

//    @Future(message = "Date must be in the future")
    private LocalDate paymentDate;


    public Payment(){}

    public Payment(Long orderId, Double amount, LocalDate paymentDate){
        this.orderId = orderId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

}
