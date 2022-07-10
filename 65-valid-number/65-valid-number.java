class Solution {
    public boolean isNumber(String s) {
        String decimal1 = "[+-]?\\d*\\.\\d+[Ee][+-]?\\d+|[+-]?\\d+\\.\\d*[Ee][+-]?\\d+";
        String decimal2 = "[+-]?\\d*\\.\\d+|[+-]?\\d+\\.\\d*";
        String integer = "[+-]?\\d+|[+-]?\\d+[Ee][+-]?\\d+";
        return java.util.regex.Pattern.matches(decimal1, s)||java.util.regex.Pattern.matches(decimal2, s)||java.util.regex.Pattern.matches(integer, s);
    }
}