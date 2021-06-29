/*
* Seminar 10 Ex1
*/
class ex1Car {
    private _speed : number = 0; // private 선언시 언더바 주의

    constructor (private _name : string){ // 생성자에 바로 선언
    }

    get speed() : number{
        return this._speed;
    }

    public honk() : void{
        console.log("부우우웅");
    }

    public accelerate(spd : number){
        this._speed += spd;
    }
}
const car : ex1Car = new ex1Car("BENZ");
car.honk();
console.log(car.speed);
car.accelerate(10);
console.log(car.speed);