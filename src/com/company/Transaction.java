package com.company;

public class Transaction {
    String sender;
    String receiver;
    double amount;
    double fees;
    String hash;

    public Transaction(String sender, String receiver, double amount, double fees) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.fees = fees;
        this.hash = Miner.sha256(sender+receiver+amount+fees);
    }

    public Transaction(String sender, String receiver, double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.fees = 0;
        this.hash = Miner.sha256(sender+receiver+amount+fees);
    }

    @Override
    public String toString(){
        return String.format("\t\t{sender: %s \n\t\treceiver: %s \n\t\tamount: %f\n\t\tfees: %f\n\t\thash: %s}", sender,receiver,amount,fees,hash);
    }
}
