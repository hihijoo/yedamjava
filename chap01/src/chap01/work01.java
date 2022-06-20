package chap01;

public class work01 {

	public static void main(String[] args) {
		char grade = '상';
		String shoolName = "예담";
		int score = 85;
		float average = 4.235f;
		int flag = 0b10000000;
		char firstChar = '\uAC00';
		int secondChar = 0xAC01;
		int salary = 1000000;
	    boolean useYn = true;
	    
	    System.out.println();
	    System.out.println("grade=" + grade + "\t\t," + " schoolName=" + shoolName + "\t," + " score=" + score);
	    System.out.print("average=" + "\t" + average + "\n");
	    System.out.println("flag=" + "\t\t" + flag);
	    System.out.println("firstChar=" + "\t" + firstChar);
	    System.out.println("secondChar=" + "\t" + (char)secondChar);
	    System.out.println("salary=" + "\t\t" + salary);
	    System.out.println("useYn=" + "\t\t" + useYn);
	}

}
