package org.example;
import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        try {
            InputStream inputStream = Main.class.getClassLoader()
                    .getResourceAsStream("dancers.yaml");
            if (inputStream == null) {
                System.err.println("Файл dancers.yaml не найден");
                return;
            }
            Yaml yaml = new Yaml();
            List<Map<String, String>> list = yaml.load(inputStream);
            List<Dancer> dancers = new ArrayList<>();
            for (Map<String, String> map : list) {
                Dancer dancer = new Dancer();
                dancer.setName(map.get("name"));
                dancer.setStyle(map.get("style"));
                dancers.add(dancer);
            }
            System.out.println("Танцоры");
            for (int i = 0; i < dancers.size(); i++) {
                Dancer dancer = dancers.get(i);
                System.out.println((i + 1) + ". " + dancer.getName() +
                        " — стиль: " + dancer.getStyle());
            }
            System.out.println("____________________________");
            System.out.println("Всего танцоров: " + dancers.size());
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}