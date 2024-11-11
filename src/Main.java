public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome Banking System Simulation");

        BankAccount sharedAccount = new BankAccount(10);
        Client client1 = new Client("Client 1", sharedAccount);
        Client client2 = new Client("Client 2", sharedAccount);
        Client client3 = new Client("Client 3", sharedAccount);

        client1.start();
        client2.start();
        client3.start();

        try{
            client1.join();
            client2.join();
            client3.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Final balance is: $" + sharedAccount.getBalance());
    }
}