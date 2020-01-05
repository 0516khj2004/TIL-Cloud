# LINUX

> - kernel : 현재 제어하는 하드웨어 장치의 지원여부 정보, 하드웨어 성능, 하드웨어를 제어하는 코드들이 들어있다.

- pacage manwger 기반
  - Radhat 계열 :  RHEL, CentOs , Fedora  --- 안전성 좋음, 자동화 떨어짐
  - Debian 계열 :  ubountu , Debien , kuli  -- 도구들 탑제, 인잔성 떨어짐, 자동화 좋음
  - Slackware 계열 : Suse, openSuse -- GUI 도구 (깔끔) 장점 	

## (1) vmware 설정

```shell
$ uname -a                    // 커널확인 
$ ip a                        // ip확인
$ cat etc/*release            // 배포판 버전 확인
$ tty                         // 터미널 번호 확인 6번까지 있음 
$ yum check-update kernel     // 커널 업데이트 
```

##  (2) 리눅스 종료 /재부팅 명령 

- 종료 명령어 
  - poweroff 
  - halt -p                             //전원 off까지 - kii -l  9번 시그널로 시그널 종료
  - init 0
  - shutdown    now          //전원까지 끄는 건 아님, 15 시그널로 종료
-  재부팅 명령어 
  - reboot 
  - init 6
  - shutdown   -r now 
- 런레벨 (실행 수준 확인 )  -- who -r   // 런레벨 확인 
  - init 0	poweroff
  - init 1    단일 사용자 모드
  - init 2    멀티 사용자 모드
  - init 3    멀티 사용자 모드
  - init 4    멀티 사용자 모드 
  - init 5    그래픽(데스크탑) 모드
  - init 6    reboot
  - startx   런레베 3에서 데스크탑 실행하는 명령어

##  (3)리눅스 명령어 정리

```shell
$ pwd          // 현재 위치 확인
$ ls           // 디렉터리 내용을 출력 
 -ㅣ // 상세 정보 -a // 숨김 파일을 포함한 모든 파일 -d // 디렉터리 자체의 정보를 출력 
$ cd  			// 디렉터리 이동
$ cp 현재파일 복사할 위치 // 파일 카피
 -i //카피 할지 확인 -r //디렉터리 카피
$ mv //파일을 다른 디렉터리에 이동하거나 파일명을 바꿀 때
$ touch         //빈 파일 생성
$ grep 패턴 파일  // 해당 파일에 해당 패턴이 포함된 행을 출력 
 -i //대소문자 구분 없음 -in // 대소문자 구분x 라인번호 출력 -c // wc와 같음 라인수 출력 
 -w // 단어로 찾아서 출력  '^단어' // 단어로 시작하는   
$ whreris 파일   // 파일의 위치 
$ which 명령어   // 명령어 파일의 위치를 찾아서 그 경로나 에일리어스 출력
$ vi           // vi 편집키로 파일 열기 
$ cat 		   // 파일 보기 -n 행번호 
$ more 		   // 화면 단위로 파일 내용 출력
$ tail -7      // 파일의 뒤 7줄만 출력
$ man 명령	  // 명령 사용법 화면에 출력
$ passwd 		// 사용자 pw를 변경
$ systemctl restart network    // centos 네트워크 재시작
$ systemctl restart networking // ubuntu 네트워크 재시작
$ su -student // 사용자(student) 변경
```

## (4) 마운트 

> 리눅스 하드 디스크, 시디롬 등 물리적인 장치 파일 시스템으로 인식되어야 사용이 가능하므로 액세스 하기 위해서 특정한 위치에 연결해 주어햐 하는데 그 과정을 마운트라고 한다.

- vm > setting > cd >use ios image file 

  ```shell
  $ df -k  // 디스크 공간 정보를 표시하는 방법 
  $ df -h  // 디스크 파일 읽기 쉬운 단위로 표현
  $ cd /run/media/root/CentOS 7 x86_64/Pachages // 패키지 목록들이 있는 디렉터리로 이동 
  $ ls |wc -l // 목록은 라인 카운트로 확인 
  ```

- 마운트 / 마운트 해제 

  ```shell
  $ mkdir /app // 마운트 시킬 디렉터리 생성
  $ unmount /dev/se0 // 이미 마운트된 이미지 파일을 연결 해제 
  $ mount /dev/se0 /app // 만든 디렉터리에 마운트
  $ losetup -a //할당된 디스크파일 장치 확인 
  ```

## (5)공유 폴더 만들기 

> 윈도우와 리눅스 사이의 공유 폴더 만들기 

-  vm > setting > share forder 

  ```
  $ vmhgfs-fuse /mnt
  $ cd /mnt/share       // 윈도우에서 만든 share폴더 있음을 확인 
  ```

## (6) 리눅스 파일의 종류와 특징 

- 일반 파일 (레귤러 파일) `-` 

- 디렉터리 `d`

  

  <img width="" alt="캡처" src="https://user-images.githubusercontent.com/35915879/71762329-46fa9c00-2f11-11ea-813a-a31af6f9a785.PNG">

  - etc - 리눅스 설정을 위한 각종 파일을 가진 디렉터리
  - boot - 부팅에 필요한 커널 파일을 가진 디렉터리
  - mnt - 파일 시스템을 임시로 마운트하는 디렉터리
  - tmp - 시스템 사용 중에 발생하는 임시 데이터가 저장, 재부팅 하면 삭제됨
  - var - 시스템 운영 중에 발생하는 데이터나 로그 등 내용이 자주 바뀌는 파일이 주로 저장 
	```
  $ file 파일명   // 파일의 종류 확인 
  $ pwd 			// 현재 디렉터리 위치 확인 ~(홈디렉터리)
  $ mkdir -p tmp/mid/han // 중간 단계에 해당 디렉터리가 없으면 자동으로 디렉터리를 만들어 최종 디렉터리 생성
  $ rmdir -p   // 지정한 디렉터리에 비어있다면 삭제가능 (부모디렉터리도)
  $ rm -r     // 비어있지 않은 디렉터리도 삭제 가능 
  ```
  
- 링크 `l`

  - 심벌릭 링크  - 원본 파일을 가르키는  다른 이름으로 파일명을 지정한 것
  - 하드 링크 - 기본파일에 새로운 파일명을 추가로 생성 

  ```
  $ ls -i // 파일의 inode번호 확인- 파일 이름이 달라도 inode번호가 같다면 같은 파일 
  $ ln data1 data1.ln // 하드링크 생성- inode번호 같음
  $ ln -s data1 data1.sl //심벌릭링크 생성-inode 번호 다름
  ```

- 장치 파일(/root/dev) - 하드디스크나 키보드 같은 각종 장치  

    `b` 블록디바이스 - 하드 디스크,cd/dvd `c`문자디바이스  키보드.마우스 등 

## (7) 사용자 관리

> 리눅스는 다중 사용자 관리 시스템이다 - multi user system 
>
> - root 권한 - 슈퍼 유저 기본 pw를 몰라도 pw이 변경 가능하다
> - 사용자 권한 - 기본 pw를 알고 있어야 passwd명령어를 이용하여 변경가능하다. 

- 중요 파일 

  - /etc/passwd    -  모든 사용자에 대한 정보가 들어 있다.

    사용자명:암호:사용자id:그룹id:전체이름:홈 디렉터리:기본 shell

  - /etc/shadow

    사용자명:암호:pw파일 최종 수정일:pw변경최소일:pw변경 최대일:pw만료 경고기간:pw 파기 기간: 계정 만료기간:예약 필드 

  - /etc/group 

    그룹이름:비밀번호:그룹id:그룹에 속한 사용자 이름 

  - /etc/login.defs  

    로그인 정보를 알 수 있는 파일 

- 사용자 생성 

  ```shell
  $ useradd user1 // 사용자 생성 
  $ useradd -u 5000 -g project -c "~my" user1 //사용자id 를 5000번으로 지정, 그룹은 project, 코멘트 달아서 계정생성
  $ useradd -s /bin/csh user1 // 기본 셸을 c셸로 지정 /etc/shells로 확인 가능 
  $ passwd user1 // user1의 pw지정 
  $ su - user1 //user1으로 로그인 
  $ usermod -g docker user1 //user1의 1차그룹을 docker로 변경(-G 2차 그룹)
  $ userdel user1  // 사용자 삭제 
  $ userdel -r user1  // 사용자 삭제하면서 홈 디렉터리까지 삭제 
  $ chage -l user1  // 사용자에 설정된 사항을 확인 
  $ chage -m 1 -M 180 -W 15 -I 365 user1 (하루동안 유지 , 180일 동안 사용, 만료 15일전에 경고문, 365일동안 한번도 로그인 하지 않으면 비활성기간) 
  ```

- 그룹 생성 

  ```shell
  $ groups user1 //user1이 소속된 그룹 출력
  $ groupadd -g 5000 group1  // 그룹id를 5000으로 설정하면서 그룹 생성 
  $ groupmod -n group1 newgroup // 그룹1의 이름을 new그룹으로 변경
  $ groupdel //그룹 삭제 - 해당 그룹을 주요 그룹으로 지정한 사용자가 없어야 한다.
  $ gpasswd -A user1 -a user2 -d user3 newgroup // 뉴그룹의 관리자는 user1 으로하고 user2를 추가하고 user3fmf 제거한다
  $ grep newgroup /etc/gshadow // 그룹 확인 가능
  ```

## (8) 파일과 디렉터리의 소유와 허가권 

<img width="" alt="허가권" src="https://user-images.githubusercontent.com/35915879/71766051-0580e580-2f3f-11ea-8a4f-1dbb07df1526.PNG">

파일의 종류:파일허가권:링크수:파일소유자:파일 소유자 그룹이름: 파일 크기 :마지막 변경 시간: 파일 이름 

최대 권한 -> 일반 파일(110 110 110) 디렉터리 (111 111 111 )  

- 파일 허가권 

  rwx -  read , write , execute  

  --- --- ---  - 소유자 /그룹 /그외 사용자 

- 파일 소유권 -접급 권한의 변경 명령

  ```shell
  $ chmod 사용자 연산자기호 접근권한 문자 
  -R //하위디렉터리까지 모두 변경 
  ```

- 기본 접근 권한 확인하고 변경

  > 마스트 -> 파일이나 디렉터리 생성 시 부여하지 않을 권한을 지정해놓는 것

  ```shell
  $ umask  // 기본 마스크 값 출력 
    022 // 그룹과 기타 사용자에게는 쓰기 권한을 주지 않는다 
  ```

-  특수 접근 권한 

  > 생략된 맨 앞자리는 특수 접근 권한을의미 

  -  0 - > 일반적인 접근 권한
  - 4  - >  setUID( 해당 파일이 생행되는 동안에는 파일을 실행한 사용자의 권한이 아니라 파일 소유자의 권한으로 실행 ) 소유자의 실행권한에  `s` 가 표시  
  - 2 - > setGID (공유 폴더에서 자동으로 해당 위치의 파일을 생성하면 공유 된다. chmod 3770)
  - 1 - > 스티키비트 ( 디렉터리에는 누군나 파일을 생성가능하다  /tmp가 대표적 )