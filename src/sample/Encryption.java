package sample;

public class Encryption {
    private class MonoEncryption implements IEncryptable {
        private int[] getCounts(String cipher) {
            // returns a int[26] array of counts a letter appears in cipher

            char[] cipherChars = cipher.toCharArray();
            int[] countLetters = new int[26];

            for (int i = 0; i < cipher.length(); i++) {
                int index = cipherChars[i] - (int) 'A';
                countLetters[index]++;
            }

            return countLetters;
        }

        private int[] makeCipher(String cipher) {
            // returns a int[26] array representing the cipher pad map
            // over the standard English alphabet
            // всеки елемент има стойност равна на позицията на буква
            // от азбуката, която съответства на неговия индекс в cipher pad
            // позицията на letter е отместването й спрямо ‘A’ т.е.
            // letterChar – ‘A’
            // calls getCounts() to build the first part of the cipher pad

            int[] padMap = new int[26];
            int[] counts = getCounts(cipher);
            char[] cipherChars = cipher.toCharArray();
            char[] alphabetReverse = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N', 'M',
                    'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};

            char[] padMapChar = new char[26];
            int k = 0;

            //fill unique chars from cipher in the beginning of padMapChar
            for (int i = 0; i < cipher.length(); i++) {
                char c = cipherChars[i];

                if (counts[c - (int) 'A'] == 1) {
                    padMapChar[k++] = c;
                    counts[c - (int) 'A'] = -1;
                }
                if (counts[c - (int) 'A'] > 1) {
                    padMapChar[k++] = c;
                    counts[c - (int) 'A'] = -1;
                }
            }

            //System.out.println(padMapChar);

            //fill the remaining letters from the alphabet
            for (int i = 0; i < 26; i++) {
                char c = alphabetReverse[i];

                for (int j = 0; j < 26; j++) {
                    if (counts[c - (int) 'A'] == 0) {
                        padMapChar[k++] = c;
                        //System.out.println(padMapChar);
                        break;
                    }
                }
            }

            for (int i = 0; i < 26; i++) {
                padMap[i] = padMapChar[i] - (int) 'A';
            }

            return padMap;
        }


        @Override
        public String encrypt(String plainText, String cipher) {
            int[] padMap = makeCipher(cipher);
            char[] plainCharArray = plainText.toCharArray();

            char[] resultArray = new char[plainText.length()];

            for (int i = 0; i < plainText.length(); i++) {
                int index = plainCharArray[i] - (int) 'A';
                resultArray[i] = (char) (padMap[index] + 'A');
            }

            return new String(resultArray);
        }

        @Override
        public String decrypt(String cipherText, String cipher) {
            int[] padMap = makeCipher(cipher);
            char[] cipherCharArray = cipherText.toCharArray();
            char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H','I', 'J', 'K', 'L',
                    'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

            char[] resultArray = new char[cipherText.length()];

            for (int i = 0; i < cipherText.length(); i++) {
                //index of letter in cipherText - index represents position in padMap
                int index=-1;
                for(int j=0;j<26;j++){
                    if(cipherCharArray[i]==padMap[j]+'A') {
                        index = j;
                        break;
                    }
                }
                //System.out.println(index);
                resultArray[i]=alphabet[index];
            }

            return new String(resultArray);
        }
    }

    public IEncryptable getMonoCipherMethod() {
        return new MonoEncryption();
    }
}
