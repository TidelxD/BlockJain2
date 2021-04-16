package com.company;

import java.util.ArrayList;
import java.util.List;

public class Transactions {
    private List<Transaction> transactions = new ArrayList<>();

    public void add_transaction(Transaction transaction){
        transactions.add(transaction);
    }

    public int size(){
        return transactions.size();
    }

    @Override
    public String toString() {
        String toReturn ="\n";
        for (int i = 0; i < transactions.size(); i++) {
            toReturn = toReturn.concat(transactions.get(i).toString()).concat("\n");
        }
        return String.format("{\n\t\ttransactions:\nsize:%d\n\t\t%s}", size(), toReturn );
    }
}
