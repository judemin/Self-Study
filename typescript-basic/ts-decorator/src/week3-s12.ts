/*
* Seminar 12 Decorator
*/
/// Class decorator ///
function hello(constructorFn : Function) {
    console.log("Hello World!");
}

function helloFactory(show : boolean){ // 팩토리 스타일
    if(show){
        return hello;
    } else {
        return null;
    }
}

//@hello
@helloFactory(true)
class classDec{
    constructor(){
        console.log("new classDec()");
    }
}
new classDec();


/// Class Dec advanced ///
function addHello(constructorFn : Function){
    constructorFn.prototype.hello = function(){
        console.log("Hello in prototype function!");
    }
}

@addHello
class cDecA {
    constructor(){
        console.log("new cDecA()");
    }
}
const cda = new cDecA();
(<any>cda).hello(); // spring에서 사용하는 기법중 하나


/// Method Decorator ///
function editable(canBeEdit : boolean){
    return function(target : any, propN : string, description : PropertyDescriptor){
        console.log(canBeEdit);
        console.log(target);
        console.log(propN);
        console.log(description);
        description.writable = false;
    }
}

class methodDec {
    constructor(){
        console.log("new methodDec");
    }

    @editable(true)
    hello(){
        console.log("methodDec hello func");
    }
}

const md = new methodDec();
md.hello();
md.hello = function(){
    console.log("World!");
}
md.hello();


/// Property Decorator ///
/// Parameter Decorator ///