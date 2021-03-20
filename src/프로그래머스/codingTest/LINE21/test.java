package 프로그래머스.codingTest.LINE21;

class Solution {

    static int n;
    static int[] enter1;
    static int[] leave2;

    static boolean 일찍퇴근(int 기준, int 그것) {
        for (int j = 0; j < n; j++) {
            if (leave2[j] == enter1[기준]) {
                break;
            }
            if (leave2[j] == enter1[그것]) {
                return true;
            }
        }
        return false;
    }

    static boolean 늦게퇴근(int 기준, int 그것) {
        for (int j = 0; j < n; j++) {
            if (leave2[j] == enter1[기준]) {
                for (int i = j + 1; i < n; i++) {
                    if (leave2[i] == enter1[그것]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean 늦게출근이면서기준보다일찍퇴근(int 기준, int 그것) {
        for (int j = 0; j < n; j++) {
            if (enter1[j] == enter1[그것]) {
                for (int i = 0; i < n; i++) {
                    if (enter1[i] == leave2[기준]) {
                        for (int k = j + 1; k < n; k++) {
                            for (int p = 0; p < i; p++) {
                                if (enter1[k] == leave2[p]) {
                                    return true;
                                }
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
        return false;
    }

    public int[] solution(int[] enter, int[] leave) {

        enter1 = enter;
        leave2 = leave;
        n = enter1.length;

        int[] score = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (일찍퇴근(i, j)) {
                    score[enter[i] - 1]++;
                    score[enter[j] - 1]++;
                }

                if (늦게퇴근(i, j)) {
                    if (늦게출근이면서기준보다일찍퇴근(i, j)) {
                        score[enter[i] - 1]++;
                        score[enter[j] - 1]++;
                    }
                }
            }
        }

        return score;
    }
}

