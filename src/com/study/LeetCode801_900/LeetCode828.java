package com.study.LeetCode801_900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author jianghui
 * @date 2022/9/5
 */
public class LeetCode828 {
    public int uniqueLetterString(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                ans += countUniqueChars(s.substring(i, j));
            }
        }
        return ans;
    }

    int countUniqueChars(String s) {
        int[] hash = new int[26];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            hash[aChar - 'A']++;
        }
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (hash[i] == 1) {
                cnt++;
            }
        }
        return cnt;
    }


    public int uniqueLetterString2(String s) {
        List[] hash = new List[26];
        for (int i = 0; i < 26; i++) {
            hash[i] = new ArrayList<Integer>();
            //添加开头
            hash[i].add(-1);
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            hash[chars[i] - 'A'].add(i);
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            List<Integer> cur = hash[i];
            cur.add(s.length());
            for (int j = 1; j < cur.size() - 1; j++) {
                ans += (cur.get(j) - cur.get(j - 1)) * (cur.get(j + 1) - cur.get(j));
            }
        }
        return ans;
    }

    public int uniqueLetterString3(String s) {
        //存储字符前一个字符所在位置
        int[] lastIndexMap = new int[26];
        //存储字符当前所处位置
        int[] curIndexMap = new int[26];
        Arrays.fill(lastIndexMap, -1);
        Arrays.fill(curIndexMap, -1);
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'A';
            if (curIndexMap[index] > -1) {
                ans += (i - curIndexMap[index]) * (curIndexMap[index] - lastIndexMap[index]);
            }
            lastIndexMap[index] = curIndexMap[index];
            curIndexMap[index] = i;
        }
        for (int i = 0; i < 26; i++) {
            if (curIndexMap[i] > -1) {
                ans += (curIndexMap[i] - lastIndexMap[i]) * (s.length() - curIndexMap[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new LeetCode828().uniqueLetterString2("MJYMRNGBCJUBGLTXGEJPICIKALQHJYWISCTXWFMAAAWNZIACGDWCXGYFPUZRQTAQOHJDBDMEOYZWRSREFEFHIXQVDRVRYNIFLMGSDDRIHHZLTWWHYYDBHZOBHMWYPGONRMYZVSPMFVMSTKMIZVJYDTDSFGCWEOMAECKRZLLZVCGQZGPJNUWCNQRDEDQCNEMIGRHISNNQOZQDVGEFINCTWIPMZVRPURGIQRUJTEOQDEVAGDIMXZTIXRHLPTGBFWKMGUFWJPEAOSZPIAHPYPQHGHCYVARQLTIQPCPNPOUEFXYXDMQATGCRJTOKADWCWUIGAVNANEBFXQCFTDVDRWZRETCFPMSIYMAPCTUGZNVWULWHREFLMFQZUIXJSXWCTGSOZYOJRBDOLSFEKORWXEFVLPKIKUEBJHUBLPUXCIGLMVSYSIWQCDXVXCLNXLFRVDYCDLTUTSOYXQRUGJNSXJUHPPQTCESCIIJIFSGMXBYWLPTWILLPRBAHIGRTWAFRTUQGPPAWCPTEROBWIQCJPVUAAUVYBVQWJFBVXAHRMFDGIBTWUJBNRGQMTLRLOXUKVRZIPPVXZCBJEKYHKCGGDYMVCZYNZDJVQURXNFAJMCLRRAXBYXFRRPKVCRYITAUMKVAOZULXWPTSFVJSYLLLVOSYLUMFJFPRVMPUDRMCWLIINEQNNJQRFFFOAPGRFUCXUSXHCVBBLANUNVSVMFZHAAXRZTCNUCDPIUHNODOMEEGLTOLYVAOQQPQJHUQLAFSJIGNMRNFFAFVNGWAMFVEUNCFVMVNXXWXDXOSNOHFWYBXDFMWNALQNBXAEVRRMYOAXZRNJHYWYFVSTNDSEWNLLHRTWSVXENKSCBIVIJFQNYSAMCKZOYFNAPUOTMDEXZKKRPMPPTTFICZERDNDSSUVEOMPQKEMTBWBODRHWSFPBMKAFPWYEDPCOWRUNTVYMXTYYEJQTAJKCJAKGHTDWMUYGECJNCXZCXEZGECRXONNSZMQM"));
        System.out.println(System.currentTimeMillis() - start);
//        System.out.println(new LeetCode828().uniqueLetterString2("ABC"));
    }
}
