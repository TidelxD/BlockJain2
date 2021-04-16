package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Blockchain blockchain = new Blockchain();

        for (int i = 0; i < 50; i++) {
            Transactions transactions = new Transactions();
            Transaction transaction = new Transaction(String.valueOf(new Random().nextBoolean()),String.valueOf(new Random().nextBoolean()),new Random().nextFloat());
            Transaction transaction2 = new Transaction(String.valueOf(new Random().nextBoolean()),String.valueOf(new Random().nextBoolean()),new Random().nextFloat());
            transactions.add_transaction(transaction);transactions.add_transaction(transaction2);
            Block block = new Block();
            block.setTarget(blockchain.target);
            block.setData(transactions);
            block.setPrev_hash(blockchain.get_last_block().hash);
            Miner.mine(block);
            blockchain.add_Block(block);
        }
        Transactions transactions1 = new Transactions();
        Transaction transaction3 = new Transaction("Fahed","Hadj",500,10);
        transactions1.add_transaction(transaction3);
        blockchain.get_Block(10).setData(transactions1);

        blockchain.validate_blockchain();

        System.out.println(blockchain);




    }

}
