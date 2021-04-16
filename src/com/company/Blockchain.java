package com.company;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private static List<Block> blocks = new ArrayList<Block>();
    String target = "00ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff";
    Transactions genesisTransaction = new Transactions();

    public Blockchain() {
        Transaction transaction = new Transaction("Younes","Fahed",50);
        genesisTransaction.add_transaction(transaction);
        Block genesisBlock = new Block(
                ""+target,
                genesisTransaction,
                "0"
        );
        Miner.mine(genesisBlock);
        blocks.add(genesisBlock);
    }

    public void add_Block(Block block){
        //must check the block previous hash and the block hash
        if ((get_last_block().getHash().equals(block.getPrev_hash()))
                && Miner.sha256(block.toBigString()).equals(block.getHash())){
                block.setBlock_number(blocks.size());
                blocks.add(block);
                System.out.println("Block has been added!");
                validate_blockchain();
        }
    }

    public void validate_blockchain() {
        for (int i = 0; i < blocks.size(); i++) {
            if (Miner.sha256(blocks.get(i).toBigString()).equals(blocks.get(i).getHash())) {
                if (i < blocks.size() - 1) {
                    if (!blocks.get(i).getHash().equals(blocks.get(i + 1).getPrev_hash())) {
                        blocks = blocks.subList(0, i);
                        System.out.println("Blockchain was not valid, in order to validate it" +
                                "\nthe Blockchain has removed malicious blocks\nMalicious Block: " + i);
                    }
                }
            } else {
                blocks = blocks.subList(0, i);
                System.out.println("Blockchain was not valid, in order to validate it" +
                        "\nthe Blockchain has removed malicious blocks\nMalicious Block: " + i);
            }
        }
    }
    public Block get_last_block(){
        return blocks.get(blocks.size()-1);
    }
    public Block get_Block(int index){
        return blocks.get(index);
    }

    @Override
    public String toString() {
        String blocks_data = "";
        for (int i = 0; i < blocks.size(); i++) {
            blocks_data = blocks_data.concat(blocks.get(i).toString()) +",";
        }
        return "Blockchain{\n" +
                blocks_data.substring(0,blocks_data.length()-2) +
                "\n}";
    }
}
