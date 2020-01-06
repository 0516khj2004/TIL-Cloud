# 리눅스 관리자를 위한 명령어 

## 1. centos - RPM 

> YUM이 나오기전에 주로 사용됨 
>
> 패키지이름 -버전-릴리스번호.CentOS버전.아키텍처.rpm 

```shell
$ lscpu
$ rpm -Uvh 패키지이름.rpm // -U 기존에 있으며 업그레드, 없으면 설치
-v //설치 과정 확인 -h //설치 진행 과정을 # 으로 화면에 출력 
$ rpm -e 패키지 이름 // 패키지 삭제 
$ rpm -qa  패키지이름  // all 패키지가 설치되었는지 확인
$ rpm -qf 파일의 절대경로 //파일이 어떤 패키지와 관련있는지 알 수 있음
$ rpm -ql//패키지에 어떤 파일들이 포함되었는지 확인
$ rpm -qi // 패키지의 상세정보
$ rpm -qip // -p 아직 설치되지 않은 rpm파일 조회 , 어떤 기능을 설치하기 전 rpm파일 안에 해당 기능이 포함되었는지 미리 확인 가능 
```

## 2. centos -YUM

> rpm의 의존성 문제로 yum을 더 많이 사용됨 
>
> rpm패키지를 설치하는 편리한 도구 
>
> yum 의 저장소 url : /etc/yum.repos.d/ 

```shell
$ yum repolist // 현재 활성화된 yum repository 확인
$ yum repolist all // enable 목록까지 확인
$ yum -y install 패키지이름 //패키지 설치---install이 update 포함
$ yum check-update //업데이트 가능한 목록 보기
$ yum update 패키지이름  //업데이트- install할때 update되서 잘 안씀
$ yum remove 패키지 이름// 삭제
$ yum info 패키지 이름 // 패키지의 요약 정보를 보여 줌 
```

- 예시 

```sh
$ yum search apps //'apps'가 들어간 패키지 출력
$ yum -y install docker   //docker 설치함 
$ rpm -qa docker //패키지 설치 확인
$ rpm -ql docker |grep bin //커맨드 목록 
$ systemctl list-unit-files|grep docker //패키지와 관련된 서비스 목록 확인
$ systemctl status docker //패키지 상태 확인
$ systemctl start docker //docker 시작 
$ systemctl enable docker // 재부팅해도 계속 사용
$ yum groupinstall "Development Tools" //패키지 그룹 설치

$ cd /var/cache
$ cd yum 
$ ls -R

$ yum clear all	 // 기존 저장소 목록 지우기	
$ yum repolist   //랜덤으로 미러서버가 바뀐다 
```

## 3.  yum의 작동 흐름 파일 - /etc/yum.repos.d 에 추가하는 방법

- vi /etc/yum.repos.d/CentOS-Base.repo

- yum-config-manager

  ```shell
  $ mkdir /pkg
  $ umount /dev/sr0
  $ mount /dev/se0 /pkg
  $ df -h /pkg
  $ yum-config-manager --add-repo=file:///pak
  $ cat pkg.repo
  $ yum repolist 
  ```

- yum install

  ```shell
  $ yum -y install centos-release-openstack-rocky
  $ yum repolist
  ```

## 4. 우분투  -apt 

> 사용자 전환 
>
> - su -  -> root pw
> - sudo -i -> 사용자 pw 
> - 우분투 패키지 저장소 -> /etc/apt/sources.list 

```shell
$ apt-get update //목차만 다운로드 -정보 업데이트 
$ apt-cache search 키워드 // 캐시에서 키워드 검색
$ apt-get install -y apach2  // 패키지 설치 
$ apt-get remove  // 패키지 삭제 
$ apt-get upgrade  // 패키지 업그레이드 
$ apt-get purge -- 설정파일까지 삭제

$ apt-cache search apache2  
$ apt-get install -y apach2
$ systemctl status apach2
```

## 5. 우분투 -dpkg

```shell
$ dpkg -l // 패키지 목록 보기 
$ dpkg -S /bin/ls  // 특정 파일이 포함된 패키지 설치 
$ dpkg -L zip //패키지가 설치한 파일 목록 검색  
$ dpkg -c _.deb // 패키지의 파일 목록 검색 
$ dpkg -i  // apt와 달리 의존성이 있어 자동으로 패키지들이 설치되지 않고 , 사용자가 일일이 설치해야된다
```

## 6. 파일 압축과 묶기 - tar 

> tar 명령은 원래 여러 파일이나 데렉터리를 묶어서 마그네틱 테이프와 같은 이동식 저장 장치에 보관하기 위헤 사용하는 명령어

```
$ tar cf /tmp/my.tar /etc/sysconfig/  // -c 새로운 tar파일 생성, -f 아카이브 파일이나 테이프 장치 지정 
$ tar cfJ /tmp/my.tar.xz /etc/sysconfig/  //xz파일 생성 
$ tar cfz /tmp/my.tar.gz /etc/sysconfig/  //gzip 파일생성
$ tar cfj /tmp/my.tar.bz2 /etc/sysconfig/ // bzip2 파일로 생성 

$ zip /tmp/my.zip /etc/sysconfig/*   // 파일 압축 ()
$ unzip -l /tmp/my.zip               // 파일 압축 풀기 

$ tar tvf /tmp/my.tar.xz			 // tar 파일의 내용을 출력한다  
$ tar xf /tmp/my.tar.bz2		     // tar 파일에서 원본파일을 추출한다.		 
```

