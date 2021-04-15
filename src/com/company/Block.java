package com.company;

public class Block {
    int block_number;
    int Nonce;
    String target;
    String timestamp;
    String data;
    String prev_hash;
    String hash;

    public Block(String target, String timestamp, String data, String prev_hash) {
        this.target = target;
        this.timestamp = timestamp;
        this.data = data;
        this.prev_hash = prev_hash;
    }
    public Block(){

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
        return "Block{" +
                "block_number=" + block_number +
                ", Nonce=" + Nonce +
                ", target='" + target + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", data='" + data + '\'' +
                ", prev_hash='" + prev_hash + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
    public String toBigString(){
        return block_number+target+timestamp+data+prev_hash+Nonce;
    }
    public String toSmallString(){
        return block_number+target+timestamp+data+prev_hash ;
    }
}
