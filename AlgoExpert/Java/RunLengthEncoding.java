/*

Write a function that takes in a non-empty string and returns its run-length
encoding.

From Wikipedia, "run-length encoding is a form of lossless data compression in
which runs of data are stored as a single data value and count, rather than as
the original run." For this problem, a run of data is any sequence of
consecutive, identical characters. So the run AAA would be
run-length-encoded as 3A.

To make things more complicated, however, the input string can contain all
sorts of special characters, including numbers. And since encoded data must be
decodable, this means that we can't naively run-length-encode long runs. For
example, the run AAAAAAAAAAAA  (12 As), can't
naively be encoded as 12A, since this string can be decoded as
either AAAAAAAAAAAA or 1AA. Thus, long runs (runs
of 10 or more characters) should be encoded in a split fashion; the
aforementioned run should be encoded as 9A3A.
Sample Input:
string  = "AAAAAAAAAAAAABBCCCCDD"
Sample Output:
9A4A2B4C2D
*/

class RunLengthEncoding{
    public static void main(String args[]){
        String s = "AAAAAAAAAAAAABBCCCCDD";
        String runLengthString = runLengthEncoding(s);
        System.out.println(runLengthString);
    }
    public static String runLengthEncoding(String s){
        StringBuffer res = new StringBuffer();
        if(s.length() == 0)
            return "";
        int count = 1;
        char prevChar = s.charAt(0);
        for(int i=1;i<s.length();i++){
            char currentChar = s.charAt(i);
            if(count < 9 && prevChar == currentChar)
                count++;
            else{
                res.append((char)(count+48));
                res.append(prevChar);
                prevChar = currentChar;
                count = 1;
            }
        }
        res.append((char)(count+48));
        res.append(prevChar);
        return res.toString();
    }
}
