package learn.note.algorithm.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 *
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 105
 * s[i] 为 'A'、'C'、'G' 或 'T'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author WangWenLei
 * @DATE: 2021/10/8
 **/
public class FindRepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        int l = 10;
        int len = s.length();
        for(int i = 0 ; i <= len - l ; i++){
            String sub = s.substring(i, i + l);
            if(map.getOrDefault(sub, 0) == 0){
                map.put(sub,1);
            }else if(map.getOrDefault(sub, 0) == 1){
                res.add(sub);
            }
        }
        return res;
    }
}