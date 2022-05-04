class Solution {
    public String removeDigit(String number, char digit) {
        List<String> nums = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) 
                nums.add(number.substring(0, i) + number.substring(i + 1));
        }
        return nums.stream().sorted().collect(Collectors.toList()).get(nums.size() - 1);
    }
}