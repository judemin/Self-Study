/*
* Seminar 11 Iterator
*/
/// Custon Iterable ///
class CustomIterable implements Iterable<string>{
    private _array : Array<string> = ["first","second"];

    [Symbol.iterator]() {
        var nextIndex = 0;

        return { // 팩토리 패턴
            next : () =>{
                return {
                    value : this._array[nextIndex++],
                    done: nextIndex < this._array.length
                }
            }
        }
    }
}
const cIterable =  new CustomIterable();
for(const item of cIterable){
    console.log(item);
}