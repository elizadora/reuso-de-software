package Payments;

public class PaymentFactory {

    public static Payment createPayment(String type){
        switch (type){
            case "googlepay":
                return new GooglePayPayment();
            case "paypal":
                return new PayPalPayment();
            case "banktransfer":
                return new BankTransferPayment();
            default:
                throw new IllegalArgumentException("Forma de pagamento invalida!");
        }
    }
}
