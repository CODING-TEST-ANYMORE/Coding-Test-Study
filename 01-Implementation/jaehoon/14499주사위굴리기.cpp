#include <cstdio>
#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <bits/stdc++.h>

using namespace std;

int N, M,x,y,cx,cy;

int order[1011];
int map1[22][22] = { 0 }; //지도
int dx[5] = { 0,1, -1, 0, 0 }; //1 2 3 4  {동서북남}에대한 x움직임
int dy[5] = { 0,0, 0, 1, -1 };//1 2 3 4 에대한 y움직임
int temp[10] = { 0 }; // 이동전 주사위 기록
int dice[10] = { 0 }; //주사위 기록
int K; // 명령의 개수


int main() {
		
	cin >> N >> M >> y >> x>>K;
	cx = x;
	cy = y;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map1[i][j];
		}
	}

	for (int i = 0; i < K; i++) {
		cin >> order[i];
	}

	for (int i = 0; i < K; i++) {
	
		if (order[i] == 1) { //동
			cx += dx[1];
			if (N - 1 < abs(cy) || cy < 0 || M - 1 < abs(cx) || cx < 0) {
				cx -= dx[1];
				continue;
			}
			dice[5] = temp[1];
			dice[1] = temp[4];
			dice[4] = temp[3];
			dice[3] = temp[5];

			temp[1] = dice[1];
			temp[3] = dice[3];
			temp[4] = dice[4];
			temp[5] = dice[5];

			if (map1[cy][cx] == 0) {
				map1[cy][cx] = dice[3];
			}
			else {
				dice[3] = map1[cy][cx];
				temp[3] = dice[3];
				map1[cy][cx] = 0;
			}
			cout << dice[1] << "\n";
		}
 		else if (order[i] == 2) { //서
			cx += dx[2];
			if (N - 1 < abs(cy) || cy < 0 || M - 1 < abs(cx) || cx < 0) {
				cx -= dx[2];
				continue;
			}
			dice[5] = temp[3];
			dice[1] = temp[5];
			dice[4] = temp[1];
			dice[3] = temp[4];

			temp[1] = dice[1];
			temp[3] = dice[3];
			temp[4] = dice[4];
			temp[5] = dice[5];
			if (map1[cy][cx] == 0) {
				map1[cy][cx] = dice[3];
			}
			else {
				dice[3] = map1[cy][cx];
				temp[3] = dice[3];
				map1[cy][cx] = 0;
			}
			cout << dice[1]<<"\n";

		}
		else if (order[i] == 3) { //북
			cy += dy[4];
			if (N - 1 < abs(cy) || cy < 0 || M - 1 < abs(cx) || cx < 0) {
				cy -= dy[4];
				continue;
		
			}
			dice[0] = temp[1];
			dice[1] = temp[2];
			dice[2] = temp[3];
			dice[3] = temp[0];

			temp[0] = dice[0];
			temp[1] = dice[1];
			temp[2] = dice[2];
			temp[3] = dice[3];

			if (map1[cy][cx] == 0) {
				map1[cy][cx] = dice[3];
			}
			else {
				dice[3] = map1[cy][cx];
				temp[3] = dice[3];
				map1[cy][cx] = 0;
			}
			cout << dice[1] << "\n";
		}
		else if (order[i] == 4) {  //남
		
			cy += dy[3];
			if (N - 1 < abs(cy) || cy < 0 || M - 1 < abs(cx) || cx < 0) {
				cy -= dy[3];
				continue;
			}

			dice[2] = temp[1];
			dice[3] = temp[2];
			dice[0] = temp[3];
			dice[1] = temp[0];

			temp[0] = dice[0];
			temp[1] = dice[1];
			temp[2] = dice[2];
			temp[3] = dice[3];

		

			if (map1[cy][cx] == 0) {
				map1[cy][cx] = dice[3];
			}
			else {
				dice[3] = map1[cy][cx];
				temp[3] = dice[3];
				map1[cy][cx] = 0;
			}
			cout << dice[1]<<"\n";
		}

	}
	return 0;
}



