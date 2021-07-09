/*
const express = require('express')
const path = require('path')
const PORT = process.env.PORT || 5000

express()
  .use(express.static(path.join(__dirname, 'public')))
  .set('views', path.join(__dirname, 'views'))
  .set('view engine', 'ejs')
  .get('/', (req, res) => res.render('pages/index'))
  .listen(PORT, () => console.log(`Listening on ${ PORT }`))
*/
const express = require('express') 
const path = require('path') 
const PORT = process.env.PORT || 5000 
const mongoose = require('mongoose'); 

var bodyParser = require('body-parser'); 
var app = express(); 
app.use(express.static(path.join(__dirname, 'public')))
.set('views', path.join(__dirname, 'views'))
.set('view engine', 'ejs') 
.get('/', (req, res) => res.render('pages/index')) 
.listen(PORT, () => console.log(`Listening on ${ PORT }`)) 
//body-parser 등록 
app.use(bodyParser.json()); 
app.use(bodyParser.urlencoded({extended : true})); 

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

//위와같은 모델로 쓸것이라고 변수 생성
var datas = mongoose.model('dairy', dairySchema, 'dairy'); 

//다이어리 데이터 모델에 기반하여 저장된 전체 데이터를 불러와서 
datas.find(function(error, dairy){ 
  if(error){ 
    console.log("error ::"+error);
  }
  else{ //항목별로 보기 
    dairy.forEach(function(row) {
       console.log("data :: "+row.title); 
      });
  }});