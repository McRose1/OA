package BlackRock;

/*  Benchmark Matching
    We say a portfolio matches the benchmark when the number of shares of each asset in the portfolio matches the number of shares of each asset in the benchmark.
    Your question is to write a program that determines the transactions necessary to make a portfolio match a benchmark.

    A portfolio is a collection of assets such as stocks and bonds.
    A portfolio could have 10 shares of Vodafone stock, 15 shares of Google stock and 15 shares of Microsoft bonds.
    A benchmark is also just a collection of assets.
    A benchmark could have 15 shares of Vodafone stock, 10 shares of Google stock and 15 shares of Microsoft bonds.

    A transaction is when you "buy" or "sell" a particular asset of certain asset type ("stock" or "bond").
    For instance, you can decide to buy 5 shares of Vodafone stock which, given the portfolio described above, would result in you having 15 shares of Vodafone stock.
    Correspondingly, you decide to sell 5 shares of Microsoft bonds, which would result in 10 shares of Microsoft bonds in the above portfolio.

    Assumptions:
        o Shares are positive decimals
        o There will always be at least 1 asset present in the Portfolio and Benchmark
        o A particular asset can be bond, stock or both. For example, 5 shares of Microsoft bonds and 10 shares
          of Microsoft stock can both be present in the portfolio/benchmark.
        o The trades should be sorted in alphabetical order based on the names of the assets;
          if both bonds and stock are present for an asset, list bonds first.

    Input:
        o The first part of the input is the Portfolio holdings (in the format Name,AssetType,Shares where
          each asset is separated by '|' symbol)
        o The second part of the input is the Benchmark holdings (in the format Name,AssetType,Shares where
          each asset is separated by '|' symbol)

    Example input:
    Vodafone,STOCK,10|Google,STOCK,15|Microsoft,BOND,15:Vodafone,STOCK,15|Google,STOCK,10|Microsoft,BOND,15

    Note that the two parts are separated by ':' symbol.

    Output:
    The output is a list of transactions (separated by new line) in the format TransactionType,AssetType,Shares.
    Note that the TransactionType should only be BUY and SELL.

    Example output: SELL,Google,STOCK,5 BUY,Vodafone,STOCK,5

    Test 1:
    Test Input:
    Vodafone,STOCK,10|Google,STOCK,15:Vodafone,STOCK,15|Vodafone,BOND,10|Google,STOCK,10

    Expected Output:
    SELL,Google,STOCK,5
    BUY,Vodafone,BOND,10
    BUY,Vodafone,STOCK,5

    Test 2:
    Test Input:
    Vodafone,STOCK,10|Google,STOCK,15|Microsoft,BOND,15:Vodafone,STOCK,15|Google,STOCK,10|Microsoft,BOND,15

    Expected Output:
    SELL,Google,STOCK,5
    BUY,Vodafone,STOCK,5
 */

import java.util.*;

public class BenchmarkMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().split(":");

        String portfolio = parts[0];
        TreeMap<Asset, Double> portMap = parse(portfolio);

        String benchmark = parts[1];
        TreeMap<Asset, Double> benchMap = parse(benchmark);

        TreeSet<Asset> tset = new TreeSet<>();
        tset.addAll(portMap.keySet());
        tset.addAll(benchMap.keySet());
        int size = tset.size();
        for (Asset a : tset) {
            size--;
            Double port = portMap.getOrDefault(a, 0.0);
            Double bench = benchMap.getOrDefault(a, 0.0);
            double diff = bench - port;
            if (diff == 0) continue;

            String transactionType = diff > 0 ? "BUY" : "SELL";
            String assetType = a.assetType == Type.BOND ? "BOND" : "STOCK";
            if (size == 0) {
                System.out.print(transactionType + "," + a.name + "," + assetType + "," + Math.abs((int) Math.round(diff)));
            } else {
                System.out.println(transactionType + "," + a.name + "," + assetType + "," + Math.abs((int) Math.round(diff)));
            }
        }
    }

    private static TreeMap<Asset, Double> parse(String s) {
        String[] companies = s.split("\\|");
        TreeMap<Asset, Double> tmap = new TreeMap<>();
        for (String ss : companies) {
            String[] temp = ss.split(",");
            Asset cur = new Asset();
            cur.name = temp[0];
            cur.assetType = temp[1].equals("BOND") ? Type.BOND : Type.STOCK;
            Double share = Double.parseDouble(temp[2]);
            tmap.put(cur, tmap.getOrDefault(cur, 0.0) + share);
        }
        return tmap;
    }

    enum Type {
        BOND, STOCK;
    }

    private static class Asset implements Comparable<Asset> {
        String name;
        Type assetType;

        @Override
        public int compareTo(Asset o) {
            if (!name.equals(o.name)) {
                return name.compareTo(o.name);
            }
            return assetType.compareTo(o.assetType);
        }
    }
}
