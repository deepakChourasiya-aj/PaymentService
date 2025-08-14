package sw.paymentservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sw.paymentservice.dtos.InitiatePaymentRequestDto;
import sw.paymentservice.services.PaymentService;

@RequestMapping("/payment")
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto initiatePaymentRequestDto){
        return paymentService.initiatePayment(initiatePaymentRequestDto.getAmount(),initiatePaymentRequestDto.getOrderId(),initiatePaymentRequestDto.getPhoneNumber(),initiatePaymentRequestDto.getName(),initiatePaymentRequestDto.getEmail());
    }
}
