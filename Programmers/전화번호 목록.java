import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length - 1; i++) {

            if((phone_book[i + 1].startsWith(phone_book[i]))) {
                return false;
            }
        }


        return answer;
    }
}

/* 시간초과 났던 풀이
        public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<Integer, String> numbers = new HashMap<>();

        for(int i = 0; i < phone_book.length; i++) {
            numbers.put(i, phone_book[i]);
        }


        for(int i = 0; i < phone_book.length; i++) {
            String first = numbers.get(i);

            for(int j = 0; j < phone_book.length; j++) {

                if(i != j) {
                    String second = numbers.get(j);

                    if(first.length() <= second.length()) {

                        String value = second.substring(0, first.length());

                        if(first.equals(value)) {
                            return false;
                        }
                    }
                }

            }
        }
        return answer;
    }
*/