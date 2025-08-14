package sw.paymentservice.paymentgateways;

public interface IPaymentGateway {
    String generatePaymentLink(Long amount,String orderId,String phoneNumber,String name,String email);
}
