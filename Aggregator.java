import java.util.ArrayList;

public class Aggregator {


    public ArrayList<AggregatedRow> aggregate (ArrayList<Row> rows){

        ArrayList<AggregatedRow> aggregatedRows = new ArrayList<>();

        for (String blockchain : getBlockchains(rows)) {
            aggregatedRows.add(new AggregatedRow(blockchain, null, 0));
        }
        
        for(int i = 0; i < aggregatedRows.size(); i++){
            for (Row row : rows) {
                if (aggregatedRows.get(i).blockchain == row.blockchain) {
                    if(aggregatedRows.get(i).mining < row.mining){
                        aggregatedRows.get(i).cryptocoin = row.cryptocoin;
                        aggregatedRows.get(i).mining = row.mining;
                    }                                      
                }
            }
        }
        return aggregatedRows;
    }

    private ArrayList<String> getBlockchains(ArrayList<Row> rows){
        ArrayList<String> blockchains = new ArrayList<>();
         for (Row row : rows) {
            if(blockchains.contains(row.blockchain) == false){
                blockchains.add(row.blockchain);
            } 
        }
        return blockchains;
    }
}