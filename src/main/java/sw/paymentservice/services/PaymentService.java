package sw.paymentservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sw.paymentservice.paymentgateways.IPaymentGateway;
import sw.paymentservice.paymentgateways.PaymentGatewayChooserStrategy;

@Service
public class PaymentService {
    @Autowired
    private PaymentGatewayChooserStrategy paymentGatewayChooserStrategy;

    public String initiatePayment(Long amount,String orderId,String phoneNumber,String name,String email){
        IPaymentGateway paymentGateway = paymentGatewayChooserStrategy.getPaymentGateway();
        return paymentGateway.generatePaymentLink(amount,orderId,phoneNumber,name,email);
    }
}
