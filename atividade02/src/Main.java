import Payments.Payment;
import Payments.PaymentFactory;

public class Main {
    public static void main(String[] args) {
        // um tipo de forma de pagamento
         Payment pGP = PaymentFactory.createPayment("googlepay");
         pGP.processingPayment(200.0);

         // outro tipo de forma de pagamento
        Payment pPP = PaymentFactory.createPayment("paypal");
        pPP.processingPayment(50);
    }
}