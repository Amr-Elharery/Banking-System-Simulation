import java.util.Random;

public class Client extends Thread{
    private String name;
    private BankAccount account;
    private Random random = new Random();

    public Client(String name, BankAccount account){
        super(name);
        this.account = account;
    }

    @Override
    public void run(){
        for (int i = 0; i < 5; i++){
            double amount = 10 + random.nextInt(91);
            boolean isDeposit = random.nextBoolean();

            if(isDeposit)
                this.account.deposit(amount);
            else
                this.account.withdrew(amount);

            try{
                Thread.sleep(1500);
            }catch (InterruptedException e){
                System.out.println("Interrupted..!");
            }
        }
    }


}
