package com.senti

fun main(){
    // 어떠한 value를 찾기 위한 key (JSON도 이렇게 이루어짐)
    // map - key, value => pair

    // mapOf는 수정 불가
    var map1 = mapOf(Pair("name", "Senti")) // Pair에서 자동으로 타입 추론
    // mutable은 수정 가능
    var map2 = mutableMapOf<String,String>() // type 명시
    map2.put("name","Senti")
    map2.put("config","mutable")

    // keys
    println(map2.keys)
    // values
    println(map2.values)

    for(i in map2){
        println(i)
        println(map2.get(i.key))
    }
}