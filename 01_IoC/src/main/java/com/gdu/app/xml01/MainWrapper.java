package com.gdu.app.xml01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainWrapper {

  public static void ex01() {
    
    //app-context.xml 파일 읽기 (여기에서 <bean> 태그로 정의해둔 객체가 생성됨
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("/xml01/app-context01.xml");
    
    // <bean> 태그로 정의된 객체 가져오기
    Calculator calculator = (Calculator)ctx.getBean("calc"); //ctx.getBean("calc",Calculator.class) 코드와 동일
    
    // 객체 사용해보기
    calculator.add(1, 2);
    calculator.sub(3, 4);
    calculator.mul(5, 6);
    calculator.div(7, 8);
    
    // app-context.xml 파일 닫기
    ctx.close();
  }
  
  public static void ex02() {
    // app-context.xml 파일 읽어서 <bean> 태그로 정의된 객체 만들기
    AbstractXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/xml01/app-context01.xml");
    
    // 객체 가져오기(man, woman) 두가지 방법
    Person man = (Person)ctx.getBean("man");
    Person woman = ctx.getBean("woman",Person.class);
    
    // 객체 확인
    System.out.println(man.getName()+", "+man.getAge());
    man.getCalculator().add(1,2);
    System.out.println(woman.getName()+", "+woman.getAge());
    woman.getCalculator().add(3,4);
   
    // app-context.xml 파일 닫기
    ctx.close();
  }

  public static void main(String[] args) {
    ex01();
//    ex02();
  }

}
