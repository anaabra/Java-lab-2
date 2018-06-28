import automata.Automata;
import automata.Goods;
import automata.UserAutomata;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class AutomataDemo implements UserAutomata {

    public static ArrayList<Goods> myGoods = new ArrayList();

    public void getGoods(Goods goods) {
        myGoods.add(goods);
        System.out.println("Перечень приобретённых продуктов обновлён!\nПолучено: " + goods);
    }

    public static void main(String[] args) {
        Automata meAutomat = new Automata(new AutomataDemo());
        System.out.println("Автомат " + (meAutomat.on() ? "включен" : "не включен"));
        System.out.println(meAutomat.getMenu());
        System.out.println("Денежные средства " + (meAutomat.coin(1000) ? "успешно внесены" : "Внести не удалось"));
        System.out.println("Заказ " + (meAutomat.choice(3) ? "принят, ожидайте" : "невозможен"));
        System.out.println("Заказ " + (meAutomat.choice(3) ? "принят, ожидайте" : "невозможен"));
        try {
            TimeUnit.SECONDS.sleep(35);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Заказ " + (meAutomat.choice(1) ? "принят, ожидайте" : "невозможен"));
        System.out.println("Получена сдача: " + meAutomat.cancel());
        System.out.println("Автомат " + (meAutomat.off() ? "успешно выключен" : "не может быть выключен!"));
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Автомат " + (meAutomat.off() ? "успешно выключен" : "не может быть выключен!"));

    }
}