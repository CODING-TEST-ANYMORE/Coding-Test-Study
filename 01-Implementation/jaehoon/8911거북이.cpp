#include <cstdio>
#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <bits/stdc++.h>

using namespace std;

int N;
int x = 0, y = 0;
int maxx = 0, minx = 0, maxy = 0, miny = 0;

int direction = 0;
int sum = 0;

int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };

int main() {


	//거북이의 위치 기록 / 거북이가 지나간 가로세로 기록
	cin >> N;
	for (int i = 0; i < N; i++) {
		 x = 0, y = 0;
		 maxx = 0, minx = 0, maxy = 0, miny =0;

		 direction = 0; //0=북쪽, 1= 동쪽, 2= 남쪽, 3=서쪽
		 sum = 0;

		 string str;

		cin >> str;

		for (int j = 0; j < str.size(); j++) {
			if (str[j] == 'L' || str[j] == 'R') {
				if (str[j] == 'L') {
					direction = (direction + 3) % 4;
				}

				else if (str[j] == 'R') {
					direction = (direction + 1) % 4;
				}
				continue;
			}
			else {
			 if (str[j] == 'F') {
			x += dx[direction];
			y += dy[direction];
			}

			else if (str[j] == 'B')
			{
			x -= dx[direction];
			y -= dy[direction];
			}
			maxx = max(maxx, x);
			minx = min(minx, x);
			maxy = max(maxy, y);
			miny = min(miny, y);

			}
		}


		sum = (maxx - minx) * (maxy - miny);
		cout << sum<<"\n";
	}



	return 0;
}



