/*
 	BOJ 2941 크로아티아 알파벳
 		
	문제	
	예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 
	따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
	예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 
	단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.

	dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. 
	lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		// ArrayIndexOutOfBounds 억까 조심하기
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("");
		
		int len = 0;
		
		for (int i = 0; i < s.length; i++) {

			len++;
			
			if(s[i].equals("c")) {
				if(i < s.length - 1) {
					if ((s[i+1].equals("=") || s[i+1].equals("-"))) {
						i++;
					}
				}
			}
			
			else if(s[i].equals("d")) {
				if(i < s.length - 1) {
					if(s[i+1].equals("-")) {
						i++;
					}
					
					else if(s[i+1].equals("z")) {
						if(i < s.length - 2) {
							if ((s[i+2].equals("="))) {
								i+= 2;
							}
						}
					}
				}
			}
			
			else if(s[i].equals("l")) {
				if(i < s.length - 1) {
					if (s[i+1].equals("j")) {
						i++;
					}
				}
			}
			
			else if(s[i].equals("n")) {
				if(i < s.length - 1) {
					if (s[i+1].equals("j")) {
						i++;
					}
				}
			}
			

			else if(s[i].equals("s")) {
				if(i < s.length - 1) {
					if (s[i+1].equals("=")) {
						i++;
					}
				}
			}
			
			else if(s[i].equals("z")) {
				if(i < s.length - 1) {
					if (s[i+1].equals("=")) {
						i++;
					}
				}
			}
		}
		System.out.println(len);
	}
}