package com.senti

fun main(){
    ///  1.Class  /// 유사한 기능 (메소드) 들의 집합체
    ///  2.Data Class  /// set, get

    var cls1 = HelloClass() // Type Inference 까지 진행됨
    var cls2 = HelloClass(13)

    println(cls1.age)
    println(cls2.age)

    var person = Person(1,"Senti")
    println("${person.age} - ${person.name}")
}

class HelloClass{
    var age : Int = 0

    init{  // 초기화

    }

    // Def 생성자 존재, 보조 생성자 존재 (오버로딩)
    constructor(){  // 생성자, 클래스가 호출될 때 값을 넘기면서 초기화할 수 있게 함

    } // 기본 생성자
    constructor(arg : Int){
        this.age = arg // 파라미터로 넘겨서 값을 바꿔주는 것 -> Set
    } // 보조 생성자
}

// val : value, var : variable
data class Person(val age : Int, var name : String)