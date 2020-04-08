package PureStorage;

/*  Number Scores
    You have developed a scoring system for positive integers that works as follows:
     o +2 points for every 5 found in the number. For example, 5751 would score 4 points.
     o +4 points for each pair of consecutive 3s. If there are more than two 3s in a row, add +4 for each additional 3,
       since it makes an additional pair (for example, four consecutive 3s gives +12).
     o +N^2 points for a sequence of length N(N >= 1) where each digit is 1 more than the previous digit.
       For example, 9678562 would be (9-678-56-2) 1 + 3^2 + 2^2 + 1 = 15 points.
     o +6 if the entire number is a multiple of 5
     o +1 for each odd number
    Each component of the score is evaluated separately, so a given digit may contribute to more than one component.
    For example, the number 456 would score 9 for the sequence of length 3, for one odd digit(5), and 2 for the 5 digit, for a total 9 + 1 + 2 = 12
    Write a function compute_number_score that computes (and returns) a score for an integer passed to it.
    The number will be in the range of 0 <= number < 1000000000.
 */

public class NumberScores {
}
