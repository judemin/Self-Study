const express = require('express') 
const path = require('path') 
const PORT = process.env.PORT || 5000
// 라우터 호출 필요, 라우터 파일 경로
const router = require('./routes/diary');

var app = express(); 
app.use(express.static(path.join(__dirname, 'public')))
.use('/api/diary',router) // 사용할 api 경로
.set('views', path.join(__dirname, 'views'))
.set('view engine', 'ejs') 
.get('/', (req, res) => res.render('pages/index')) 
.listen(PORT, () => console.log(`Listening on ${ PORT }`));

// 어떤 api call이 들어왔을때 router에서 경로를 잡아준다
// 새로운 주소가 등장해도 새로운 경로와 라우터로 사용 가능하다