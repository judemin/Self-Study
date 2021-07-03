package com.senti

fun main(){ // main 함수
    val finVal : Int = 25 // java에서의 final, 상수 +> 재할당 불가
    var ordVal :  String = "Hello World!" // Int String, Float, Double => ts처럼 자료형 명시
    // TS처럼 타입 추론을 함

    var nullen : String? // null이 들어갈 수 있음
    var nulldis : String // null이 들어갈 수 없는 변수
    // swift도 위와 같이 strict하게 null check

    print(finVal)
    println(ordVal)
    println(hello())
}

fun hello() : String { // String을 반환하는 함수  =>  private String hello()
    return "return";
}