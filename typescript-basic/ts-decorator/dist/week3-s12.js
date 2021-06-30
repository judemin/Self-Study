var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
/*
* Seminar 12 Decorator
*/
/// Class decorator ///
function hello(constructorFn) {
    console.log("Hello World!");
}
function helloFactory(show) {
    if (show) {
        return hello;
    }
    else {
        return null;
    }
}
//@hello
let classDec = class classDec {
    constructor() {
        console.log("new classDec()");
    }
};
classDec = __decorate([
    helloFactory(true)
], classDec);
new classDec();
/// Class Dec advanced ///
function addHello(constructorFn) {
    constructorFn.prototype.hello = function () {
        console.log("Hello in prototype function!");
    };
}
let cDecA = class cDecA {
    constructor() {
        console.log("new cDecA()");
    }
};
cDecA = __decorate([
    addHello
], cDecA);
const cda = new cDecA();
cda.hello(); // spring에서 사용하는 기법중 하나\
/// Method Decorator ///
function editable(canBeEdit) {
    return function (target, propN, description) {
        console.log(canBeEdit);
        console.log(target);
        console.log(propN);
        console.log(description);
        description.writable = false;
    };
}
class methodDec {
    constructor() {
        console.log("new methodDec");
    }
    hello() {
        console.log("methodDec hello func");
    }
}
__decorate([
    editable(true)
], methodDec.prototype, "hello", null);
const md = new methodDec();
md.hello();
md.hello = function () {
    console.log("World!");
};
md.hello();
