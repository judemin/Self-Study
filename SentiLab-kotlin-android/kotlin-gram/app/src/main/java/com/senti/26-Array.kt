package com.senti

fun main(){
    ///  1. 배열  ///
    var arr1 = listOf("1","4","9") // listOf : 수정불가
    var arr2 = mutableListOf("1","2")  // 변칙적인 (mutable) : 수정 가능 => ArrayList처럼

    // arr1.add() // add 존재x
    arr2.add("3") // mutableList에는 추가 가능


    ///  2. 반복문  /// => 향상된 반복문
    for(item in arr1){
        println(item)
    }
    for((index, item) in arr1.withIndex()){ // index를 같이 뽑을 수 있음
        println("$index - $item")
    }
    arr2.removeAt(2) // 인덱스 기준으로 삭제
    arr2.remove("1") // 엘리먼트 기준으로 삭제


    ///  3. Casting  /// 모든 객체 변수들을 담을 수 있는 최상위 객체 => Any  =>  Auto Casting 지원
    var castVar : Any = "Hello World!"
    if(castVar is String){ // is로 자료형 비교
        // (String) castVar; => Java에서는 캐스팅을 따로 해줬어야 함
        println(castVar.length)
        var str : String = castVar
    }
}