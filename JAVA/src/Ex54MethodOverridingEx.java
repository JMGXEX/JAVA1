// Ex54MethodOverridingEx.java
class Shape { // 도형의 슈퍼 클래스
    public void draw() {
        System.out.println("Shape");
    }
}

class Line extends Shape {
    public void draw() { // 메서드 오버라이딩
        System.out.println("Line");
    }
}

class Rect extends Shape {
    public void draw() { // 메서드 오버라이딩
        System.out.println("Rect");
    }
}

class Circle extends Shape {
    public void draw() { // 메서드 오버라이딩
        System.out.println("Circle");
    }
}

public class Ex54MethodOverridingEx {
    static void paint(Shape p) {
        // Shape을 상속받은 객체들이 매개 변수로 넘어올 수 있음
        p.draw();
        // p가 가리키는 객체에 오버라이딩된 draw() 호출 → 동적 바인딩
    }

    public static void main(String[] args) {
        Line line = new Line();
        paint(line); // Line의 draw() 실행, "Line" 출력

        paint(new Shape());  // Shape의 draw() 실행 → "Shape"
        paint(new Line());   // Line의 draw() 실행 → "Line"
        paint(new Rect());   // Rect의 draw() 실행 → "Rect"
        paint(new Circle()); // Circle의 draw() 실행 → "Circle"
    }
}
