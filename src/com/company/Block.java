package com.company;

import java.sql.Timestamp;
import java.util.List;

public class Block {
    int block_number;
    int Nonce;
    String target;
    String timestamp;
    Transactions data;
    String prev_hash;
    String hash;

    public Block(String target, Transactions data, String prev_hash) {
        this.target = target;
        Timestamp timeS = new Timestamp(System.currentTimeMillis()); // since 1970 with millis
        this.timestamp = String.valueOf(timeS.getTime());
        this.data = data;
        this.prev_hash = prev_hash;
    }
    public Block(){
        Timestamp timeS = new Timestamp(System.currentTimeMillis());
        this.timestamp = String.valueOf(timeS.getTime());
    }

    public int getBlock_number() {
        return block_number;
    }

    public void setBlock_number(int block_number) {
        this.block_number = block_number;
    }

    public int getNonce() {
        return Nonce;
    }

    public void setNonce(int nonce) {
        Nonce = nonce;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Transactions getData() {
        return data;
    }

    public void setData(Transactions data) {
        //TODO verify every transaction
        this.data = data;
    }

    public String getPrev_hash() {
        return prev_hash;
    }

    public void setPrev_hash(String prev_hash) {
        this.prev_hash = prev_hash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "\nBlock{" +
                "\n\t block_number=" + block_number +
                "\n\t Nonce=" + Nonce +
                "\n\t target=" + target +
                "\n\t timestamp=" + timestamp +
                "\n\t data=" + data +
                "\n\t prev_hash=" + prev_hash +
                "\n\t hash=" + hash +
                "}\n";
    }
    public String toBigString(){
        return target+timestamp+data+prev_hash+Nonce;
    }
    public String toSmallString(){
        return target+timestamp+data+prev_hash ;
    }
}
