class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i=0;
        List<String> res = new ArrayList<>();
        while(i < words.length){
            int wc = words[i].length();
            int j = i + 1;
            int can = 0;
            while(j < words.length && wc + can + words[j].length()+ 1 <= maxWidth){
                can++;
                wc += words[j].length();
                j++;
            }
            int vac = maxWidth - wc;
            int atleast = can == 0 ? 0 : vac / can;
            int extra = can == 0 ? 0 : vac % can;
            if(j == words.length){
                atleast = 1;
                extra = 0;
            }
            StringBuilder sb = new StringBuilder();
            for(int k = i; k < j; k++){
               sb.append(words[k]);
                int t = 0;
                if(k == j - 1)break;
                if(extra > 0){
                    sb.append(" ");
                    extra--;
                }
                while(t < atleast){
                    sb.append(" ");
                    t++;
                }  
            }
            while(sb.length()<maxWidth){
                sb.append(" ");
            }
            res.add(sb.toString());
            i = j;
        }
        return res;
    }
}