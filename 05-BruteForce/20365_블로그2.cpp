//#define _CRT_SECURE_NO_WARNINGS
//
//#include <iostream>
//#include <algorithm>
//#include <vector>
//using namespace std;
//
//vector<char> RedOrBlue ;
//int N;
//int main() {
//
//	char x;
//	int B=0,R=0; //B와 R의 연속된 개수
//	int result = 0,Bcheck=0, Rcheck=0;
//	cin >> N;
//	
//	for (int i = 0; i < N; i++) {
//		cin >> x;
//		RedOrBlue.push_back(x);
//
//		if (RedOrBlue[i] == 'B' && Bcheck == 0)
//		{
//			B++;
//			Bcheck = 1;
//		}
//		else if (RedOrBlue[i] == 'R') {
//			Bcheck = 0;
//		}
//
//		if (RedOrBlue[i] == 'R' && Rcheck == 0)
//		{
//			R++;
//			Rcheck = 1;
//		}
//		else if (RedOrBlue[i] == 'B') {
//			Rcheck = 0;
//		}
//
//
//
//	}
//
//	//R 연속이 더 많거나 같을 때
//	if (R>B) {
//		result=	B+ 1;
//
//	}
//
//	else {
//		result = R+ 1;
//	}
//
//	cout << result;
//
//
//	return 0;
//}