/*
* Week2 Seminar 9,10 Class
*/
/// class property ///
class propPer{
    public name : string = "";
    private _age : number; // private 앞에는 _(언더바) 삽입

    constructor(age : number){
        this._age = age;
    }
}

const pper : propPer = new propPer(35);
pper.name = "Mark";
// pper._age 로는 접근이 불가함 => private
console.log(pper);


/// pritected ///
class protectP { 
    protected _name : string = "Mark";
    private _age : number = null;
}

class protectChild extends protectP {
    constructor(){
        super();

        this._name = "마크";
        // this._age = 35; 접근 불가
    }
}
const pct: protectChild = new protectChild();
// console.log(pct._name + pct._age); 둘 다 접근 불가


/// extend ///
class innerP {
    constructor(protected _name : string, protected _age : number){    }
    // 생성자에 바로 접근지정자와 생성하는 것이 가능

    print() : void{
        console.log(this._name + " " + this._age);
    }

    printName = () : void => { // arrow function 사용 가능
        console.log("이름 : ${this._name}");
    }

    private printAge() : void {
        console.log("나이 : ${this._age}");
    }
}

class innerC extends innerP{
    _name = "Maek Jr.";
}

class innerC2 extends innerP{
    constructor(){ // 자식 생성자는 별도의 인자 받지 않음
        super("Mark Jr.", 5); // super로 부모 생성자 호출 가능
    }
}
// const p : innerC = new innerC(); // 상속받은 부모의 생성자로 생성해야 함
const ipt: innerC = new innerC('',5);
const ipt2 : innerC2 = new innerC2();
ipt.print();


/// getter setter ///
class getsetP{
    private _name : string;
    private _age : number;

    constructor(name : string, age : number){
        this._name = name;
        this._age = age;
    }

    get name() : string{
        return this._name;
    }

    set name(name : string){
        // set시에 추가적인 작업
        this._name = "${name} Min";
    }
}
const gsp: getsetP = new getsetP("Mark",35);
console.log(gsp.name);
gsp.name = "SangYeon";
console.log(gsp.name);


/// singleton pattern ///
class singleton {
    private static Instance : singleton = null;

    public static getInstance() : singleton{
        if(singleton.Instance == null)
            singleton.Instance = new singleton();
        return singleton.Instance;
    }

    private constructor() {}

    print(){
        console.log("singleton class method call");
    }
}
// const sgt : singleton = new singleton(); // 생성자가 private하기 때문에 불가
const sgt : singleton = singleton.getInstance();
sgt.print();