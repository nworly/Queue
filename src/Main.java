import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> floors = new LinkedList<>();
        boolean stop = false;

        while (!stop) {
            System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");
            int input = scanner.nextInt();
            if (input == 0) {
                int waitDoorsInSeconds = 10;
                int waitMoveInSeconds = 5;
                int totalSeconds = 0;
                int nextFloor;
                int currentFloor;
                while (!stop) {
                    try {
                        currentFloor = floors.poll();
                        System.out.printf("этаж %d", currentFloor);
                        nextFloor = floors.element();
                        totalSeconds += Math.abs(currentFloor - nextFloor) * waitMoveInSeconds + waitDoorsInSeconds;
                        System.out.print(" -> ");
                    } catch (NoSuchElementException e) {
                        System.out.println(" - этаж 0");
                        System.out.println("Время затраченное лифтом на маршрут = " + totalSeconds + " с.");
                        stop = true;
                    }
                }
            } else if (input > 25 || input < 0) {
                System.out.println("Такого этажа нет в доме");
                continue;
            }
            floors.offer(input);
        }
    }
}
