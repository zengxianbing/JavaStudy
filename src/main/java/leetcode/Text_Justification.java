package leetcode;

import java.util.ArrayList;

public class Text_Justification {
	public static ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> ret = new ArrayList<String>();
		int wordsLen = words.length;	// 单词数组的长度
		int curWordIdx = 0;		// 处理第i个单词
		while(curWordIdx < wordsLen){		// 处理完所有单词后退出
			int charLen = 0;  // 当前行累积的字符数量
			int probeWordIdx = curWordIdx;
			while(probeWordIdx<wordsLen && charLen+words[probeWordIdx].length()<=L){	// 贪婪加入尽可能多的单词
				charLen += ((words[probeWordIdx++]).length()+1);		// 累积单词长度和至少要有一个空格
			}
			if(probeWordIdx-curWordIdx == 1){		// tmpWordIdx-curWordIdx: 该行放入单词的数目，如果只有一个单词要特殊处理
				String tmp = words[curWordIdx];	// 唯一的那个单词
				tmp = addSpace(tmp, L-words[curWordIdx].length());	// 那个单词后面都接上空格
				ret.add(tmp);
				curWordIdx = probeWordIdx;		// 更新curWordIdx，因为已经处理好当前行了
				continue;
			}
			
			// tmpWordIdx-curWordIdx: 该行放入单词的数目，也就是紧接的空格的数量（因为每个单词后接一个空格）
			// wordCharLen：当前行所有由单词组成的字符数量（不包括空格）
			int wordCharLen = charLen - (probeWordIdx-curWordIdx);		
			//meanSpace: 平均每个单词后的空格,tmpWordIdx<wordsLen 表示不是最后一行
			int meanSpace = probeWordIdx<wordsLen ? (L-wordCharLen)/(probeWordIdx-curWordIdx-1) : 1;
			//leftSpace: 多余的空格
			int leftSpace = probeWordIdx<wordsLen ? (L-wordCharLen)%(probeWordIdx-curWordIdx-1) : L-wordCharLen-(probeWordIdx-curWordIdx-1);
			String tmp = new String();
			for(int k=curWordIdx; k<probeWordIdx-1; k++){	// 对当前行最后一个单词特殊处理
				tmp += words[k];
				tmp = addSpace(tmp, meanSpace);
				if(probeWordIdx<wordsLen && leftSpace>0){	// 因为居中对齐
					tmp += " ";
					leftSpace--;
				}
			}
			tmp += words[probeWordIdx-1];		// 处理当前行的最后一个单词
			if(leftSpace > 0){		// 因为左对齐，所以在最后补上剩下的空格
				tmp = addSpace(tmp, leftSpace);
			}
			ret.add(tmp);
			curWordIdx = probeWordIdx;		// 处理下一行的要处理的单词
		}
		return ret;
	}
	
	public static String addSpace(String s, int count){
		for(int i=1; i<=count; i++){
			s += " ";
		}
		return s;
	}
	
	// ============================================
	
	
	// Bad attempt!
//	public static ArrayList<String> fullJustify2(String[] words, int L) {
//		int letterCnt = 0;
//		int wordCnt = 0;
//		for (String s : words) {
//			letterCnt += s.length(); // 计算字符总数
//		}
//
//		ArrayList<String> ret = new ArrayList<String>();
//		// if(L != 1){
//		// cnt = cnt + cnt-1;
//		// }
//		// System.out.println(cnt);
//		// int lines = (int) Math.ceil(1.0*cnt/L);
//		// System.out.println(lines);
//
//		int curWord = 0;
//		int oldWord = 0;
//		int totalWords = words.length;
//		while (true) {
//			letterCnt = 0;
//			wordCnt = 0;
//			curWord = oldWord;
//			while (curWord < words.length) {
//				letterCnt += words[curWord].length() + 1;
//				if (letterCnt > L + 1) { // 超过长度限制
//					break;
//				}
//				wordCnt += words[curWord].length(); // 计算总共单词个数
//				curWord++;
//			}
//			curWord--;
//			String s = "";
//			// System.out.println(wordCnt);
//			int totalSpaces = L - wordCnt; // 空格总数
//			int perSpaces = 0; // 每行的空格数目s
//			// if(j-oldj != 0){
//			perSpaces = (int) Math.ceil(1.0 * (L - wordCnt)
//					/ ((curWord - oldWord + 1) - 1));
//			// }
//
//			if (totalWords <= 0) {
//				break;
//			}
//			// System.out.println("totalSpaces:"+totalSpaces);
//			// System.out.println("perSpaces:"+perSpaces);
//			for (int k = oldWord; k <= curWord; k++) {
//				s += words[k];
//				if (totalWords == L && k == oldWord && totalSpaces != 0) {
//					s += " ";
//					totalSpaces -= 1;
//				} else {
//					if (perSpaces <= totalSpaces) {
//						for (int m = 0; m < perSpaces; m++) {
//							s += " ";
//						}
//						totalSpaces -= perSpaces;
//					} else {
//						for (int m = 0; m < totalSpaces; m++) {
//							s += " ";
//						}
//						totalSpaces -= totalSpaces;
//					}
//				}
//			}
//
//			totalWords -= (curWord - oldWord + 1);
//
//			ret.add(s);
//			oldWord = curWord + 1;
//		}
//		return ret;
//	}

}
