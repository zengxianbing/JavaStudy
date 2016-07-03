package leetcode;

public class Valid_Sudoku {

	public boolean isValidSudoku(char[][] board) {
		return isValidRow(board) && isValidColumn(board) && isValidBox(board);
    }
	
	// 检查所有的行
	public boolean isValidRow(char[][] board){
		for(int i=0; i<9; i++){
			boolean[] flag = new boolean[10];
			for(int j=0; j<9; j++){
				if(!markFlag(flag, board[i][j])){
					return false;
				}
			}
		}
		return true;
	}
	
	// 检查所有的列
	public boolean isValidColumn(char[][] board){
		for(int i=0; i<9; i++){
			boolean[] flag = new boolean[10];
			for(int j=0; j<9; j++){
				if(!markFlag(flag, board[j][i])){
					return false;
				}
			}
		}
		return true;
	}
	
	// 检查所有的9宫格
	public boolean isValidBox(char[][] board){
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				boolean[] flag = new boolean[10];
				for(int m=0; m<3; m++){
					for(int n=0; n<3; n++){
						if(!markFlag(flag, board[i*3+m][j*3+n])){
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	public boolean markFlag(boolean[] flag, char c){
		if(c == '.'){
			return true;
		}
		int index = c - '0';
		if(flag[index]){		// 之前已经出现过
			return false;
		}else{					// 第一次出现
			flag[index] = true;
			return true;
		}
	}
	
}

