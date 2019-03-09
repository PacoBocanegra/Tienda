import java.io.Serializable;

public class Person implements Serializable {
 private String name;
 private int age;
 private int height;
 private int weight;
 private String eyeColor;
 private String gender;
 public Person() {
  // Nothing to do...
 }
 public Person(String name, int age, int height, int weight, String eyeColor, String gender){
   this.name = name;
   this.age = age;
   this.height = height;
   this.weight = weight;
   this.eyeColor = eyeColor;
   this.gender = gender;
 }
 @Override
 public String toString() {
    String all = name + " * " + age + " * " + gender + " * " + weight + " * " + height + " * " + eyeColor + " * ";
    return all;
 }
 public void setWeight(int w) {
     weight = w;
 }
 public int getWeight() {
     return weight;
 }
 public void setAge(int age) {
    this.age = age;
 }
 public int getAge() {
     return age;
 }
 public int getHeight() {
     return height;
 }
 public void setHeight(int h) {
     this.height = h;
 }
 public void setGender(String g) {
     gender = g;
 }
 public String getGender() {
     return gender;
 }
 public void setName(String n) {
     name = n;
 }
 public String getName() {
     return name;
 }
 public void setEyeColor(String e) {
     eyeColor = e;
 }
 public String getEyeColor() {
    return eyeColor;
 }
}
