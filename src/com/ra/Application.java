package com.ra;

import com.ra.model.Product;

import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product(UUID.randomUUID().toString(),"M0123","Tivi",3000,true));
        products.add(new Product(UUID.randomUUID().toString(),"M0234","Tủ lạnh",1500,false));
        products.add(new Product(UUID.randomUUID().toString(),"E0123","Điều hòa",1500,true));
        products.add(new Product(UUID.randomUUID().toString(),"F0123","Máy tính",2000,false));
        products.add(new Product(UUID.randomUUID().toString(),"G0123","Nồi cơm",1000,true));
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Hiển ra danh sách các sp Model bắt đầu bằng M");
            System.out.println("2. Tìm kiếm sản phẩm theo Model (Model là duy nhất trong collection)");
            System.out.println("3. Lấy ra danh sách List<String> model sản phẩm");
            System.out.println("4. Kiểm tra xem trong collection có bất kỳ sản phẩm nào giá > 1000 không?");
            System.out.println("5.Đếm các sản phẩm có cùng mức giá");
            System.out.println("6. Thoát");
            System.out.print("Mời bạn chọn:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    products.stream()
                            .filter(p -> p.getModel().startsWith("M"))
                            .forEach(Product::display);
                    break;
                case 2:
                    System.out.println("Nhập Model muốn tìm:");
                    String model = sc.nextLine();
                    Product foundProduct = products.stream().filter(p -> p.getModel().equals(model)).findFirst().orElse(null);
                    if (foundProduct != null){
                        foundProduct.display();
                    } else {
                        System.err.println("Không thấy sản phẩm");
                    }
                    break;
                case 3:
                    List<String> listByModel = new ArrayList<>();
                    listByModel = products.stream().map(p -> p.getModel()).collect(Collectors.toList());
                    break;
                case 4:
                    if (products.stream().anyMatch(p -> p.getPrice() > 1000)){
                        System.out.println("Có sản phẩm giá  >1000");
                    } else {
                        System.out.println("Không có sản phẩm nào phù hợp");
                    }
                break;
                case 5:
                    Map<Double, List<String>> result = products.stream().collect(Collectors.groupingBy(Product::getPrice, Collectors.mapping(Product::getModel,Collectors.toList())));
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.err.println("Lựa chọn không phù hợp");
            }

        } while (true);
    }
}
