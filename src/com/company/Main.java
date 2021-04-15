package com.company;

public class Main {

    public static void main(String[] args) {
        Block block = new Block();
        block.setBlock_number(0);
        block.setTarget("0000ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
        block.setData("yonues");
        block.setPrev_hash("00000000");
        block.setTimestamp("6161616161616");

        Miner.mine(block);
    }

}
