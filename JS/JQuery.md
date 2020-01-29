# JQuery

### 0. 개요

- jQuery  
  -  모든 브라우저에서 동작하는 클라이언트 자바스크립트 라이브러리
  - 무료로 사용가능한 오픈 소스 라이브러리
- CDN(content delivery network)
  - 콘텐츠를 효율적으로 전달하기 위해 전 세계 여러 지점의 서버에 파일을 저장해두고, 사용자와 가까운 지역에서 해당 파일을 제공해주는 네트워크 시스템을 의미

### 1. 다운로드 

- 직접

  - <script src="../jquery/jquery.js"></script>

- CDN - 인터넷이 되어야함 / 직접가져오는 것보다 더 빠르다 / 양이 적다 

  - <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

### 2. 기본

```
<script>
	$(document).ready(function(){
        alert("jQuery start");
    });
</script>
```

