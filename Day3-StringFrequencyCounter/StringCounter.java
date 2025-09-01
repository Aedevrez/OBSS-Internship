public class StringCounter {
    public static int countOccurences(String a, String compared) {
        if (a.isEmpty() || compared.isEmpty() || a.length() > compared.length()) {
            return 0;
        }
        String caseInsensitiveA = a.toLowerCase();
        String caseInsensitiveCompared = compared.toLowerCase();

        int count = 0;

        for (int i = 0; i <= caseInsensitiveCompared.length() - caseInsensitiveA.length(); i++) {
            if (caseInsensitiveCompared.substring(i, i + caseInsensitiveA.length()).equals(caseInsensitiveA)) {
                count++;
                i += caseInsensitiveA.length() - 1;
            }
        }

        return count;
    }

    public static boolean checkFrequencies(String compared, String a, String b) {
        return countOccurences(a, compared) == countOccurences(b, compared);
    }
}
