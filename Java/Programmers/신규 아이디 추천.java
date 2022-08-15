class Solution {
    public String solution(String new_id) {

        StringBuilder answer = new StringBuilder(new_id.toLowerCase());

        answer = new StringBuilder(answer.toString().replaceAll("[^-_.a-z0-9]", ""));
        answer = new StringBuilder(answer.toString().replaceAll("[.]{2,}", "."));
        answer = new StringBuilder(answer.toString().replaceAll("^[.]|[.]$", ""));
        if (answer.toString().equals("")) {
            answer.append("a");
        }
        if (answer.length() >= 16) {
            answer = new StringBuilder(answer.substring(0, 15));
            answer = new StringBuilder(answer.toString().replaceAll("[.]$", ""));
        }
        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer.append(answer.charAt(answer.length() - 1));
            }
        }

        return answer.toString();
    }
}