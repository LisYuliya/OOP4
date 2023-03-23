public class Main {

    public static void main(String[] args) {
        // Есть классы: GoldenApple -> Apple -> Fruit
        //                             Orange -> Fruit
        // Есть класс Box. Нужно:
        // 1. Организовать его так, чтобы он мог хранить только фрукты какого-то типа
        // 2. Реализовать методы добавления фрукта, пересыпания в другую коробку, получение сумарного веса
        // Ограничения:
        // В коробку с апельсинами нельзя добавить яблоки
        // В коробку с золотыми яблоками нельзя добавить апельсины и яблоки
        // Пересыпать из коробки с золотыми яблоками в коробку с яблоками можно!
        // 3.* Реализовать итерируемость по коробке

        Box<Apple> appleBox = new Box(); 
        Box<Orange> orangeBox = new Box(); 
        Box<GoldenApple> goldenAppleBox = new Box(); 
        Box<Fruit> fruitBox = new Box<>();

        appleBox.add(new Apple(1)); 
        appleBox.add(new GoldenApple(4));
        appleBox.add(new YellowApple(5));
        System.out.println(appleBox.getWeight() + " apple"); 


        orangeBox.add(new Orange(6));
        System.out.println(orangeBox.getWeight() + " orange"); 

        goldenAppleBox.add(new GoldenApple(2));
        goldenAppleBox.add(new YellowApple(2));
        System.out.println(goldenAppleBox.getWeight() + " goldenApple"); 

        goldenAppleBox.moveTo(appleBox); 
        System.out.println(goldenAppleBox.getWeight()  + " goldenApple"); 
        System.out.println(appleBox.getWeight()  + " apple"); 


        appleBox.moveTo(fruitBox);
        orangeBox.moveTo(fruitBox);
        System.out.println(fruitBox.getWeight()  + " fruits"); // 7

        System.out.println("*********************");
        goldenAppleBox.add(new GoldenApple(2));
        goldenAppleBox.add(new YellowApple(22));
        goldenAppleBox.add(new GoldenApple(222));
        goldenAppleBox.add(new YellowApple(2222));

        for (GoldenApple apple: goldenAppleBox) { // должно работать
            System.out.println(apple.getWeight());
        }
       
    }

}
