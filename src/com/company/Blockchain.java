package com.company;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private static final List<Block> blocks = new ArrayList<Block>();
    String target = "00ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff";
    public Blockchain() {
        Block genesisBlock = new Block(
                ""+target,
                "timestamp",
                "data",
                "prev_hash"
        );
        blocks.add(genesisBlock);
    }

}
