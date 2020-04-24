package javacode.interoperability.kotlincode.to.javacode;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class JavaCar {
    private List<Integer> classList;

    public String Color;
    public String Model;
    public String Type;
    public String fuelType;
    public int year;
    private int FCYear;
    private Object someObj;
    public static String staticMember = "Static property in Java Class";

    public JavaCar(String color, String model, String type, String fuelType, int year) {
        Color = color;
        Model = model;
        this.year = year;
        this.Type = type;
        this.fuelType = fuelType;
        this.FCYear = this.year + 20;
        this.classList = new ArrayList<>();
        this.someObj = new Object();
    }


    public Object getSomeObj() {
        return someObj;
    }

    public void setSomeObj(Object someObj) {
        this.someObj = someObj;
    }

    public int getFCYear() {
        return FCYear;
    }

    public void setFCYear(int FCYear) {
        this.FCYear = FCYear;
    }

    public @Nullable String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public @NotNull String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }


    public String getColor() {
        return Color;
    }

    public void setColor(@NotNull String color) {
        Color = color;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

/*    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }*/

    @Override
    public String toString() {
        return "Car{" +
                "Color='" + Color + '\'' +
                ", Model='" + Model + '\'' +
                ", Type='" + Type + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", year=" + year +
                '}';
    }

    //Wild Card functions
    public void add(List<? extends Number> list) {
        for (Number each : list)
            classList.add((Integer)each);
    }

    public void printOnlyIntegerClassOrSuperClass(List<? super Integer> list)
    {
        System.out.println(list);
    }

    public boolean checkYearValidity(int year) throws Exception {
        if (year <= 1990)
            throw new Exception("Not a valid year");
        return true;
    }

    public void passingArrayToVarArgMethod(int count, String[] nameList) {
        variableArgMethod(count, nameList);
    }
    public void variableArgMethod(int num, String... strings) {
        for (String name : strings)
            System.out.println(name);
    }

    public void passingArrayToJavaMethod(int[] years) {
        for (int eachYear: years)
            System.out.println(eachYear);
    }

    public static void staticMemberFunction(String value) {
        System.out.println("Class static member value :: $staticMember");
        System.out.println("Passed value to static function: " + value);
    }

    public void samDemoMethod() {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Executed from a new Thread...");
            }
        }).start();
    }

    public void samDemoMethodUsingLambda() {
        new Thread(() -> System.out.println("Lambda Executed in different thread")).start();
    }

    public void samDemoRunnablePassed(Runnable functionality) {
        new Thread(functionality).start();
    }
}

