#define _CRT_SECURE_NO_WARNINGS



#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;
int MeetingNum;

bool compare(pair<int, int>a, pair<int, int>b) {
	if (a.second == b.second) {
		return a.first < b.first;
	}
	return a.second < b.second;
}

vector<pair<int, int >>MeetingTime;

int main() {
	int start, end;

	cin >> MeetingNum;
	int result = 0;
	int num = 0;
	int k = 0;

	for (int i = 0; i < MeetingNum; i++) {
		cin >> start >> end;
		MeetingTime.push_back(pair<int, int>(start, end));
	}

	sort(MeetingTime.begin(), MeetingTime.end(),compare);

	for (int i = 0; i < MeetingNum; i++) {
		cout << MeetingTime[i].first << " " << MeetingTime[i].second;
		cout << "\n";
	}


	int time = MeetingTime[0].second;

	for(int i=1;i<MeetingNum;i++){
	
			if (time <= MeetingTime[i].first)
			{
				num++;
				time = MeetingTime[i].second;
			}
		}
	
		
		cout << ++num;

	}




