# RandomMonoalphabeticCipher
Application to encrypt text (plainText) with the Random monoalphabetic cipher algorithm. Key text (cipher) is used.

For example let cipher="FEATHER" and plainText="WEATHER".
First we remove duplicate letters from cipher so we get "FEATHR".
Then we add the remaining letters from the English alphabet in reverse order.

F E A T H R Z Y X W V U S Q P O N M L K J I G D C B

Then the letters from plainText are encrypted with the corresponding letters in the new alphabet:

A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

F E A T H R Z Y X W V U S Q P O N M L K J I G D C B

With plainText="WEATHER" and cipher="FEATHER" we get cipherText="GHFKYHM".

The application works both ways for encrypting and decrypting. The application has simple UI made with JavaFX.
