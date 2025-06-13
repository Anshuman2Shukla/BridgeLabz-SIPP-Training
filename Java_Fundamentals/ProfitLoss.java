
public class ProfitLoss {
    public static void main(String[] args) {
        int costPrice = 129;
        int sellingPrice = 191;
        if (costPrice < sellingPrice) {
            int profit = sellingPrice - costPrice;
            double profitPercentage = ((double) profit / costPrice) * 100;
            System.out.println("The Cost Price is INR " + costPrice + " and the Selling Price is INR " + sellingPrice);
            System.out.println("The Profit is INR " + profit + " and the Profit Percentage is "
                    + String.format("%.3f", profitPercentage) + "%");
        } else {
            int loss = costPrice - sellingPrice;
            double lossPercentage = ((double) loss / costPrice) * 100;
            System.out.println("The Cost Price is INR " + costPrice + " and the Selling Price is INR " + sellingPrice);
            System.out.println("The Loss is INR " + loss + " and the Loss Percentage is "
                    + String.format("%.3f", lossPercentage) + "%");
        }
    }
}
