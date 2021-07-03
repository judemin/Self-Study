/*
* Seminar 13 Type Inference
*/
/// Type Guard ///
interface tgPer{
    name : string;
    age : number;
}

interface tgCar{
    brand : string;
    wheel : number;
}

function isPerson(arg : any) : arg is tgPer{
    return arg.name !== undefined; // 다른 로직으로 분류 가능
} // 타입 가드는 함수로 빼서 많이 사용

function tgFunc(obj : tgPer | tgCar){{
    if(isPerson(obj)){
        obj.name;
        obj.age;
        // obj.brand; // Per이기 때문에 brand 접근 불가
    } else{
        obj.brand;
        obj.wheel;
        // obj.age; // Car이기 때문에 age 접근 불가
    }
}}