package programers;

public class Pararell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//평행 여부 01 23 // 02 13 // 03 12 // 
		
		int[][] dot = {{1,4},{9, 2}, {3, 8}, {11, 6} };
		int answer = 0;
		int line1Row, line2Row, line1Col, line2Col;
		//01-32// 02-31 12-03 
		for (int i=0; i<2;i++) {
			for (int j =i+1; j<3;j++) {
			if(i == 1 && j ==2) {
				line1Row = Math.abs(dot[1][0] - dot[2][0]);
				line1Col = Math.abs(dot[1][1] - dot[2][1]);
				line2Row = Math.abs(dot[0][0] - dot[3][0]);
				line2Col = Math.abs(dot[0][1] - dot[3][1]);
			} else {
				line1Row = Math.abs(dot[i][0] - dot[j][0]);
				line1Col = Math.abs(dot[i][1] - dot[j][1]);
				line2Row = Math.abs(dot[dot.length -1- i][0] -dot[dot.length -1- j][0]);
				line2Col = Math.abs(dot[dot.length -1- i][1] - dot[dot.length-1-j][1]);
			}
				
				if(line1Col % line2Col == 0 && line1Row % line2Row == 0) answer++;
			}
		}
		System.out.println(answer);
	}

}
