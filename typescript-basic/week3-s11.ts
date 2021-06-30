/*
* Seminar 11 Generic
*/
/// Generic ///
function helloStr(message : string) : string{
    return message;
}

function helloNum(message : string) : string{
    return message;
}
// 더 많은 반복된 같은 형태의 함수들

function helloany(message : any) : any{
    return message;
}

function helloGen<T>(message : T) : T{
    return message;
} // any 대신에 generic을 사용!

function genArr<T>(messages : T[]) : T{
    return messages[0];
}
genArr<string>(["gen","Arr"]); // 리턴값은 "gen"


/// Generic Types ///
type genType = <T>(mesage : T) => T;
const genT: genType = <T>(message: T) : T =>{
    return message;
}


/// Generic Class ///
class genPerson<T>{ 
    private _name : T;
    private _age : number;

    constructor(name : T){
        this._name = name;
    }
}
new genPerson("Mark");
new genPerson(1234);
// new genPerson<string>(35); // 명시적으로 제네릭 타입을 설정하면 오류


/// Generic with extends ///
class genExtend<T extends string | number>{
    private _name : T;
    
    constructor(name : T){
        this._name = name;
    }
}
new genExtend("number");
// new genExtend(false);  // boolean은 상속받지 않았기 때문에 오류


/// Gen with multiple types ///
class mulGen<T, K>{
    private _name : T;
    private _age : K;

    constructor(name : T, age : K){
        this._name = name;
        this._age = age;
    }
}
new mulGen("string",123);


/// type lookup system ///
interface tls{
    name : string;
    age : number;
}

const tlsi: tls = {
    name : "Mark", // key :  value
    age : 35
};

function getTLSProp<T,K extends keyof T>(obj : T, key : K) : T[K]{
    return obj[key];
} // 제네릭 상속

function setTLSProp<T,K extends keyof T>(obj : T,key : K, val : T[K]){
    obj[key] = val;
}

console.log(getTLSProp(tlsi,"name"));
// console.log(getTLSProp(tlsi,"fullname")); // tls의 키값이 아니기 때문에 (k에 포함x) 에러
setTLSProp(tlsi,"name","Anna");
// setTLSProp(tlsi,"name",35); // T[K]의 타입이 string이기 때문에 number 불가
console.log(getTLSProp(tlsi,"name"));