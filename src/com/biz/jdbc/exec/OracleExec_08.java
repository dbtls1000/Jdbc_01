package com.biz.jdbc.exec;

import java.util.Scanner;

import com.biz.jdbc.model.StudentVO;
import com.biz.jdbc.service.StdService;

public class OracleExec_08 {

	public static void main(String[] args) {
		StdService ss = new StdService();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("조회할 학생의 학번을 입력하세요(종료--END)");
			String strNum= scan.nextLine();
			
			if(strNum.equals("--END")) {
				System.out.println("굿바이");
				break;
			}
			StudentVO vo = ss.findByNum(strNum);
			if(vo==null) System.out.println("찾는학생 없음");
			else System.out.println(vo);
		}
		
	}

}
