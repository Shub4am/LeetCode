class Encrypter {
    
    Map<Character, String> enc;
    Map<String, Integer> count;
    
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        enc = new HashMap<>();
        for (int i = 0; i < keys.length; ++i)
            enc.put(keys[i], values[i]);
        
        count = new HashMap<>();
        for (String w : dictionary) {
            String e = encrypt(w);
            count.put(e, count.getOrDefault(e, 0) + 1);
        }
    }
    
    public String encrypt(String word1) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < word1.length(); ++i)
            res.append(enc.getOrDefault(word1.charAt(i), "#"));
        return res.toString();
    }
    
    public int decrypt(String word2) {
        return count.getOrDefault(word2, 0);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */