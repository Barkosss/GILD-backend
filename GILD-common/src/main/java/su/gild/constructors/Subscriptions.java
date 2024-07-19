package su.gild.constructors;

public class Subscriptions {

    public long authorProfileId;
    public int counterMonth;
    public long startSubscriptionsTimestamp;
    public long endSubscriptionTimestamp;
    public long amountPrice;
    public String numBankCard;


    // Create Subscriptions Object
    public Subscriptions(long authorProfileId, int counterMonth, long startSubscriptionsTimestamp, long endSubscriptionTimestamp, long amountPrice, String numBankCard) {
        this.authorProfileId = authorProfileId;
        this.counterMonth = counterMonth;
        this.startSubscriptionsTimestamp = startSubscriptionsTimestamp;
        this.endSubscriptionTimestamp = endSubscriptionTimestamp;
        this.amountPrice = amountPrice;
        this.numBankCard = numBankCard;
    }


    // Set the Author's profile id
    public void setAuthorProfileId(long authorProfileId) {
        this.authorProfileId = authorProfileId;
    }

    // Get the Author's profile id
    public long getAuthorProfileId() {
        return authorProfileId;
    }

    // Set the Counter Month
    public void setCounterMonth(int counterMonth) {
        this.counterMonth = counterMonth;
    }

    // Get the Counter Month
    public int getCounterMonth() {
        return counterMonth;
    }

    // Set the Start Subscriptions Timestamp
    public void setStartSubscriptionsTimestamp(long startSubscriptionsTimestamp) {
        this.startSubscriptionsTimestamp = startSubscriptionsTimestamp;
    }

    // Get the Start Subscriptions Timestamp
    public long getStartSubscriptionsTimestamp() {
        return startSubscriptionsTimestamp;
    }

    // Set the End Subscriptions Timestamp
    public void setEndSubscriptionTimestamp(long endSubscriptionTimestamp) {
        this.endSubscriptionTimestamp = endSubscriptionTimestamp;
    }

    // Get the End Subscriptions Timestamp
    public long getEndSubscriptionTimestamp() {
        return endSubscriptionTimestamp;
    }

    // Set the Amount Price
    public void setAmountPrice(long amountPrice) {
        this.amountPrice = amountPrice;
    }

    // Get the Amount Price
    public long getAmountPrice() {
        return amountPrice;
    }

    // Set Number Bank Card
    public void setNumBankCard(String numBankCard) {
        this.numBankCard = numBankCard;
    }

    // Get Number Bank Card
    public String getNumBankCard() {
        return numBankCard;
    }
}
