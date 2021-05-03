package BabyProductsRental;

import java.util.ArrayList;

public class Chart {

	public static void main(String[] args) {
		// �����ͺ��̽��� ���� ������(����� ������ ��)
				// ArrayList<Integer> arr = new ArrayList<Integer>();
				String[] sArr = { "������ǰ", "�̵���ǰ", "ħ����ǰ", "������ǰ", "�峭��", "���ƽı�", "����ǰ", "�Ƶ���", "���ڱ��" };
				int[] arr = { 70, 30, 25, 105, 92, 12, 34, 79, 60 };
				// ���� ��
				System.out.println("--------���� ��--------");
				System.out.println(print(sArr));
				System.out.println(print(arr));
				System.out.println("--------���� ��--------");

				// �ε��� ���� �� ���ڿ� �������ֱ�... ���ڿ� ���� ���� �ϸ� ���ڿ��� ������ �ʾƿ� ^^...
				sArr = selectSort(arr, sArr);
				arr = selectSort(arr);

				System.out.println(print(sArr));
				System.out.println(print(arr));
				// �ۼ�Ʈ�� ��ȯ
				System.out.println("-------�ۼ�Ʈ ��ȯ------");
				float[] dArr = percentArray(arr);
				System.out.println(print(dArr));
				System.out.println(sum_arr(dArr));

			}

			public static int[] selectSort(int[] arr) {
				// ���� �迭�� ���� �����Ͽ� �������ִ� �Լ�
				for (int i = 0; i < arr.length; i++) {
					int maxIndex = i;
					for (int j = i + 1; j < arr.length; j++) {
						if (arr[maxIndex] < arr[j]) {
							maxIndex = j;
						}
					}
					int temp = arr[maxIndex];
					arr[maxIndex] = arr[i];
					arr[i] = temp;
				}
				return arr;
			}

			public static String[] selectSort(int[] arr, String[] sArr) {
				// �ε��� �迭�� �����ϸ� ���ÿ� ��Ʈ�� Ÿ���� �̸� �迭�� ���� �����Ͽ� �������ִ� �Լ�
				for (int i = 0; i < arr.length; i++) {
					int maxIndex = i;
					for (int j = i + 1; j < arr.length; j++) {
						if (arr[maxIndex] < arr[j]) {
							maxIndex = j;
						}
					}
					int temp = arr[maxIndex];
					arr[maxIndex] = arr[i];
					arr[i] = temp;

					String temp2 = sArr[maxIndex];
					sArr[maxIndex] = sArr[i];
					sArr[i] = temp2;
				}
				return sArr;
			}

			public static String print(int[] arr) {
				// ���� �迭�� ��� ���� �� ���� ���ڿ��� ǥ���ϴ� �Լ�(�����ε�)
				String s = "";
				for (int i : arr) {
					s += i + " " + "";
				}
				return s;
			}

			public static String print(float[] arr) {
				// �Ǽ� �迭�� ��� ���� �� ���� ���ڿ��� ǥ���ϴ� �Լ�
				String s = "";
				for (float i : arr) {
					s += i + " " + "";
				}
				return s;
			}

			public static String print(String[] sArr) {
				// ���ڿ� �迭�� ��� ���� �� ���� ���ڿ��� ǥ���ϴ� �Լ�(�����ε�)
				String s = "";
				for (String i : sArr) {
					s += i + " " + "";
				}
				return s;
			}

			public static int sum_arr(int[] arr) {
				// ���� �迭�� ��� ���� ���Ͽ� ����ϴ� �Լ�
				int sum = 0;
				for (int i : arr) {
					sum += i;
				}
				return sum;
			}

			public static float sum_arr(float[] arr) {
				// ���� �迭�� ��� ���� ���Ͽ� ����ϴ� �Լ�
				float sum = 0;
				for (float i : arr) {
					sum += i;
				}
				return sum;
			}

			public static float avg_arr(int[] arr) {
				// ���� �迭�� ��� ���� ����� ���Ͽ� �Ǽ��� ����ϴ� �Լ�
				float avg = (float) sum_arr(arr) / arr.length;
				return avg;
			}

			public static float[] percentArray(int[] arr) {
				// ���� �迭�� ��� ���� �ۼ�Ʈ�� ��ȯ�Ͽ� �Ǽ� �迭�� ����ϴ� �Լ�
				int sum = sum_arr(arr);
				float[] dArr = new float[arr.length];
				for (int i = 0; i < arr.length; i++) {
					dArr[i] = (float) arr[i] / sum * 100;
				}
				return dArr;

			}

			public static int[] percentIntArray(int[] arr) {
				// ���� �迭�� ��� ���� �ۼ�Ʈ�� ��ȯ�Ͽ� �Ǽ� �迭�� ����ϴ� �Լ�
				int sum = sum_arr(arr);
				int[] iArr = new int[arr.length];
				for (int i = 0; i < arr.length; i++) {
					iArr[i] = (int) (arr[i] / sum * 100);
				}
				return iArr;

			}

			public static int[] floatToIntArry(float[] fArr) {
				int[] arr = new int[fArr.length];
				for (int i = 0; i < fArr.length; i++) {
					arr[i] = (int) Math.round(fArr[i]);
				}
				return arr;
			}

			public static int[] StringToIntArray(String[] sArr) {
				//��Ʈ�� �迭�� int�迭�� ������ִ� �޼ҵ�
				//��Ʈ �迭 = StringToIntArray(��Ʈ�� �ٲ� ��Ʈ�� �迭)
				int[] arr = new int[sArr.length];
				for (int i = 0; i < sArr.length; i++) {
					arr[i] = Integer.parseInt(sArr[i]);
				}
				return arr;
			}
			
			public static String[] IntToStringArray(int[] arr) {
				//int �迭�� String �迭�� �ٲ��ִ� �޼ҵ�
				String[] sArr = new String[arr.length];
				for (int i = 0; i < arr.length; i++) {
					sArr[i] = Integer.toString(arr[i]);
				}
				return sArr;
			}

	}


