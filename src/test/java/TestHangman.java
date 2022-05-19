import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHangman {
    @Test
    void test_alphabetCountInAWord() {
        String word = "pizza";
        char alphabet = 'a';

        Hangman hangman = new Hangman();

        int count = hangman.countAlphabet(word, alphabet);

        assertEquals(1, count);
    }

    @Test
    void test_lengthOfFetchWord(){
        Hangman hangman = new Hangman();
        String word = hangman.fetchWord();

        assertTrue(word.length() == 5);
    }

    @Test
    void test_lengthOfFetchedWordRandom(){
        Random random = new Random();
        int requestedLength = random.nextInt(6) + 5;
        Hangman hangman = new Hangman();
        String word = hangman.fetchWord(requestedLength);

        assertTrue(requestedLength == word.length());
    }

    @Test
    void test_uniquenessOfFetchedWord(){
        //  randomizer to get a random number
        Random random = new Random();
        //  will store random number
        int requestedLength = 0;
        //  Set to store used words since testing uniqueness w/i 100 rds
        Set<String> usedWordsSet = new HashSet<>();
        //  int variable accounting for the number of rounds
        int round = 0;
        //  String variable to store word
        String word = null;
        //  Instantiate an instance of Hangman()
        Hangman hangman = new Hangman();

        //  while loop to go through rounds
        while(round < 100){
            //  get a random number 5-10
            requestedLength = random.nextInt(6)+5;
            //  set word variable to fetchWord of requestedLength
            word = hangman.fetchWord(requestedLength);
            //  increment round number
            round++;
            //  assertTrue that word is added to usedWordsSet
            //  if returns True that means word is not in set
            //
            assertTrue(usedWordsSet.add(word));
        }
    }
}
