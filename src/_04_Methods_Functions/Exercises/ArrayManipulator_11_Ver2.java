package _04_Methods_Functions.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator_11_Ver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            String[] cmdArgs = command.split(" ");

            if (cmdArgs[0].equals("exchange")) {
                int index = Integer.parseInt(cmdArgs[1]);
                if (index >= 0 && index < numbers.length) {
                    exchange(numbers, index);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (cmdArgs[0].equals("max")) {
                if (cmdArgs[1].equals("even")) {
                    int index = findMaxEvenIndex(numbers);
                    if (index != -1) {
                        System.out.println(index);
                    } else {
                        System.out.println("No matches");
                    }
                } else {
                    int index = findMaxOddIndex(numbers);
                    if (index != -1) {
                        System.out.println(index);
                    } else {
                        System.out.println("No matches");
                    }
                }
            } else if (cmdArgs[0].equals("min")) {
                if (cmdArgs[1].equals("even")) {
                    int index = findMinEvenIndex(numbers);
                    if (index != -1) {
                        System.out.println(index);
                    } else {
                        System.out.println("No matches");
                    }
                } else {
                    int index = findMinOddIndex(numbers);
                    if (index != -1) {
                        System.out.println(index);
                    } else {
                        System.out.println("No matches");
                    }
                }
            } else if (cmdArgs[0].equals("first")) {
                int count = Integer.parseInt(cmdArgs[1]);
                if (cmdArgs[2].equals("even")) {
                    if (count <= numbers.length) {
                        printFirstEven(numbers, count);
                    } else {
                        System.out.println("Invalid count");
                    }
                }else{
                    int oddCount = Integer.parseInt(cmdArgs[1]);
                    if (oddCount <= numbers.length) {
                        printFirstOdd(numbers, oddCount);
                    } else {
                        System.out.println("Invalid count");
                    }
                }
            } else if (cmdArgs[0].equals("last")) {
                int count = Integer.parseInt(cmdArgs[1]);
                if (cmdArgs[2].equals("even")) {
                    if (count <= numbers.length) {
                        printLastEven(numbers, count);
                    } else {
                        System.out.println("Invalid count");
                    }
                }else{
                    int oddCount = Integer.parseInt(cmdArgs[1]);
                    if (oddCount <= numbers.length) {
                        printLastOdd(numbers, oddCount);
                    } else {
                        System.out.println("Invalid count");
                    }
                }
            }

            command = scanner.nextLine();
        }

        printArray(numbers);
    }

    private static void printLastOdd(int[] numbers, int count) {
        int[] arr = new int[numbers.length];

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] % 2 != 0 && count > 0) {
                count--;
                arr[i] = numbers[i];
            } else {
                arr[i] = -1;
            }
        }

        printArray(arr);
    }

    private static void printLastEven(int[] numbers, int count) {
        int[] arr = new int[numbers.length];

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] % 2 == 0 && count > 0) {
                count--;
                arr[i] = numbers[i];
            } else {
                arr[i] = -1;
            }
        }

        printArray(arr);
    }

    private static void printFirstOdd(int[] numbers, int count) {
        int[] arr = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0 && count > 0) {
                count--;
                arr[i] = numbers[i];
            } else {
                arr[i] = -1;
            }
        }

        printArray(arr);
    }

    private static void printFirstEven(int[] numbers, int count) {
        int[] arr = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0 && count > 0) {
                count--;
                arr[i] = numbers[i];
            } else {
                arr[i] = -1;
            }
        }

        printArray(arr);
    }

    private static int findMinOddIndex(int[] numbers) {
        int index = -1;

        int maxNum = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (maxNum >= numbers[i] && numbers[i] % 2 != 0) {
                maxNum = numbers[i];
                index = i;
            }
        }
        return index;
    }

    private static int findMinEvenIndex(int[] numbers) {
        int index = -1;

        int maxNum = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (maxNum >= numbers[i] && numbers[i] % 2 == 0) {
                maxNum = numbers[i];
                index = i;
            }
        }
        return index;
    }

    private static int findMaxOddIndex(int[] numbers) {
        int index = -1;

        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (maxNum <= numbers[i] && numbers[i] % 2 != 0) {
                maxNum = numbers[i];
                index = i;
            }
        }
        return index;
    }

    private static int findMaxEvenIndex(int[] numbers) {
        int index = -1;
        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (maxNum <= numbers[i] && numbers[i] % 2 == 0) {
                maxNum = numbers[i];
                index = i;
            }
        }
        return index;
    }

    private static void printArray(int[] numbers) {
        System.out.print("[");
        boolean printsFirst = true;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != -1) {
                if (printsFirst) {
                    System.out.print(numbers[i]);
                    printsFirst = false;
                } else {
                    System.out.print(", " + numbers[i]);
                }
            }
        }
        System.out.println("]");

    }

    private static void exchange(int[] numbers, int index) {
        int[] first = new int[index + 1];
        int[] second = new int[numbers.length - (index + 1)];

        for (int i = 0; i <= index; i++) {
            first[i] = numbers[i];
        }
        for (int i = index + 1; i < numbers.length; i++) {
            second[i - (index + 1)] = numbers[i];
        }

        for (int i = 0; i < second.length; i++) {
            numbers[i] = second[i];
        }

        for (int i = 0; i < first.length; i++) {
            numbers[i + second.length] = first[i];
        }
    }
}