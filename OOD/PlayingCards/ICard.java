public interface ICard extends Comparable{
    public static final int SPADES = 0;
    public static final int HEARTS = 1;
    public static final int DIAMONDS = 2;
    public static final int CLUBS = 3;

    public int getSuit();   //returns a value like ICard.HEARTS
    public int getRank();   //returns a value in the range of 1(ace) to 13(king)
}

public abstract class Card{
    private boolean available = true;

    protected int faceValue;
    protected Suit suit;

    public Card(int c, Suit s){
        faceValue = c;
        suit = s;
    }

    public abstract int value();
    public Suit suit(){return suit;}

    public boolean isAvailable(){return available;}
    public void markUnavailable(){available = false;}
    public void markAvailable(){available = true;}
}

public class Deck <T extends Card>{
    private ArrayList<T> cards; //all cards, dealt or not
    private int dealtIndex = 0; //marks first undealt card

    public void setDeckOfCards(ArrayList<T> deskOfCards){...}
    public void shuffle(){...}
    public int remainingCards(){
        return cards.size() - dealtIndex;
    }

    public T[] dealHand(int number){...}
    public T dealCard(){...}
}

public class Hand <T extends Card>{
    protected ArrayList<T> cards = new ArrayList<T>();

    public int score(){
        int score = 0;
        for(T card : cards){
            score += card.value();
        }
        return score;
    }

    public void addCard(T card){
        cards.add(card);
    }
}

/*
There are multiple scores for a blackjackhand, as ace has multiple value;
Return highest value under 21, or lowest value over 21.
*/
public class BlackJackHand extends Hand<BlackJackCard>{
    public int score(){
        ArrayList<Integer> scores = possibleScores();

        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;

        for(int score : scores){
            if(scores > 21 && score < minOver){
                minOver = score;
            }else if(score <= 21 && score > maxUnder){
                maxUnder = score;
            }
        }
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }
}

public class BlackJackHand extends Card{
    public BlackJackHand(int c, Suit s){super(c, s);}
    public int value(){
        if(isAce()) return 1;
        else if(faceValue >= 11 && faceValue <= 13) return 10;
        else return faceValue;
    }

    public int minValue(){
        if(isAce) return 1;
        else return value();
    }

    public int maxValue(){
        if(isAce) return 11;
        else return value();
    }

    public boolean isAce(){
        return faceValue == 1;
    }

    public boolean isFaceCard(){
        return faceValue >= 11 && faceValue <= 13;
    }
}