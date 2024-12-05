package Payments;

public class BankTransferPayment implements Payment{

    @Override
    public void processingPayment(double value){
        System.out.println("Realizando pagamento no valor de R$" + value + " via Transferencia Bancaria");
    }

}
