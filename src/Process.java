import java.lang.Math;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;  // Import the Scanner class

public class Process
{
    Scanner getInput = new Scanner(System.in);

    // Vocabulary of hiragana
    String[] hiragana = {
            // a
            "あ", "い", "う", "え", "お",
            // ka
            "か", "き", "く", "け", "こ",
            // sa
            "さ", "し", "す", "せ", "そ",
            // ta
            "た", "ち", "つ", "て", "と",
            // na
            "な", "に", "ぬ", "ね", "の",
            // ha
            "は", "ひ", "ふ", "へ", "ほ",
            // ma
            "ま", "み", "む", "め", "も",
            // ra
            "ら", "り", "る", "れ", "ろ",
            // ya
            "や", "ゆ", "よ",
            // wa
            "わ", "を",
            // n
            "ん",

            // Voiceless and voiced hiragana
            // ga
            "が", "ぎ", "ぐ", "げ", "ご",
            // za
            "ざ", "じ", "ず", "ぜ", "ぞ",
            // da
            "だ", "ぢ", "づ", "で", "ど",
            // ba
            "ば", "び", "ぶ", "べ", "ぼ",
            // pa
            "ぱ", "ぴ", "ぷ", "ぺ", "ぽ"
            // Voiceless and voiced hiragana END
    };

    // Respective pronunciation for hiragana above, same for katakana
    String[] kanaAnswer = {
            // a
            "a", "i", "u", "e", "o",
            // ka
            "ka", "ki", "ku", "ke", "ko",
            // sa
            "sa", "shi", "su", "se", "so",
            // ta
            "ta", "chi", "tsu", "te", "to",
            // na
            "na", "ni", "nu", "ne", "no",
            // ha
            "ha", "hi", "fu", "he", "ho",
            // ma
            "ma", "mi", "mu", "me", "mo",
            // ra
            "ra", "ri", "ru", "re", "ro",
            // ya
            "ya", "yu", "yo",
            // wa
            "wa", "wo",
            // n
            "n",

            // Voiceless and voiced hiragana
            // ga
            "ga", "gi", "gu", "ge", "go",
            // za
            "za", "ji", "zu", "ze", "zo",
            // da
            "da", "di", "du", "de", "do",
            // ba
            "ba", "bi", "bu", "be", "bo",
            // pa
            "pa", "pi", "pu", "pe", "po"
            // Voiceless and voiced hiragana END
    };

    // Vocabulary for katakana
    String[] katakana = {
            // a
            "ア", "イ", "ウ", "エ", "オ",
            // ka
            "カ", "キ", "ク", "ケ", "コ",
            // sa
            "サ", "シ", "ス", "セ", "ソ",
            // ta
            "タ", "チ", "ツ", "テ", "ト",
            // na
            "ナ", "ニ", "ヌ", "ネ", "ノ",
            // ha
            "ハ", "ヒ", "フ", "ヘ", "ホ",
            // ma
            "マ", "ミ", "ム", "メ", "モ",
            // ra
            "ラ", "リ", "ル", "レ", "ロ",
            // ya
            "ヤ", "ユ", "ヨ",
            // wa
            "ワ", "ヲ",
            // n
            "ン",

            // Voiceless and voiced katakana
            // ga
            "ガ", "ギ", "グ", "ゲ", "ゴ",
            // za
            "ザ", "ジ", "ズ", "ゼ", "ゾ",
            // da
            "ダ", "ヂ", "ヅ", "デ", "ド",
            // ba
            "バ", "ビ", "ブ", "ベ", "ボ",
            // pa
            "パ", "ピ", "プ", "ペ", "ポ"
            // Voiceless and voiced katakana END
    };

    // Save kana user answered wrongly
    String[] wrongKana = new String[71];
    String[] wrongPronunciation = new String[71];

    // Initialization
    String input = "test";
    short wrongNum;
    boolean cont = true;

    // Check if one kana had been added to array before
    private boolean checkArr(String input)
    {
        return (Arrays.asList(wrongPronunciation).contains(input));
    }

    // Generate a random number
    private short getNum(short largest) { return ((short)(Math.random() * largest)); }

    // Check whether the pronunciation is correct
    private boolean checkKana(char type, short num)
    {
        // For hiragana
        if (type == 'h')
        {
            // Question
            System.out.println("How to pronounce " + hiragana[num] + "?");

            // Get user input
            input = getInput.nextLine();

            // Check if user wants to end the program
            if (!Objects.equals(input, "stop")) {

                // Check if user input is correct
                if (Objects.equals(input, kanaAnswer[num])) System.out.print("Correct!\n" +
                        "- Press ENTER to continue -\n");

                    // If user input is incorrect
                else {
                    if (!checkArr(kanaAnswer[num])) // If the hiragana does not exist in the array
                    {
                        wrongKana[wrongNum] = hiragana[num];
                        wrongPronunciation[wrongNum++] = kanaAnswer[num];
                    } else System.out.println("You have answered the hiragana wrong before.");

                    // Show the hiragana and its correct pronunciation
                    System.out.print("The correct pronunciation for " +
                            hiragana[num] + " is " + kanaAnswer[num] + ".\n" +
                            "- Press ENTER to continue -\n");

                }
            }
            // End the program
            else return false;

            // Ask for input
            input = getInput.nextLine();

            // Check if user wants to end the program
            if (Objects.equals(input, "stop")) return false;
            else return true;
        }

        // For katakana
        else if (type == 'k')
        {
            // Question
            System.out.println("How to pronounce " + katakana[num] + "?");

            // Get user input
            input = getInput.nextLine();

            // Check if user wants to end the program
            if (!Objects.equals(input, "stop"))
            {
                // Check if user input is correct
                if (Objects.equals(input, kanaAnswer[num])) System.out.print("Correct!\n");

                // If user input is incorrect
                else
                {
                    if (!checkArr(kanaAnswer[num])) // If the katakana does not exist in the array
                    {
                        wrongKana[wrongNum] = katakana[num];
                        wrongPronunciation[wrongNum++] = kanaAnswer[num];
                    }

                    else System.out.println("You have answered the katakana wrong before.");

                    // Show the katakana and its correct pronunciation
                    System.out.print("The correct pronunciation for " +
                            katakana[num] + " is " + kanaAnswer[num] + ".\n" +
                            "- Press ENTER to continue -\n");

                    input = getInput.nextLine();

                    // Continue
                    return true;

                }

            }

            // End the practice
            else return false;

            // Ask for input
            input = getInput.nextLine();

            // Check if user wants to end the program
            if (Objects.equals(input, "stop")) return false;
            else return true;
        }

        // Error
        return false;
    }

    // Process
    protected void process(int mode)
    {
        // Initialization
        String input = "test";
        short num = -1;

        // Process
        switch (mode)
        {
            // Mode 1 - All hiragana
            case 1:
                while (cont)
                {
                    num = getNum((short)71); // From 0-70, (max 70 - min 0 + 1) + min 0 = 71
                    cont = checkKana('h', num);
                }
                break;

            // Mode 2 - Hiragana without voiced and voiceless sound
            case 2:
                while (cont)
                {
                    num = getNum((short)46); // From 0-70, (max 70 - min 0 + 1) + min 0 = 71
                    cont = checkKana('h', num);
                }
                break;

            // Mode 3 - All katakana
            case 3:
                while (cont)
                {
                    num = getNum((short)(71)); // From 0-70, (max 70 - min 0 + 1) + min 0 = 71
                    cont = checkKana('k', num);
                }
                break;

            // Mode 4 - Katakana without voiced and voiceless sound
            case 4:
                while (cont)
                {
                    num = getNum((short)(46)); // From 0-70, (max 70 - min 0 + 1) + min 0 = 71
                    cont = checkKana('k', num);
                }
                break;

            // Other situations
            default:
                System.out.println("Sorry, there is something wrong with the program. Please contact us.\n");
                break;
        }

        // Summary

        // Display kana wrongly answered before
        if (wrongNum > 0)
        {
            System.out.println("Thank you!\n" +
                    "Here are the kana you answered wrongly.");

            for (int i = 0; i < wrongNum; i++)
            {
                System.out.println(wrongKana[i] + " (" + wrongPronunciation[i] + ")");
            }
        }

        // If user did not make any mistake
        else System.out.println("Wow! You answered all kana correctly!\n" +
                "Thank you for using!");

    }
}

