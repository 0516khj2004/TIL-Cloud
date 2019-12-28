## 클라우드 - 컴퓨팅 

>**laas ** : 자동화, 자유성, 확장성이 좋음 
 **paas** : platform - heroku 
 **saas **: cloud 환경에서 동작 (메일,git ,,)

설치프로그램

- git
- visual studio
- notepadd++
- node.js

### (1) git  -- sass 

> work>git>herokutest 

- git 올리기

```shell
$ git add .  // 가지고 있는 파일
$ git commit -m "깃 메시지"  
$ git congif --global user.email "개인 이메일"
$ git config --global user.name "개인 이름" // 최초에 한번만 
$ git remote add origin 깃주소 
$ git remote //확인가능 (-v 주소까지 확인)
$ gir push origin master 
```

- git 내려받기

```sh
$ git clone 깃주소  // 최초에 한번만 
$ git pull origin master
```

### (2) heroku -- pass

- local 서버


```shell
heroku toolbelt 설치 
$ heroku ) npm i -g express-generater (expree라는 웹서버 화면 설치)
$ express --session --ejs --css styleus heroku0516
$ heroku0516) npm install
$ npm start (서버 기동,, local:3000 에서 화면 확인) 

heroku서버 이용 -- heroku git 사용
$ heroku0516) heroku login 
$ heroku apps:create heroku0516  (haroku app만들기)
$ git init 
$ heroku git:remote -a heroku0516
$ git add .
$ git commit -m "update"
$ git push heroku master 
```

