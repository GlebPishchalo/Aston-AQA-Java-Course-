package astonaqa.lesson8;

import java.util.HashMap;
import java.util.Map;

 class ArrayOfWords {

        public void processWords(String[] wordsArray) {
            Map<String, Integer> wordCountMap = new HashMap<>();
            for (String word : wordsArray) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }

            System.out.println("Unique words : count");
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

}
