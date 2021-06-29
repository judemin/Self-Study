/*
* Week2 Seminar 8 Interface
*/
/// Interface basic ///
function hello(person) {
    console.log("안녕하세요! ${person.name} 입니다.");
}
var p = {
    name: "Mark",
    age: 35
};
hello(p);
function helloI(person) {
    console.log("안녕하세요 ${person.name}");
}
var peri = {
    name: "John",
    age: 27
};
helloI(peri);
var tmp1 = {};
tmp1[0] = "mark";
tmp1[100] = "jimmy";
var tmp2 = {
    name: "Mark"
};
tmp2.item1 = "coin";
tmp2.item2 = "star";
var fi1 = {
    name: "Mark",
    func: function () {
        console.log(this);
    }
};
var fi2 = {
    name: "Mark2",
    func: function () {
        console.log(this);
    }
};
var fi3 = {
    name: "Mark3",
    func: function () {
        console.log("Arrow");
        return "Arrow";
    }
};
fi1.func();
fi2.func();
fi3.func();
var Per = /** @class */ (function () {
    function Per(name) {
        this.name = name;
    }
    Per.prototype.funcParent = function () {
        console.log("Parent function");
    };
    Per.prototype.funcChild = function () {
        console.log("Child function");
    };
    return Per;
}());
var ic1 = new Per("Mark");
var ic2 = new Per("Jack");
ic1.funcParent();
ic2.funcParent();
ic2.funcChild();
