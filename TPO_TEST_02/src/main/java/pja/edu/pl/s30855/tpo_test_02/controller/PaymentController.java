package pja.edu.pl.s30855.tpo_test_02.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pja.edu.pl.s30855.tpo_test_02.model.Payment;
import pja.edu.pl.s30855.tpo_test_02.service.PaymentService;

import java.util.List;


@Controller
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service){
        this.service = service;
    }

    @GetMapping("/home")
    public String showHome(Model model){
        List<Payment> payments = service.getAllPayments();
        model.addAttribute("payments", payments);
        return "home";
    }

    @GetMapping("/id/{id}")
    public String showDetailsById(@PathVariable Long id, Model model){
        Payment payment = service.getPaymentById(id).orElse(null);
        if(payment == null){
            return "home";
        }
        model.addAttribute("payment", payment);
        return "details";
    }

    @GetMapping("/order/{orderId}")
    public String showDetailsByOrderId(@PathVariable Long orderId, Model model){
        Payment payment = service.getPaymentByOrderId(orderId).orElse(null);
        if(payment == null){
            return "home";
        }
        model.addAttribute("payment", payment);
        return "details";
    }

    @GetMapping("/create")
    public String showRegisterForm(Model model){
        model.addAttribute("payment", new Payment());
        return "create";
    }

    @PostMapping("/create")
    public String createPayment(@Valid @ModelAttribute("payment") Payment payment, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "create";
        }
        Payment createdPayment = service.addPayment(payment);
        System.out.println("Amount received: " + payment.getAmount());
        model.addAttribute("payment", createdPayment);
        return "result";
    }

    @PutMapping("/update/id/{id}")
    public String updatePayment( @Valid @PathVariable Long id, @RequestBody Payment payment, BindingResult result){

        if(result.hasErrors()){
            return "create";
        }
        service.updatePayment(payment, id);

        return "result";
    }
}
