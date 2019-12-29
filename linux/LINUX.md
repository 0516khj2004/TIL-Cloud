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
$ ls           // 목록 확인
$ cd           // 디렉터리 이동 
$ cp           // 파일 카피
$ vi           // vi 편집키로 파일 열기 
$ systemctl restart network    // centos 네트워크 재시작
$ systemctl restart networking // ubuntu 네트워크 재시작
$ su -student // 사용자(student) 변경
```

## (4) Vi편집기 명령어 정리 












