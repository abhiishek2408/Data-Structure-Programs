package String;

class Check_If_Word_Equals_summation_of_Two_Words {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return wordToNumber(firstWord) + wordToNumber(secondWord) == wordToNumber(targetWord);
    }

    private int wordToNumber(String word) {
        int num = 0;
        for (char c : word.toCharArray()) {
            num = num * 10 + (c - 'a');
        }
        return num;
    }
}

