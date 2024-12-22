
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Food[] breakfast = new Food[20];
        int allCalories = 0, item = 0;
        boolean calcCalories = false, sort = false;
        Food count = null;
        for (String it : args) {
            if (it.equals("-calories")) {
                calcCalories = true;
                continue;
            }
            if (it.equals("-sort")) {
                sort = true;
                continue;
            }
            if (it.startsWith("-count=")) {
                String WhatCount = it.substring("-count=".length());
                String[] parts = WhatCount.split("/");
                try {
                    Class<?> myClass = Class.forName("" + parts[0]);
                    if (parts.length == 3) {
                        Constructor<?> constructor = myClass.getConstructor(String.class, String.class);
                        count = (Food) constructor.newInstance(parts[1], parts[2]);
                    } else if (parts.length == 2) {
                        Constructor<?> constructor = myClass.getConstructor(String.class);
                        count = (Food) constructor.newInstance(parts[1]);
                    } else if (parts[0].equalsIgnoreCase("Cheese")) {
                        Constructor<?> constructor = myClass.getConstructor(String.class);
                        count = (Food) constructor.newInstance(parts[0]);
                    }
                } catch (Exception e) {
                    System.out.println("Error");
                }
                continue;
            }
            String[] parts = it.split("/");
            try {
                Class<?> myClass = Class.forName("" + parts[0]);
                if (parts.length == 3) {
                    Constructor<?> constructor = myClass.getConstructor(String.class, String.class);
                    breakfast[item] = (Food) constructor.newInstance(parts[1], parts[2]);
                    if (breakfast[item] instanceof Nutritious) {
                        allCalories += ((Nutritious) breakfast[item]).calcCalories();
                    }
                } else if (parts.length == 2) {
                    Constructor<?> constructor = myClass.getConstructor(String.class);
                    breakfast[item] = (Food) constructor.newInstance(parts[1]);
                    if (breakfast[item] instanceof Nutritious)
                        allCalories += ((Nutritious) breakfast[item]).calcCalories();
                } else if (parts[0].equalsIgnoreCase("Cheese")) {
                    Constructor<?> constructor = myClass.getConstructor(String.class);
                    breakfast[item] = (Food) constructor.newInstance(parts[0]);
                    if (breakfast[item] instanceof Nutritious)
                        allCalories += ((Nutritious) breakfast[item]).calcCalories();
                } else
                    throw new IllegalArgumentException("Некорректные данные ввода");
                item++;
            } catch (ClassNotFoundException e) {
                System.out.println("Класс " + parts[0] + " не найден. Пропускаем данный продукт.");
            } catch (NoSuchMethodException e) {
                System.out.println("Конструктор для класса " + parts[0] + " не найден. Пропускаем данный продукт.");
            } catch (Exception e) {
                System.out.println("Ошибка создания класса " + parts[0] + ": " + e.getMessage());
            }
        }

        if (sort) {
            Arrays.sort(breakfast, 0, item, new Comparator<Food>() {
                @Override
                public int compare(Food o1, Food o2) {
                    if(o1 == null || o2 == null) return 0;
                    int class1 = o1.getName().length();
                    int class2 = o2.getName().length();
                    return Integer.compare(class1, class2);
                }
            });
            System.out.println("Завтрак отсортирован.");
        }

        for (Food it : breakfast) {
            if (it != null) {
                it.consume();
            } else {
                break;
            }
        }
        if (calcCalories) {
            System.out.println("Все калории: " + allCalories);
        }
        if (count != null) {
            int cur = 0;
            for (Food it : breakfast) {
                if (it == null) break;
                if (it.equals(count))
                    cur++;
            }
            System.out.println("Кол-во продуктов " + count.toString() + ": " + cur);
        }
        System.out.println("Хорошего дня!");
    }
}