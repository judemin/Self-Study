/*
* Week2 Seminar 8 Interface
*/
/// Interface basic ///
function hello(person : {name : string; age : number;}) : void {
    console.log("안녕하세요! ${person.name} 입니다.");
}

const p: {name : string; age : number;} = {
    name : "Mark",
    age : 35
};
hello(p);

interface PersonI {
    name : string;
    age : number;
}


function helloI(person : PersonI): void{
    console.log("안녕하세요 ${person.name}");
}

const peri: PersonI = {
    name : "John",
    age : 27
};
helloI(peri);


/// Indexable Type ///
interface pIndx{
    [index : number] : string;
}
const tmp1 : pIndx = {};
tmp1[0] = "mark";
tmp1[100] = "jimmy";

interface pStr{
    name : string;
    [props : string] : string;
}
const tmp2 : pStr = {
    name : "Mark"
};
tmp2.item1 = "coin";
tmp2.item2 = "star";


/// Func in interface ///
interface funcI{
    name : string;
    func() : void;
}

const fi1 : funcI = {
    name : "Mark",
    func : function() : void{
        console.log(this);
    }
};

const fi2 : funcI = {
    name : "Mark2",
    func(): void{
        console.log(this);
    }
}

const fi3 : funcI = {
    name : "Mark3",
    func : () : string => { // arrow function, type overload??
        console.log("Arrow");
        return "Arrow";
    }
}
fi1.func();
fi2.func();
fi3.func();

/// class implement interface ///
interface IPer {
    name : string;
    funcParent() : void;
}

class Per implements IPer{
    name : string;

    constructor(name : string){
        this.name = name;
    }

    funcParent() : void {
        console.log("Parent function");
    }

    funcChild() : void {
        console.log("Child function");
    }
}
const ic1 : IPer = new Per("Mark");
const ic2 : Per = new Per("Jack");
ic1.funcParent();
ic2.funcParent(); ic2.funcChild();