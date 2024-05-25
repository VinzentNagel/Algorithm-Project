package Projekt_Implementierung;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Row> rows = new ArrayList<>();
        rows.add(new Row("Bitcoin", "Bitcoin", 900));
        rows.add(new Row("Ethereum", "Ethereum", 0));
        rows.add(new Row("Ethereum", "Binance Coin", 51405));
        rows.add(new Row("Ethereum", "Tether", 36959622));
        rows.add(new Row("Solana", "Solana", 0));
        rows.add(new Row("Solana", "Cardano", 30367648));
        rows.add(new Row("Solana", "XRP", 3988722));
        rows.add(new Row("Solana", "Polkadot", 1864884));
        rows.add(new Row("Solana", "Dogecoin", 1467991));
        rows.add(new Row("Bitcoin", "USD Coin", 25684487));
        rows.add(new Row("Bitcoin", "Bitcoin Cash", 2591711));
        rows.add(new Row("Bitcoin", "Litecoin", 1973698));
        rows.add(new Row("Bitcoin", "Chainlink", 53));
        rows.add(new Row("Bitcoin", "Stellar", 1764217));
        rows.add(new Row("Ethereum", "Ethereum Classic", 1742680));
        rows.add(new Row("ChainX", "VeChain", 1571643));
        rows.add(new Row("ChainX", "Theta Network", 1373272));
        rows.add(new Row("ChainX", "Filecoin", 1166592));
        rows.add(new Row("ChainX", "TRON", 1146574));
        rows.add(new Row("ChainX", "Aave", 1093453));

        Aggregator aggregator = new Aggregator();
        ArrayList<AggregatedRow> aggregatedRows = aggregator.aggregate(rows);

        Sorter.mergeSort(aggregatedRows);

        for (AggregatedRow aggregatedRow : aggregatedRows) {
            System.out.println(aggregatedRow.blockchain + " " + aggregatedRow.cryptocoin + " " + aggregatedRow.mining);
        }
    }
}