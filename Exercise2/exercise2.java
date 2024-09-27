// Level 1: Cuboid 클래스 생성

/**
 * Cuboid 클래스는 직육면체를 나타냅니다.
 * 이 클래스는 객체 지향 프로그래밍의 기본 원칙을 보여줍니다.
 */
public class Cuboid {
    // 'private'과 'final' 키워드로 캡슐화와 불변성을 구현합니다.
    private final double height;
    private final double width;
    private final double length;

    /**
     * 생성자: 객체 초기화를 담당합니다.
     * 'this' 키워드는 현재 객체의 필드를 가리킵니다.
     */
    public Cuboid(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    /**
     * volume 메서드: 부피를 계산합니다.
     * 이는 객체의 행동을 나타냅니다.
     */
    public double volume() {
        return height * width * length;
    }

    /**
     * toString 메서드: Object 클래스의 메서드를 오버라이드합니다.
     * 이는 다형성의 한 예입니다.
     */
    @Override
    public String toString() {
        return String.format("cuboid [%.2f x %.2f x %.2f]", height, width, length);
    }
}

// Level 2: SolidCuboid 클래스 생성

/**
 * SolidCuboid 클래스는 Cuboid를 상속받아 밀도를 가진 고체 직육면체를 나타냅니다.
 * 이는 상속(inheritance)의 예시입니다.
 */
public class SolidCuboid extends Cuboid {
    private final double density;

    /**
     * 생성자에서 'super' 키워드를 사용해 부모 클래스의 생성자를 호출합니다.
     */
    public SolidCuboid(double height, double width, double length, double density) {
        super(height, width, length);
        this.density = density;
    }

    /**
     * mass 메서드: 부모 클래스의 volume 메서드를 사용합니다.
     * 이는 코드 재사용의 예시입니다.
     */
    public double mass() {
        return volume() * density;
    }

    /**
     * toString 메서드: 부모 클래스의 toString을 호출하고 추가 정보를 덧붙입니다.
     * 'super' 키워드로 부모 클래스의 메서드를 호출합니다.
     */
    @Override
    public String toString() {
        return String.format("solid-cuboid %s with a mass of %.2f", super.toString(), mass());
    }
}

// Level 3: Sphere 및 SolidSphere 클래스 생성

/**
 * Sphere 클래스는 구를 나타냅니다.
 * 이 클래스는 Cuboid와 유사한 구조를 가지지만, 다른 형태의 3D 객체를 표현합니다.
 */
public class Sphere {
    private final double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double volume() {
        // Math.PI와 Math.pow를 사용한 수학적 계산
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public String toString() {
        return String.format("sphere [%.2f]", radius);
    }
}

/**
 * SolidSphere 클래스는 Sphere를 상속받아 밀도를 가진 고체 구를 나타냅니다.
 * 이는 SolidCuboid와 유사한 패턴을 따릅니다.
 */
public class SolidSphere extends Sphere {
    private final double density;

    public SolidSphere(double radius, double density) {
        super(radius);
        this.density = density;
    }

    public double mass() {
        return volume() * density;
    }

    @Override
    public String toString() {
        return String.format("solid-sphere %s with a mass of %.2f", super.toString(), mass());
    }
}

// Level 4: Shape3D 인터페이스 도입

/**
 * Shape3D 인터페이스는 모든 3D 도형이 가져야 할 공통 메서드를 정의합니다.
 * 이는 추상화(abstraction)의 예시입니다.
 */
public interface Shape3D {
    double volume();
}

// Cuboid와 Sphere 클래스를 수정하여 Shape3D 구현
/**
 * Cuboid 클래스가 Shape3D 인터페이스를 구현하도록 수정합니다.
 * 'implements' 키워드로 인터페이스 구현을 나타냅니다.
 */
public class Cuboid implements Shape3D {
    // 기존 코드 유지
}

/**
 * Sphere 클래스도 Shape3D 인터페이스를 구현하도록 수정합니다.
 */
public class Sphere implements Shape3D {
    // 기존 코드 유지
}

// Level 5: SolidImpl 클래스 도입

/**
 * SolidImpl 클래스는 Shape3D 객체와 밀도를 조합하여 고체 객체의 기능을 제공합니다.
 * 이는 컴포지션(composition)의 예시입니다.
 */
public class SolidImpl implements Shape3D {
    private final Shape3D shape;  // 컴포지션: SolidImpl이 Shape3D를 "가지고 있다"
    private final double density;

    public SolidImpl(Shape3D shape, double density) {
        this.shape = shape;
        this.density = density;
    }

    /**
     * volume 메서드는 내부 shape 객체에 작업을 위임합니다.
     * 이는 위임(delegation) 패턴의 예시입니다.
     */
    @Override
    public double volume() {
        return shape.volume();
    }

    public double mass() {
        return volume() * density;
    }

    @Override
    public String toString() {
        return String.format("SolidImpl of %s with density %.2f", shape, density);
    }
}

// Level 6: Solid 인터페이스 도입 및 위임 패턴 적용

/**
 * Solid 인터페이스는 Shape3D를 확장하여 질량 계산 기능을 추가합니다.
 * 이는 인터페이스 상속의 예시입니다.
 */
public interface Solid extends Shape3D {
    double mass();
}

/**
 * SolidImpl 클래스를 수정하여 Solid 인터페이스를 구현합니다.
 */
public class SolidImpl implements Solid {
    // 기존 코드 유지
}

/**
 * SolidCuboid 클래스를 수정하여 Solid 인터페이스를 구현하고 SolidImpl을 사용합니다.
 * 이는 다중 상속과 유사한 효과를 내는 방법을 보여줍니다.
 */
public class SolidCuboid extends Cuboid implements Solid {
    private final SolidImpl solid;  // 컴포지션

    public SolidCuboid(double height, double width, double length, double density) {
        super(height, width, length);
        this.solid = new SolidImpl(this, density);  // 'this'를 전달하여 자기 자신을 Shape3D로 사용
    }

    /**
     * mass 메서드는 SolidImpl 객체에 작업을 위임합니다.
     */
    @Override
    public double mass() {
        return solid.mass();
    }
}

/**
 * SolidSphere 클래스도 SolidCuboid와 유사한 방식으로 수정합니다.
 */
public class SolidSphere extends Sphere implements Solid {
    private final SolidImpl solid;

    public SolidSphere(double radius, double density) {
        super(radius);
        this.solid = new SolidImpl(this, density);
    }

    @Override
    public double mass() {
        return solid.mass();
    }
}
