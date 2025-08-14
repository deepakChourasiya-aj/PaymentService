package sw.paymentservice.dtos;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class InitiatePaymentRequestDto {
    Long amount;
    String orderId;
    String phoneNumber;
    String name;
    String email;
}
