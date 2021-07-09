// DB관련 (연결, 스키마)
const mongoose = require('mongoose'); 

//DB 연결 
const dbAddress = "mongodb+srv://judemin:1234@clustersenti.i1xc7.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
mongoose
  .connect(dbAddress, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
    useCreateIndex: true,
    useFindAndModify: false,
  })
  .then(() => console.log("MongoDB Connected"))
  .catch((err) => console.log(err));

//다이어리 데이터 모델 설정 
var Schema = mongoose.Schema; 

//데이터 형태는 { date : "2020131", title : "test2", imgList : "", content : "아아2" } 
var dairySchema = new Schema(
  { date : String, title : String, imgList : String, content : String}
)


// 누군가 호출했을 때 이렇게 갖다 써 라고 명시
module.exports = mongoose.model('dairy', dairySchema, 'dairy'); 