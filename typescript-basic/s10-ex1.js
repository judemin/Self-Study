/*
* Seminar 10 Ex1
*/
var ex1Car = /** @class */ (function () {
    function ex1Car(name) {
        this._name = null;
        this._speed = null;
        this._name = name;
        this._speed = 0;
    }
    Object.defineProperty(ex1Car.prototype, "speed", {
        get: function () {
            return this.speed;
        },
        enumerable: false,
        configurable: true
    });
    ex1Car.prototype.honk = function () {
        console.log("부우우웅");
    };
    ex1Car.prototype.accelerate = function (spd) {
        this._speed += spd;
    };
    return ex1Car;
}());
var car = new ex1Car("BENZ");
car.honk();
console.log(car.speed);
car.accelerate(10);
console.log(car.speed);
