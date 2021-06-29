/*
* Seminar 10 Ex1 solution
*/
interface ICar2{
    honk() : void;
    accelerate(spd : number) : void;
    getSpeed() : number;
}

class ex1Car2 {
    private _speed : number = 0; // private 선언시 언더바 주의

    constructor (private _name : string){ // 생성자에 바로 선언
    }

    public getSpeed() : number{
        return this._speed;
    }

    public honk() : void{
        console.log("부우우웅");
    }

    public accelerate(spd : number){
        this._speed += spd;
    }
}
const car2 : ex1Car2 = new ex1Car2("BENZ");
car2.honk();
console.log(car2.getSpeed());
car2.accelerate(10);
console.log(car2.getSpeed());