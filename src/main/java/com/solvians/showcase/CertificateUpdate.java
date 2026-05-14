package com.solvians.showcase;

public class CertificateUpdate {

    private long timestamp;
    private String isin;
    private double bidPrice;
    private int bidSize;
    private double askPrice;
    private int askSize;

    public CertificateUpdate(long timestamp,
                             String isin,
                             double bidPrice,
                             int bidSize,
                             double askPrice,
                             int askSize)
    {

        this.timestamp = timestamp;
        this.isin = isin;
        this.bidPrice = bidPrice;
        this.bidSize = bidSize;
        this.askPrice = askPrice;
        this.askSize = askSize;
    }

    @Override
    public String toString() {
        return timestamp + "," +
                isin + "," +
                String.format("%.2f", bidPrice) + "," +
                bidSize + "," +
                String.format("%.2f", askPrice) + "," +
                askSize;
    }
}
