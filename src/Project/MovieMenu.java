package Project;

import common.Common;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieMenu {

	MovieMenu() {

	}

	void movieMenu() throws IllegalAccessException, InstantiationException {
		Scanner sc = new Scanner(System.in);
		MovieMgr mmr = new MovieMgr();

		do {
			System.out.println("1. 영화 정보 입력");
			System.out.println("2. 영화 정보 전체 검색");
			System.out.println("3. 영화명 검색");
			System.out.println("4. 영화 감독별 검색");
			System.out.println("5. 영화 장르별 검색");
			System.out.println("6. 영화 정보 삭제");
			System.out.println("0. 종료");
			System.out.println("=============================================");
			System.out.println("위의 정수를 입력해주세요");

			String str = sc.next();
			int sel = Integer.parseInt(str.replaceAll("[^0-9]", "0"));
//			System.out.println(sel);
			sc.nextLine();

			if (sel == 1) {
				System.out.println("1. 영화 정보 입력");
				Movie mv = new Movie();
				System.out.print("제목을 입력해주세요 : ");
				mv.setTitle(sc.nextLine());
				System.out.println();
				System.out.print("감독을 입력해주세요 : ");
				mv.setDirector(sc.nextLine());
				System.out.println();
				System.out.print("등급을 입력해주세요 : ");
				mv.setGrade(Integer.parseInt(sc.next().replaceAll("[^0-9]", "0")));
				sc.nextLine();
				System.out.println();
				System.out.print("장르를 입력해주세요 : ");
				mv.setGenre(sc.nextLine());
				System.out.println();
//				System.out.println(mv);
				mmr.add(mv);

				// 테스트용
				List<Object> lo = Common.autoObject(10, mv, 5, 10);
				for (Object k : lo) {
					mmr.add((Movie) k);
				}
				//
			} else if (sel == 2) {
				System.out.println("2. 영화 정보 전체 검색");
				mmr.search();
			} else if (sel == 3) {
				System.out.println("3. 영화명 검색");
				mmr.search(sc.next());
			} else if (sel == 4) {
				System.out.println("4. 영화 감독별 검색");
				mmr.searchDirector(sc.next());
			} else if (sel == 5) {
				System.out.println("5. 영화 장르별 검색");
				List<Movie> li = new ArrayList<>();
				String ge = sc.next();
				li = mmr.searchGenre(ge);

				if (li.size() > 0) {
					int idx = 1;
					System.out.printf("%10s %10s %8s %10s\n", "제목", "감독", "등급", "장르");
					System.out.println("======================================================");
					for (Movie k : li) {
						if (k.getGenre().equals(ge) || k.getGenre().contains(ge)) {
							System.out.printf("%2d. %10s %10s %8d %10s\n", idx++, k.getTitle(), k.getDirector(), k.getGrade(), k.getGenre());
						}
					}
					if (idx == 1) {
						System.out.println("등록된 영화정보가 없습니다.");
					}
					System.out.println();
				} else {
					System.out.println("등록된 영화정보가 없습니다.");
				}

			} else if (sel == 6) {
				System.out.println("6. 영화 정보 삭제");
				mmr.delete(sc.nextLine());
			} else if (sel == 0) {
				System.out.println("0. 종료");
				break;
			}


		} while (true);

		sc.close();

	}
}
