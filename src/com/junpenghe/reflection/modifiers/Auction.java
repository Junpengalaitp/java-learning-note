package com.junpenghe.reflection.modifiers;

import java.util.*;

public class Auction {
    private final List<Bid> bids = new ArrayList<>();
    private transient volatile boolean isAuctionStarted;

    public synchronized void addBid(Bid bid) {
        this.bids.add(bid);
    }

    public synchronized Optional<Bid> getHighestBid() {
        return bids.stream().max(Comparator.comparing(Bid::getPrice));
    }

    public synchronized List<Bid> getAllBids() {
        return Collections.unmodifiableList(bids);
    }

    public void startAuction() {
        this.isAuctionStarted = true;
    }

    public void stopAction() {
        this.isAuctionStarted = false;
    }

    public boolean isAuctionRunning() {
        return isAuctionStarted;
    }

}
