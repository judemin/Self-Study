/*
* Week2 Seminar 7
*/
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
/// Union, TypeAlias ///
var a;
var b; // unionType
b = "스트링";
b = 0;
function test(arg) {
    return arg;
} // function with typeAlias
var ip = {
    name: "Mark",
    age: 35
};
var PersonImpl = /** @class */ (function () {
    function PersonImpl() {
    }
    PersonImpl.prototype.hello = function () {
        console.log("안녕하세요");
    };
    return PersonImpl;
}());
var pi = new PersonImpl();
pi.hello();
var PersonChild = /** @class */ (function (_super) {
    __extends(PersonChild, _super);
    function PersonChild() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return PersonChild;
}(PersonAlias)); // 클래스가 인터페이스 상속 불가
/*
* Week2 Seminar 8
*/ 
