/*
* Week2 Seminar 7
*/

/// Union, TypeAlias ///
let a : any;
let b: string | number; // unionType

type StringOrNum  = string | number; // typeAlias

b = "스트링";
b = 0;

function test(arg : StringOrNum) : StringOrNum{
    return arg
} // function with typeAlias



/// Difference between Interface and Alias ///
type PersonAlias = { // alias
    name : string;
    age : number;
}

interface IPerson extends PersonAlias{

} // Interface can extend Alias

let ip: IPerson = {
    name :  "Mark",
    age : 35
};

class PersonImpl implements PersonAlias{
    name : string;
    age : number;

    hello(){
        console.log("안녕하세요");
    }
}

let pi: PersonImpl = new PersonImpl();
pi.hello();

// class PersonChild extends PersonAlias{} // 클래스가 인터페이스 상속 불가